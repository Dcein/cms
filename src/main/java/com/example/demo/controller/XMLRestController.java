package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JSONRestController
 * @Description xml测试
 * @Author dcein
 * @Date 2020/2/23 18:53
 * @Version 1.0
 **/
@RestController
public class XMLRestController {

    @GetMapping(path = "/xml/xmlRest", produces = MediaType.APPLICATION_XML_VALUE)
    public User xmlController(){
        User user = new User();
        user.setName("Your Name XML");
        user.setAge(16);
        return user;
    }
}
