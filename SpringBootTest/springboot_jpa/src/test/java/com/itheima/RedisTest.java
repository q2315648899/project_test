package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        /*首先得启动redis服务，本示例是启动“D:\传智播客开发代码\JAVAEE就业\
        20210114(需拷贝到华为笔记本)\黑马JAVA57期(2019IDEA版)\
        63.会员版(2.0)-就业课(2.0)-Spring Boot\SpringBoot基础\软件\redisbin\redis-server.exe”windows端的redis服务*/
        // 1、从redis中获得数据，数据的形式 Json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        // 2、判断redis中是否存在数据
        if (null == userListJson) {
            // 3、不存在数据 从数据库查询
            List<User> all = userRepository.findAll();
            // 4、将查询出的数据存储到redis缓存中
            // 向将list集合转换成json格式的字符串 使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);

            System.out.println("===============从数据库获得user的数据===============");
        } else {
            System.out.println("===============从redis缓存获得user的数据===============");
        }
        // 4、将数据在控制台打印
        System.out.println(userListJson);
    }
}
