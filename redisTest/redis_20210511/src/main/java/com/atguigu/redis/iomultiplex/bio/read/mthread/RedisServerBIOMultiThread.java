package com.atguigu.redis.iomultiplex.bio.read.mthread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther zzyy
 * @create 2021-06-01 10:41
 */
public class RedisServerBIOMultiThread
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(6379);

        while(true)
        {
            System.out.println("-----111 等待连接");
            Socket socket = serverSocket.accept();//阻塞1 ,等待客户端连接（可以多次循环执行这行代码，让当前这个serverSocket对象可以接受多个客户端的accpet请求）
            System.out.println("-----222 成功连接");

            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    int length = -1;
                    byte[] bytes = new byte[1024];
                    System.out.println("-----333 等待读取");
                    while((length = inputStream.read(bytes)) != -1)//阻塞2 ,等待客户端发送数据
                    {
                        System.out.println("-----444 成功读取"+new String(bytes,0,length));
                        System.out.println("====================");
                        System.out.println();
                    }
                    inputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            },Thread.currentThread().getName()).start();

            System.out.println(Thread.currentThread().getName());

        }
    }
}

