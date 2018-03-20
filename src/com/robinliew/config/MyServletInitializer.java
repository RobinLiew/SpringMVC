package com.robinliew.config;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import com.robinliew.filter.MyFilter;
import com.robinliew.servlet.MyServlet;

/**
 * 按照AbstractAnnotationConfigDispatcherServletInitializer的定义，它会创建DispatcherServlet和ContextLoaderListener。
 * 但是，如果你想注册其他的Servlet、Filter或Listener的话，我们可以借助Java的初始化器(initializer)定义任意数量的初始化类。
 * 最简单的方式就是实现Spring的WebApplicationInitializer接口。
 * @author RobinLiew
 *
 */
public class MyServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//注册Servlet
		Dynamic myServlet=servletContext.addServlet("myServlet", MyServlet.class);
		//映射Servlet
		myServlet.addMapping("/custom/**");
		
		//注册Filter
		javax.servlet.FilterRegistration.Dynamic filter=servletContext.addFilter("myFilter", MyFilter.class);
		//添加Filter的映射路径
		filter.addMappingForUrlPatterns(null, false, "/custom/**");
		
		/*基本的multipart配置*/
		/*DispatcherServlet ds=new DispatcherServlet();
		Dynamic registration=servletContext.addServlet("appServlet", ds);
		registration.addMapping("/");
		registration.setMultipartConfig(
				new MultipartConfigElement("/tmp/spittr/uploads"));*/
	}

}
