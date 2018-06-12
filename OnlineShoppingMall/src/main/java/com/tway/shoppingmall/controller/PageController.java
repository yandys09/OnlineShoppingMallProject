package com.tway.shoppingmall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dao.ProductDAO;
import com.tway.shoppingbackend.dto.Category;
import com.tway.shoppingbackend.dto.Product;



@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
		
	@RequestMapping(value= {"/", "/home", "/index"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		
		logger.info("inside PageController index method - INFO");
		logger.debug("inside PageController index method - DEBUG");
		
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
	
	
	/**
	 * Viewing a single product
	 * 
	 */
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		
		ModelAndView mav = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//----------------------------------------------------------
		
		mav.addObject("title", product.getName());
		mav.addObject("product", product);
		
		mav.addObject("userClickShowProduct", true);
		
		return mav;
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
