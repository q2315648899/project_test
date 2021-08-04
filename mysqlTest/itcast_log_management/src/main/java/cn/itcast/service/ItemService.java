package cn.itcast.service;

import cn.itcast.mapper.ItemMapper;
import cn.itcast.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public void insert(Item item){
        //itemMapper.insert(item);
    }

    public void update(Item item){
        //itemMapper.update(item);
    }

    public void delete(Integer id){
        //itemMapper.delete(id);
    }

    public Item selectOne(Integer id){
        //Item item = itemMapper.selectOne(id);
        //return item;
        return new Item();
    }

    public List<Item> selectList(){
        //List<Item> itemList = itemMapper.selectList();
        //return itemList;
        return new ArrayList<>();
    }
}
