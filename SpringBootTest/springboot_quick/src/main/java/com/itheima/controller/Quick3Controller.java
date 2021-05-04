package com.itheima.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "person")
public class Quick3Controller {

    /**
     * 使用@ConfigurationProperties方式可以进行配置文件与实体字段的自动映射，但需要字段必须提供set方
     * 法才可以，而使用@Value注解修饰的字段不需要提供set方法
     */
    private String name;
    private String age;
    private String addr;

    @RequestMapping("/quick3")
    @ResponseBody
    public String quick2() {
        // 获得配置文件的信息
        return "name:" + name + ",age:" + age + ",addr:" + addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
