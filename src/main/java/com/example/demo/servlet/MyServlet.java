package com.example.demo.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName <a href="dcein520@163.com">MyServlet</a>
 * @Description Servlet注解方式实现，需要及继承HttpServlet这个抽象类，
 * 需要在启动类上加注解@ServletConmponentScan
 * @Author dcein
 * @Date 2020/2/25 12:08
 **/
@WebServlet(
        name = "MyServlet",
        urlPatterns = "/myServlet",
        initParams = {
                @WebInitParam(name = "initParamName",value = "initParamValue")
        }
)
public class MyServlet extends HttpServlet {

        private String value;

        //servlet容器装载好的时候会调用init方法，服务进来时调用doGet/doPost...
        public void init(ServletConfig config){
                value = config.getInitParameter("initParamName");
        }

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
                Writer writer = res.getWriter();
                writer.write("<html><body><h1>This WebInitParam Value is:"+value+"</h1></body></html>");
        }


}
