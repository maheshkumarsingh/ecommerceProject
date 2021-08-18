package com.app.employeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.app.EmployeeDAO.EmployeeDAO;
import com.app.EmployeeDAOImpl.EmployeeDAOImpl;
import com.app.employeeService.EmployeeService;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDAO employeedao=new EmployeeDAOImpl();

	@Override
	public int createProduct(Product product) throws BusinessException {
		
		if(product.getCost()==0 && product.getPname().matches("[a-zA-Z]{3,10}"))
		{
			throw new BusinessException("Cost cant be 0"+product.getCost());
		}
		return employeedao.createProduct(product);
	}

	@Override
	public List<Product> getAllProduct() throws BusinessException {
		
		return employeedao.getAllProduct();
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		if(id<0 && id>50)
		{
			throw new BusinessException("Id cant be other than listed"+id);
		}
		return employeedao.deleteProduct(id);
	}

}
