package com.app.UserOrderService;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.Product;

public interface UserOrderService {
	public int CarttoOrder(String userid) throws BusinessException;
	public List<Product> getProductid(String userid) throws BusinessException;

}
