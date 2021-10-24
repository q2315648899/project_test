package com.atguigu.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
class Redis20210511ApplicationTests
{

    @Test
    void contextLoads()
    {
    }


    @Test
    public void t1()
    {
        System.out.println(new Date().getTime());
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(new Date().getTime());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
    }

    @Test
    public void t2()
    {
        System.out.println(Math.sqrt(4));
    }


    @Test
    public void t3()
    {

        Set<Integer> hashCodeSet = new HashSet<>();

        for (int i = 0; i <200000; i++) {
            int hashCode = new Object().hashCode();
            if(hashCodeSet.contains(hashCode)) {
                System.out.println("出现了重复的hashcode: "+hashCode+"\t 运行到"+i);
                //break;
            }
            hashCodeSet.add(hashCode);
        }


        new Object().hashCode();
    }

    @Test
    public void t4()
    {
        System.out.println(1073741823 & 1048635960);
    }
}