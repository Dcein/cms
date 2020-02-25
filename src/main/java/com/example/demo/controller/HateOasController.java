package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @ClassName HateOasController
 * @Description HATEOAS服务发现
 * @Author dcein
 * @Date 2020/2/23 21:01
 * @Version 1.0
 **/
@RestController
public class HateOasController {

    @Bean
    public User currentUser(){
        User user = new User();
        user.setName("currentUser");
        user.setAge(20);
        return user;
    }

    @Autowired
    @Qualifier("currentUser")
    private User user;

    /**
     *直接获取user
     **/
    @GetMapping(path = "/hateoas/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(){
        return user;
    }

    /**
     * 向user中设置值
     **/
    @GetMapping(path = "/hateoas/setUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUser(@RequestParam String name ){
        user.setName(name);
        Link link = linkTo(HateOasController.class).slash(user).withSelfRel();
        //暴漏出一个链接
        user.add(link);
        return user;
    }



}
