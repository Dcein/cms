package com.example.demo;

import com.example.demo.springboot.Servlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequestEvent;


@SpringBootApplication//springboot启动类注解
@ServletComponentScan(basePackages = "com.example.demo.servlet" )//servlet组件扫描注解
public class DemoApplication {

	/** 
	 * @Author <a href="dcein520@163.com">dcein</a>
	 * @Description springboot入口
	 * @Date 2020/2/23 21:09
	 * @Param * @param null
	 * @return 
	 **/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**springboot API方式实现Servlet**/
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new Servlet2());
		srb.addUrlMappings("/spring/boot");
		srb.addInitParameter("API-servlet2","API-value");
		return srb;
	}



}
