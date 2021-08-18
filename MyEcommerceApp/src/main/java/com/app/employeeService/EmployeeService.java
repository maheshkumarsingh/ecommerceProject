package com.app.employeeService;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeService {
	
	public int createProduct(Product product) throws BusinessException;
	public int deleteProduct(int id) throws BusinessException;
	public List<Product> getAllProduct() throws BusinessException;

}
