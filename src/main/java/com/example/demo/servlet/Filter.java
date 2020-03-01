package com.example.demo.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName <a href="dcein520@163.com">Filter</a>
 * @Description Filter测试类，需要继承OncePerRequestFilter,使用@WebFilter注解，
 * servletName属性关联需要服务的servlet的name
 * 也可用urlPattern来进行url映射,进行url映射
 * @Author dcein
 * @Date 2020/2/25 16:32
 **/
@WebFilter(servletNames = "MyServlet")
public class Filter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        request.getServletContext().log("/myServlet this path is executing");
        filterChain.doFilter(request,response);
    }
}
