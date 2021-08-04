package cn.itcast.controller;

import cn.itcast.aop.OperateLog;
import cn.itcast.pojo.Item;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @OperateLog
    @RequestMapping("/insert")
    public Result insert(@RequestBody User user){
        try {
            userService.insert(user);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }

    @OperateLog
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        try {
            userService.update(user);
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
            userService.delete(id);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }


    @OperateLog
    @RequestMapping("/selectOne")
    public Item selectOne(Integer id){
        Item item = userService.selectOne(id);
        return item;
    }

    @OperateLog
    @RequestMapping("/selectList")
    public List<User> selectList(){
        List<User> userList = userService.selectList();
        return userList;
    }

}
