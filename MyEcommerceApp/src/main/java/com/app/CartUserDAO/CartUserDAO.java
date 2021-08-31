package com.app.CartUserDAO;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartUserDAO {
	public int insertintocart(int pid,String userid) throws BusinessException;
	public List<Cart> getcartbyuserid(String userid) throws BusinessException;
	public int deletefromcart(int pid,String userid) throws BusinessException;
}
