package com.atguigu.redis.service;

import cn.hutool.core.date.DateUtil;
import com.atguigu.redis.entities.Product;
import com.atguigu.redis.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2021-05-09 15:54
 */
@Service
@Slf4j
public class JHSABTaskService
{
    @Autowired
    private RedisTemplate redisTemplate;

    //@PostConstruct ，平时注释，用时打开
    public void initJHSAB(){
        log.info("启动AB定时器计划任务淘宝聚划算功能模拟.........."+DateUtil.now());
        new Thread(() -> {
            //模拟定时器，定时把数据库的特价商品，刷新到redis中
            while (true){
                //模拟从数据库读取100件特价商品，用于加载到聚划算的页面中
                List<Product> list=this.products();
                //先更新B缓存
                this.redisTemplate.delete(Constants.JHS_KEY_B);
                this.redisTemplate.opsForList().leftPushAll(Constants.JHS_KEY_B,list);
                this.redisTemplate.expire(Constants.JHS_KEY_B,20L,TimeUnit.DAYS);
                //再更新A缓存
                this.redisTemplate.delete(Constants.JHS_KEY_A);
                this.redisTemplate.opsForList().leftPushAll(Constants.JHS_KEY_A,list);
                this.redisTemplate.expire(Constants.JHS_KEY_A,15L,TimeUnit.DAYS);
                //间隔一分钟 执行一遍
                try { TimeUnit.MINUTES.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

                log.info("runJhs定时刷新..............");
            }
        },"t1").start();
    }

    /**
     * 模拟从数据库读取100件特价商品，用于加载到聚划算的页面中
     */
    public List<Product> products() {
        List<Product> list=new ArrayList<>();
        for (int i = 1; i <=20; i++) {
            Random rand = new Random();
            int id= rand.nextInt(10000);
            Product obj=new Product((long) id,"product"+i,i,"detail");
            list.add(obj);
        }
        return list;
    }
}
