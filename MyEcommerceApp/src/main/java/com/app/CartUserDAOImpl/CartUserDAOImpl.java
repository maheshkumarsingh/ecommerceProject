package com.app.CartUserDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.CartUserDAO.CartUserDAO;

import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CartUserDAOImpl implements CartUserDAO {
	private static Logger log = Logger.getLogger(CartUserDAOImpl.class);
    Cart cart=new Cart();
	@Override
	public int insertintocart(int pid, String userid) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql="insert into cart(username,productid) values (?,?)";
			
			PreparedStatement preparedstatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, userid);
			preparedstatement.setInt(2, pid);
			c=preparedstatement.executeUpdate();
			if(c==1)
			{
				ResultSet resultset=preparedstatement.getGeneratedKeys();
				if (resultset.next()) {
					cart.setCartid(resultset.getInt(1));
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("check daoimpl");

		}

		return c;
	}

}
