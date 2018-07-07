package com.tway.shoppingmall.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tway.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		//whether file has been seleted or not
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			
			return;			
		}
		
		
		

	}

}
