package com.itheima.dao.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception{
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            // 先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql://192.168.137.90:3306/demo_01", "root", "itcast");
            // 获取真正操作数据的对象
            pst = connection.prepareCall("select * from items");
            //  执行数据库查询操作
            rs = pst.executeQuery();
            // 把数据库结果集转化成java的list集合
            while (rs.next()){
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items );
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            connection.close();
        }
        return list;
    }
}
