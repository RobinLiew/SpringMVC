package com.robinliew.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @author RobinLiew
 *
 */
@Configuration
@EnableWebMvc  //表示启用SpringMVC
@ComponentScan("com.robinliew.web")  //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 配置JSP视图解析器
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver=
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	/**
	 * 配置静态资源的处理
	 * @param configurer
	 */
	public void configureDedfaultServletHandling(DefaultServletHandlerConfigurer configurer){
		
	}
}
