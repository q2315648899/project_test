package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.Item;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
//        userMapper.insert(user);
    }

    public void update(User user){
//        userMapper.update(user);
    }

    public void delete(Integer id){
//        userMapper.delete(id);
    }

    public Item selectOne(Integer id){
//        Item item = userMapper.selectOne(id);
//        return item;

        return new Item();
    }

    public List<User> selectList(){
//        List<User> userList = userMapper.selectList();
//        return userList;

        return new ArrayList<User>();
    }

}
