package com.robinliew.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robinliew.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	
}
