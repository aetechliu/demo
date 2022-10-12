package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
//@RestController
public class DemoController {
	
	@Autowired
    private CityMapper cm;
	
	//为了使用以下对象，要追加RestTemplateClass.java
	@Autowired
    RestTemplate restTemplate;
	
	//static 类变量。final表示URL这个变量的值不能被改变，保证不会不小心改掉这个值。
	public static final String URL = "http://localhost:8090/api";

	//直接访问数据库获取数据
	@GetMapping(value = "/z")
	public String test(Model model) {
		
		List<CityInfo> cityLs = cm.allCity();
		
		model.addAttribute("citys", cityLs);
		
		return "z";
	}
	
	//访问API的方式获取数据
	@GetMapping(value = "/fromapi")
	public String getTestResponse(Model model) {
		
		List<CityInfo> cityLs = restTemplate.getForObject(URL, List.class);
		model.addAttribute("citys", cityLs);
		
		return "z";
	}
	//getForObject传参的写法
	//https://www.csdn.net/tags/OtTacg1sMTI1NDUtYmxvZwO0O0OO0O0O.html
}
