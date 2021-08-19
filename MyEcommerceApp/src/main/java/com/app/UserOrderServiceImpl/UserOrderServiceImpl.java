package com.app.UserOrderServiceImpl;

import java.util.List;

import com.app.UserOrderDAO.UserOrderDAO;
import com.app.UserOrderDAOImpl.UserOrderDAOImpl;
import com.app.UserOrderService.UserOrderService;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class UserOrderServiceImpl implements UserOrderService{
	UserOrderDAO userorderdao=new UserOrderDAOImpl();

	@Override
	public int CarttoOrder(String userid) throws BusinessException {
		
	
		return userorderdao.CarttoOrder(userid);
	}

	@Override
	public List<Product> getProductid(String userid) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
