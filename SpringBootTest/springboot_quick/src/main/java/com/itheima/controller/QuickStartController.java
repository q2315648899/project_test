package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartController {

    @ResponseBody
    @RequestMapping("/quick")
    public String quick() {
        return "nihao springboot";
    }
}
