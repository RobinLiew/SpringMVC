package com.robinliew.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 该配置类用来配置ContextLoaderListener创建的应用上下文中的bean，
 * 这些bean通常是驱动应用后端的中间层和数据层组件。
 * 
 */
@Configuration
@ComponentScan(basePackages={"com.robinliew"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

}
