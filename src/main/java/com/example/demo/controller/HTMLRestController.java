package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HTMLRestController
 * @Description htm rest接口相关
 * @Author dcein
 * @Date 2020/2/23 16:52
 * @Version 1.0
 **/
//REST响应示例
@RestController
public class HTMLRestController {

    //演示html的REST风格以html形式返回响应
    @RequestMapping(path = {"/html/demo1" ,"/html/demo2"} , method = {RequestMethod.POST,RequestMethod.GET})
    public String htmlCode(){
        String htmlString = "<html><body><h1>Hello world!</h1></body></html>";
        return htmlString;
    }

    //GetMapping映射请求
    @GetMapping(path = "/stringCode")
    public String stringCode(){
        return "Hello World!";
    }

    //取请求路径中的参数值,形参使用@PathVariable注解
    @GetMapping(path = "/path/getPathVal/{message}")
    public String getPathVal(@PathVariable String message){
        return message;
    }

    /**
     * 取请求路径中的参数值,使用@RequestParam,
     * value属性，用于指明请求路径后面参数的属性名(p为后面?p=".....")，不说明为方法参数名
     * required属性，false为不要参数名
     * defaultValue属性，如果没有值默认为空
     * 也可用HttpServletRequest获取
     */
    @GetMapping(path = "/path/getParam")
    public String getParam(@RequestParam(value = "p1",required = false,defaultValue = "Empty") String param, HttpServletRequest request){
        String req = request.getParameter("p2");
        return "first param = "+param+",second param ="+req;
    }

    @GetMapping(path = "/path/httpEntity")
    public HttpEntity<String> httpEntity(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("headerName","headerValue");
        ResponseEntity responseEntity = new ResponseEntity("I AM BODY",httpHeaders, HttpStatus.MULTI_STATUS);
        return responseEntity;


    }

}
