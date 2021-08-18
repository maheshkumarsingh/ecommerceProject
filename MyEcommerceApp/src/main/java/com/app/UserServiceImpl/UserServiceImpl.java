package com.app.UserServiceImpl;

import java.util.List;

import com.app.UserDAO.UserDAO;
import com.app.UserDAOImpl.UserDAOImpl;
import com.app.UserService.UserService;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.model.User;

public class UserServiceImpl implements UserService {
	UserDAO userdao = new UserDAOImpl();

	@Override
	public int createUser(User user) throws BusinessException {
		if (user.getFname().matches("[^a-zA-Z]{2,10}") && user.getLname().matches("[^a-zA-Z]{2,10}")) {
			throw new BusinessException("First and Last Name Should be only aplbhabets");
		}
		return userdao.createUser(user);
	}

	@Override
	public List<User> getAllUser() throws BusinessException {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}

	

}
