package com.tway.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tway.shoppingbackend.dao.CategoryDAO;
import com.tway.shoppingbackend.dao.ProductDAO;
import com.tway.shoppingbackend.dto.Category;
import com.tway.shoppingbackend.dto.Product;
import com.tway.shoppingmall.util.FileUploadUtility;
import com.tway.shoppingmall.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private ProductDAO productDao;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mav = new ModelAndView("page");
		Product nProduct = new Product();
		
		mav.addObject("title", "Manage Products");
		mav.addObject("userClickManageProducts", true);
		
		
		//set few of the 
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mav.addObject("product", nProduct);
		
		
		
		if(operation != null) {
			if(operation.equals("product")) {
				mav.addObject("message", "Product Submission Successfully!");
			}
		}
		
		return mav;
		
	}
	
	//handing product subission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		new ProductValidator().validate(mProduct, results);
		
		//check if there are any errors
		if(results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Validation fails for adding the product!");
				
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		//create a new product record;
		productDao.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategory(){
		
		return categoryDao.list();
		
	}
	
	
	

}
