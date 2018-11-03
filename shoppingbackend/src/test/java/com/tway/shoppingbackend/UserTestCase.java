package com.tway.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tway.shoppingbackend.dao.UserDAO;
import com.tway.shoppingbackend.dto.Address;
import com.tway.shoppingbackend.dto.Cart;
import com.tway.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tway.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add Usre!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nager");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumabi");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link the user with the address using user id;
		address.setUserId(user.getId());
		
		//add teh address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());		
			
			//add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("101/B Jadoo Society, Krissh Nager");
			address.setAddressLineTwo("Near Kaabil Store");
			address.setCity("Mumabi");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setBilling(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			
		}
		
		
		
		
		
	}
	
	
	

}
