package com.example.demo.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName <a href="dcein520@163.com">ImspUser</a>
 * @Description TODO
 * @Author dcein
 * @Date 2020/2/28 13:36
 **/
@Data

public class ImspUser {

    private int id;

    private String mobileNo;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = this.getCurrentDate();

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = this.getCurrentDate();

    private Date getCurrentDate(){
        return new Date(System.currentTimeMillis());
    }
}
