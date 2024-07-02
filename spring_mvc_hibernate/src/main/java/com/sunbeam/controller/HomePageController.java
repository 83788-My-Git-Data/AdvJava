package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory cls level 
public class HomePageController {

	public HomePageController() {
		System.out.println("in ctor:"+getClass());
	}
	
	//handlerMapping
	//key
	//value-com.sunbeam.controller.HomePageController.renderHomePage.re
	@RequestMapping("/")
	public String renderHomePage()
	{
		System.out.println("in render home page");
		return "/index";
	}
}
