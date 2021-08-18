package com.app.CartUserServiceImpl;

import com.app.CartUserDAO.CartUserDAO;
import com.app.CartUserDAOImpl.CartUserDAOImpl;
import com.app.CartUserService.CartUserService;
import com.app.exception.BusinessException;

public class CartUserServiceImpl implements CartUserService{
	CartUserDAO cartuserdao=new CartUserDAOImpl();

	@Override
	public int insertintocart(int pid, String userid) throws BusinessException {
		if(pid==0)
		{
			throw new BusinessException("ID cannot be Zero");
		}
		return cartuserdao.insertintocart(pid, userid);
	}

}
