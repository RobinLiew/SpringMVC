package com.robinliew.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import org.springframework.mock.web.MockHttpServletRequest;  
import org.springframework.mock.web.MockHttpServletResponse;  


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.robinliew.Spittle;
import com.robinliew.data.SpittleRepository;

//import org.mockito.Mockito

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
	
//	@Test
//	public void shouldShowRecentSpittles() throws Exception{
//		List<Spittle> exceptedSpittles=createSpittleList(20);
//		SpittleRepository mockRepository=mock(SpittleRepository.class);
//		when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(exceptedSpittles);
//	}
	
	private List<Spittle> createSpittleList(int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles=new ArrayList<Spittle>();
		for(int i=0;i<count;i++){
			spittles.add(new Spittle("Spittle "+i, new Date()));
		}
		return spittles;
	}
}
