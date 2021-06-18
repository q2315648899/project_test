package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;

/**
 * 账户的持久层实现类
 *
 * @Author: wong
 * @Date: 2021/6/18
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
