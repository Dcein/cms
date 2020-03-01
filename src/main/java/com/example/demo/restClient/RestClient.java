package com.example.demo.restClient;

import com.example.demo.controller.User;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName <a href="dcein520@163.com">RestTemplate</a>
 * @Description RestTemplate
 * @Author dcein
 * @Date 2020/2/25 10:47
 **/
public class RestClient {

    public static void main(String[] args) {

        /**
         * @Author <a href="dcein520@163.com">dcein</a>
         * restTemp可以反序列化对象，而且可以适配httpClient
         * httpClient-> ClientHttpRequestFactory -> HttpComponentsClientHttpRequestFactory
         **/
        RestTemplate restTemplate = new RestTemplate();
        User forObject = restTemplate.getForObject("http://localhost:8080//xml/xmlRest", User.class);
        System.out.println(forObject);
    }


}
