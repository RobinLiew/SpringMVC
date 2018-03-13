package com.robinliew.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;//这样导入可以使我们直接使用类中静态成员与方法，使用枚举类型
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明一个控制器
 * @author RobinLiew
 *
 */
@Controller  //该注解是基于@Component注解的，用于自动装配
public class HomeController {
	
	@RequestMapping(value="/",method=GET) 
	public String home(){
		return "home"; //视图名为home，DispatcherServlet会要求视图解析器将这个逻辑名称解析为实际的视图。
	}
}
