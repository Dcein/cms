package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FrontController
 * @Description TODO
 * @Author dcein
 * @Date 2020/2/23 16:05
 * @Version 1.0
 **/
@RestController
public class FrontController {

    @GetMapping("/getString")
    public String getString(){
        String s = "test success!";
        return s;
    }

}
