package com.app.CartUserService;

import com.app.exception.BusinessException;

public interface CartUserService {
	public int insertintocart(int pid,String userid) throws BusinessException;

}
