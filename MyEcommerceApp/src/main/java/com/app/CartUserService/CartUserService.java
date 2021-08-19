package com.app.CartUserService;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartUserService {
	public int insertintocart(int pid,String userid) throws BusinessException;
	public List<Cart> getcartbyuserid(String userid) throws BusinessException;

}
