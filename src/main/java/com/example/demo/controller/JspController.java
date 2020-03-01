package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName <a href="dcein520@163.com">JspController</a>
 * @Description TODO
 * @Author dcein
 * @Date 2020/2/25 19:22
 **/
@Controller
public class JspController {

    @RequestMapping("index")
    public String jspController(Model model){
        model.addAttribute("message","hello world!");
        return "index";
    }
}
