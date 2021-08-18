package com.app.CartUserDAO;

import com.app.exception.BusinessException;

public interface CartUserDAO {
	public int insertintocart(int pid,String userid) throws BusinessException;

}
