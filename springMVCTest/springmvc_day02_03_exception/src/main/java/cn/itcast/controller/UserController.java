package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException执行了...");
        // 模拟异常
        int a = 10 / 0;
        return "success";
    }

}
