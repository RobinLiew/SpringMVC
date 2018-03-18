package com.robinliew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robinliew.data.SpittleRepository;
import com.robinliew.domain.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpittleRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpittleRepository spitterRepository){
		this.spitterRepository=spitterRepository;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "registerForm";
	}
	
	
	/*
	 * 当InternalResourceViewResolver看到视图格式中的"redirect:"前缀时，它就知道要将其解析为重定向的规则，而不是视图名称。
	 * 而它发现视图格式中以"forward:"作为前缀时，请求将会前往（forward）指定的URL路径，而不再是重定向。
	 * 
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration( Spitter spitter){//@Valid  ,Errors errors
//		if(errors.hasErrors()){
//			return "registerForm";
//		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+spitter.getUsername();//重定向到基本信息页
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username,Model model){
		Spitter spitter=spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
}
