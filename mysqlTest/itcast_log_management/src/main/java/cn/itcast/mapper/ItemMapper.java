package cn.itcast.mapper;

import cn.itcast.pojo.Item;

import java.util.List;

public interface ItemMapper {

    public void insert(Item item);

    public void update(Item item);

    public void delete(Integer id);

    public Item selectOne(Integer id);

    public List<Item> selectList();

}
