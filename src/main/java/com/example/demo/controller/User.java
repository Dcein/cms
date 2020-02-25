package com.example.demo.controller;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName User
 * @Description json测试pojo类
 * @Author dcein
 * @Date 2020/2/23 18:55
 * @Version 1.0
 **/
public class User extends RepresentationModel {

    private String name;

    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
