package com.atguigu.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auther zzyy
 * @create 2020-10-11 14:33
 */
public class RedisUtils
{
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool=new JedisPool(jedisPoolConfig,"192.168.137.93",6379);
    }

    public static Jedis getJedis() throws Exception {
        if(null!=jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("Jedispool is not ok");
    }


    public static void main(String[] args) throws Exception
    {
        /*
        Jedis jedis = null;
        try
        {
            jedis = RedisUtils.getJedis();
            System.out.println(jedis);

            jedis.set("k1","abc");
            String result = jedis.get("k1");
            System.out.println("-----result: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null && jedis.isConnected()) {
                //不是关闭，而是返回给连接池
                jedis.close();
                jedis = null;
                //System.out.println(jedis.quit());
                //System.out.println(jedis.isConnected());
                //jedis.disconnect();
                //System.out.println(jedis.isConnected());
                //jedis.shutdown();//不可以用
            }
        }*/

        try(Jedis jedis = RedisUtils.getJedis())
        {
            System.out.println(jedis);

            jedis.set("k1","xxx2");
            String result = jedis.get("k1");
            System.out.println("-----result: "+result);
            System.out.println(RedisUtils.jedisPool.getNumActive());//1
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(RedisUtils.jedisPool.getNumActive());// 0


        //-----close()方法执行完成后，目前我们的jedis链接是否还有 or  是个null了？



    }
}
