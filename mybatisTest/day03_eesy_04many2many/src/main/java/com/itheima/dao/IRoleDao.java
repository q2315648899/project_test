package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Author: wong
 * @Date: 2021/6/16
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll();
}
