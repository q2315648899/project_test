package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 控制器类
@Controller
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path="/hello")//没有默认值，如果不配置method， 则以任何请求形式 RequestMethod.GET， RequestMethod.POST， RequestMethod.PUT， RequestMethod.DELETE都可以访问得到。
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

}
