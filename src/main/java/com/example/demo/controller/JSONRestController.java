package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JSONRestController
 * @Description json测试
 * @Author dcein
 * @Date 2020/2/23 18:53
 * @Version 1.0
 **/
@RestController
public class JSONRestController {

    /**
     * 当服务段代码接收到请求时，先看能不能匹配xml的，若能匹配则首先匹配xml的解析方式
     * 没有的话使用json
     * 这个地方可以强制转化为json数据格式使用producer MediaType.APPLICATION_JSON_VALUE,强制转化为json
     * @return
     */
    @GetMapping(path = "/json/jsonRest",produces = MediaType.APPLICATION_JSON_VALUE)
    public User jsonController(){
        User user = new User();
        user.setName("Your Name");
        user.setAge(18);
        return user;
    }
}
