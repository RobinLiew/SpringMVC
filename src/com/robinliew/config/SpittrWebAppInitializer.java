package com.robinliew.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.robinliew.filter.MyFilter;

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
	
	/**
	 * 在AbstractAnnotationConfigDispatcherServletInitializer将DispatcherServlet注册到Servlet容器中之后，就会调用
	 * customizeRegistration()，并将Servlet注册后得到的Registration.Dynamic传递进来。通过重载customizeRegistration()
	 * 方法，我们可以对DispatcherServlet进行额外的配置。
	 * 
	 * 借助ServletRegistration.Dynamic我们能够完成多项任务，包括通过调用setLoadOnStartup()设置load-on-startup优先级，通过setInitParameter()
	 * 设置初始化参数，通过调用setMultipartConfig()配置Servlet3.0对multipart的支持。
	 * 
	 * 下面我们使用DispatcherServlet的registration来启用multipart请求。
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		/*假设我们想限制文件的大小不超过2MB，整个请求不超过4MB，而且所有的文件都要写到磁盘中*/
		registration.setMultipartConfig(
				new MultipartConfigElement("/tmp/spittr/uploads",2097152,4194304,0));//将上传文件的临时存储目录设置在"/tmp/spittr/uploads"中。
				/*构造器能接收的参数除了临时路径的位置，其他的构造器所能接收的参数包括：
				 * 1.上传文件的最大容量。默认没有限制；
				 * 2.整个multipart请求的最大容量（以字节为单位），不会关心有多少个part以及每个part的大小。默认是没有限制的。
				 * 3.在上传过程中，如果文件大小达到了一个指定最大容量（以字节为单位），将会写入到临时文件路径中。
				 * 		默认值为0，也就是会将所有上传文件都会写入到磁盘上，
				 */
	}

	/**
	 * 如果只是注册Filter，并且该Filter只会映射到Dispatcher上的话，这是一种快捷方式(不用在MyServletInitializer中注册)。
	 * 该方法返回的所有Filter都会映射到DispatcherServlet上。
	 */
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new MyFilter()};
	}
}
