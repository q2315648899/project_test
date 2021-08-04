package cn.itcast.mapper;

import cn.itcast.pojo.Item;
import cn.itcast.pojo.User;

import java.util.List;

public interface UserMapper {

    public void insert(User user);

    public void update(User user);

    public void delete(Integer id);

    public Item selectOne(Integer id);

    public List<User> selectList();

}
