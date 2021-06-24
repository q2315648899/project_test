package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileuoload1() throws Exception {
        System.out.println("文件上传...");
        return "success";
    }

}
