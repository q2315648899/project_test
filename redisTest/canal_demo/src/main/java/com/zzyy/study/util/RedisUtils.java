package com.zzyy.study.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auther zzyy
 * @create 2020-10-11 14:33
 */
public class RedisUtils
{
    public static JedisPool jedisPool;

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


    /*public static void main(String[] args) throws Exception
    {
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
    }*/
}
