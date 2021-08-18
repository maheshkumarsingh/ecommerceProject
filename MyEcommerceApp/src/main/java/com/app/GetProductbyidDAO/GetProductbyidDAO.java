package com.app.GetProductbyidDAO;

import com.app.exception.BusinessException;
import com.app.model.Product;


public interface GetProductbyidDAO {
	public Product getProductById(int id) throws BusinessException;

}
