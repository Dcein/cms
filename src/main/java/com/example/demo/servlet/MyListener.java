package com.example.demo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName <a href="dcein520@163.com">MyListener</a>
 * @Description TODO
 * @Author dcein
 * @Date 2020/2/25 16:46
 **/
@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre){
        ServletContext servletContext = sre.getServletContext();
        servletContext.log("Listener Initialized!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        ServletContext servletContext = sre.getServletContext();
        servletContext.log("Listener Destroyed!");
    }
}
