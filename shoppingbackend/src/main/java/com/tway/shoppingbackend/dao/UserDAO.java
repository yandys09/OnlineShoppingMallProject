package com.tway.shoppingbackend.dao;

import com.tway.shoppingbackend.dto.Address;
import com.tway.shoppingbackend.dto.Cart;
import com.tway.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);

}
