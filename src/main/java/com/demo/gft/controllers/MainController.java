package com.demo.gft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index.html");
		
		return mv;
		
		
	}
	
	@RequestMapping("about")
	public ModelAndView sobre() {
		
		ModelAndView mv = new ModelAndView("about.html");
		
		return mv;
		
	}
}
