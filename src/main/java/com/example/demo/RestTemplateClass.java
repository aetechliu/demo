package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration         
//如果没有这个配置类，启动的时候会出现 DemoController.java中的restTemplate不能被@Autowired产生bean的错误，无法自动加载
public class RestTemplateClass extends RestTemplate {
	//下面这个方法可以不要 只是为了在控制台查看这个类什么时候被加载
	 public RestTemplateClass() {
        System.out.println("RestTemplateClass容器启动初始化。。。");
     }
}