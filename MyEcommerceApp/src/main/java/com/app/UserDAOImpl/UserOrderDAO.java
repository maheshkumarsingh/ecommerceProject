package com.app.UserDAOImpl;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.Product;

public interface UserOrderDAO {
	public int CarttoOrder(String userid) throws BusinessException;
	public List<Order> getProductid(String userid) throws BusinessException;

}
