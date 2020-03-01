package com.example.demo.springboot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName <a href="dcein520@163.com">Servlet2</a>
 * @Description Servlet API方式实现,不需要写注解了，但是要继承HttpServlet.
 * 在启动类通过bean注册ServletRegistrationBean
 * @Author dcein
 * @Date 2020/2/25 17:11
 **/
public class Servlet2 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servlet2 = req.getParameter("API-servlet2");
        req.getServletContext().log("Servlet2 is executing!" + servlet2);
    }
}
