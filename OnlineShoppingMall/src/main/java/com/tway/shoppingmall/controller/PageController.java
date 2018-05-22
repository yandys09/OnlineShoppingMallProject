package com.tway.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dto.Category;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
		
	@RequestMapping(value= {"/", "/home", "/index"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		
		mv.addObject("title", "ºÓ«Œ∏Ù »®");
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome",  true);
		
		
		return mv;
	}
		
	
	@RequestMapping(value= "/about" )
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About US");
		mv.addObject("userClickAbout",  true);
		
		return mv;
	}
	
	@RequestMapping(value= "/contact" )
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact US");
		mv.addObject("userClickContact",  true);
		
		return mv;
	}
	
	@RequestMapping(value= {"/show/all/products"} )
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title", "¿¸√º ªÛ«∞");
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",  true);
		
		
		return mv;
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"} )
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
				
		//categoryDAO to fetch a single category;
		Category category = null;
		category = categoryDAO.get(id);
		
		
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",  true);
		
		
		return mv;
	}
	
	
/*	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if(greeting == null) {
			greeting = "Hello there";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting );
		
		return mv;
	}
	
	@RequestMapping(value = "/test2/{greeting}")
	public ModelAndView test2(@PathVariable("greeting") String greeting) {
		if(greeting == null) {
			greeting = "Hello there";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting );
		
		return mv;
	}*/
	
	
	
}
