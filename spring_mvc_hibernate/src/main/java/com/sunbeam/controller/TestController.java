package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	public TestController() {
		System.out.println("in ctor"+getClass());
	}
	
	@GetMapping("/multiply")
	public String multiplyNos(Model modelMap,@RequestParam int num1, @RequestParam int num2) {
		//o.s.ui.Model - if , represents a holder of model attribute
//		System.out.println("in  multiply"+modelMap+"",num1*num2);//empty map{}

		
		modelMap.addAttribute("multiply_result",num1*num2);
		return "/test/result";//AVN-:webinf/views/test/result.jsp
	}
}
