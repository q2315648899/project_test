package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * @Author: wong
 * @Date: 2021/6/18
 */
public class client {
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
