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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickManageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		//set few of the 
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mav.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mav.addObject("message", "Product Submission Successfully!");
			}else if(operation.equals("category")) {
				mav.addObject("message", "Category Submission Successfully!");
			}
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
public ModelAndView showEditProducts(@PathVariable int id) {
		
		ModelAndView mav = new ModelAndView("page");
		
		mav.addObject("userClickManageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product nProduct = productDAO.get(id);
		
		//set the product fetch from database
		mav.addObject("product", nProduct);
	
		return mav;
		
	}
	
	
	//handing product subission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		//handle image validation for new products
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}else {
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
			
		}
		
		
		//check if there are any errors
		if(results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Validation fails for adding the product!");
				
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		//create a new product record;
		if(mProduct.getId() == 0) {
			//create a new product record if id is 0
			productDAO.add(mProduct);
		}else {
			//update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	@RequestMapping(value = "/products/{id}/activation", method=RequestMethod.POST)
	@ResponseBody                         
	public String handleProductActivation(@PathVariable int id) {
		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		//activatin an deactivating based on th value of active field
		product.setActive(!isActive);
		
		//updating the product
		productDAO.update(product);
		
		return (isActive) ? "You have succesfuly deactivated the product width id " + product.getId() : 
			"You have succesfuly activated the product width id " + product.getId();
	}
	//to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	

}
