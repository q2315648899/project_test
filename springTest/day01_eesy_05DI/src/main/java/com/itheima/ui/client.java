package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * @Author: wong
 * @Date: 2021/6/18
 */
public class client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * @param args
     */
    public static void main(String[] args) {
        //--------ApplicationContext----------
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        as.saveAccount();

        IAccountService as = (IAccountService) ac.getBean("accountService2");
        as.saveAccount();
    }
}
