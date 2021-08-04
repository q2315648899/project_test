package cn.itcast.controller;

import cn.itcast.aop.OperateLog;
import cn.itcast.pojo.Item;
import cn.itcast.service.ItemService;
import cn.itcast.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @OperateLog
    @RequestMapping("/insert")
    public Result insert(@RequestBody Item item){
        try {
            itemService.insert(item);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }

    @OperateLog
    @RequestMapping("/update")
    public Result update(@RequestBody Item item){
        try {
            itemService.update(item);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }

    @OperateLog
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            itemService.delete(id);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }

    @OperateLog
    @RequestMapping("/selectOne")
    public Item selectOne(Integer id){
        Item item = itemService.selectOne(id);
        return item;
    }

    @OperateLog
    @RequestMapping("/selectList")
    public List<Item> selectList(){
        List<Item> itemList = itemService.selectList();
        return itemList;
    }

}
