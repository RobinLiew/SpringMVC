package com.robinliew.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;


/**
 * 测试代码
 * Spring包含的一种mock Spring MVC并针对控制器执行HTTP请求的机制
 * @author RobinLiew
 *
 */
public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception{
		HomeController controller=new HomeController();
		//搭建MockMvc
		MockMvc mockMvc=standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}
