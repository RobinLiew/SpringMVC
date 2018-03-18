package com.robinliew.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.robinliew.domain.Spittle;
import com.robinliew.web.HomeController;


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
	
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		//mock方法暂时有点小问题
		
	}
	
	private List<Spittle> createSpittleList(int count){
		
		return null;
	}
}
