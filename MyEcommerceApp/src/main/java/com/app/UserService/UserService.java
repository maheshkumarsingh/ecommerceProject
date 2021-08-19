package com.app.UserService;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.model.User;

public interface UserService {
	
	public int createUser(User user) throws BusinessException;
	public List<User> getAllUser() throws BusinessException;
	public int MarkOrder(String userid) throws BusinessException;
	public int checkLogin(String str) throws BusinessException;
	
	
}
