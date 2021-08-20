package com.app.UserSearchDAO;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.User;

public interface UserSearchDAO {
	public User GetUserById(int id) throws BusinessException;

	public List<User> getUserByFirstName(String firstname) throws BusinessException;

	public List<User> getUserByLastName(String lastname) throws BusinessException;

	public User getUserByEmail(String email) throws BusinessException;
}
