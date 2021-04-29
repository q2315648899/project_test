package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.dao.impl.ItemsDaoImpl;
import com.itheima.domain.Items;
import org.junit.Test;

import java.util.List;

/**
 * 要想从数据库中取出数据
 * 必须有四个属性：数据库驱动，连接数据库的地址，数据库用户名称，数据库密码
 */
public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items.getName());
        }
    }
}
