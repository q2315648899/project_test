package com.itheima.mybatis.sqlsession;

/**
 * @Author: wong
 * @Date: 2021/6/14
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     *
     * @return
     */
    SqlSession openSession();
}
