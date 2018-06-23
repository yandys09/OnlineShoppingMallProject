package com.tway.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dto.Category;
import com.tway.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDao;
	
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		
		ModelAndView mav = new ModelAndView("page");
		
		mav.addObject("userClickManageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		//set few of the 
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mav.addObject("product", nProduct);
		
		return mav;
		
	}
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategory(){
		
		return categoryDao.list();
		
	}
	
	
	

}
