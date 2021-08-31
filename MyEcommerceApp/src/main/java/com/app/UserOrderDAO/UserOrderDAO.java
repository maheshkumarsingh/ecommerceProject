package com.app.UserOrderDAO;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.Product;

public interface UserOrderDAO {
	public int CarttoOrder(String userid,int pid) throws BusinessException;
	public List<Order> getOrderTable(String userid) throws BusinessException;

}
