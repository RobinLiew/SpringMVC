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
import com.robinliew.web.SpitterController;


/**
 * 测试代码
 * Spring包含的一种mock Spring MVC并针对控制器执行HTTP请求的机制
 * @author RobinLiew
 *
 */
public class SpitterControllerTest {
	@Test
	public void shouldShowRegistration() throws Exception{
//		SpitterController controller=new SpitterController();
//		//搭建MockMvc
//		MockMvc mockMvc=standaloneSetup(controller).build();
//		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}
	
}
