package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from user")
    List<User> findAll();
}
