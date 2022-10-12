package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//使用的是@RestController这个注解，而不是@Controller
@RestController
public class APIController {
	
	@Autowired
    private CityMapper cm;
	
	@GetMapping(value = "/api")
	public List<CityInfo> api(Model model) {
		
		List<CityInfo> cityLs = cm.allCity();
		//返回的不是网页模板的路径，在浏览器直接访问，得到的是一个json格式的返回结果。
		//json是一种数据格式。根据CityInfo.java中定义的属性(name,country)生成。这里会生成如下形式的json数据。
//		[{
//			"name": "Tokyo",
//			"country": "Japan"
//		}, {
//			"name": "Yokohama",
//			"country": "Japan"
//		},
//		 ...]
		return cityLs;
	}
}
