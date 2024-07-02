package com.sunbeam.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/allshow")
	public String showAllCat(Model map)
	{
		System.out.println("in showAllCat page");
		map.addAttribute("categories",categoryService.getAllcategory());
		return "/category/catList";
	}
	
	
}
