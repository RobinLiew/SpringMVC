package com.robinliew.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动的配置
 * DispatcherServlet和Spring应用上下文，两个应用上下文一个由DispatcherServlet创建，
 * 一个由ContextLoaderListener创建
 * @author RobinLiew
 *
 */
public class SpittrWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
		/*ContextLoaderListener加载web应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。*/
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
		/*DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的bean。*/ 
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};//将DispatcherServlet映射到“/”
	}

}
