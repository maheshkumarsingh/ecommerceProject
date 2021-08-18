package com.app.UserDAO;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.model.User;

public interface UserDAO {
	public int createUser(User user) throws BusinessException;
	public List<User> getAllUser() throws BusinessException;
	
	public int checkLogin(String str) throws BusinessException;

}
