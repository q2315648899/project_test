package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @Author: wong
 * @Date: 2021/6/14
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);
}
