package com.app.EmployeeDAO;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeDAO {
	public int createProduct(Product product) throws BusinessException;
	public int deleteProduct(int id) throws BusinessException;
	public List<Product> getAllProduct() throws BusinessException;

}
