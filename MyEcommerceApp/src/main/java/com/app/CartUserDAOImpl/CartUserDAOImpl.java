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
import com.app.GetProductbyidDAO.GetProductbyidDAO;
import com.app.GetProductbyidDAOImpl.GetProductbyidDAOImpl;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public class CartUserDAOImpl implements CartUserDAO {
	private static Logger log = Logger.getLogger(CartUserDAOImpl.class);
	
	
	GetProductbyidDAO getproductbyiddao = new GetProductbyidDAOImpl();

	@Override
	public int insertintocart(int pid, String userid) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into cart(username,productid) values (?,?)";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, userid);
			preparedstatement.setInt(2, pid);
			c = preparedstatement.executeUpdate();
			if (c == 1) {
				Cart cart = new Cart();
				ResultSet resultset = preparedstatement.getGeneratedKeys();
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

	@Override
	public List<Cart> getcartbyuserid(String userid) throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select cartid,username,productid,pname, cost from cart c JOIN productdetail p on c.productid=p.id where c.username=?";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, userid);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Cart cart = new Cart();
				cart.setCartid(resultset.getInt("cartid"));
				cart.setUsername(userid);
				Product product = new Product();
				product.setId(resultset.getInt("productid"));
				product.setPname(resultset.getString("pname"));
				product.setCost(resultset.getDouble("cost"));
				cart.setProduct(product);
				cartList.add(cart);
			}
			if (cartList.size() == 0) {
				throw new BusinessException(userid+" You have Nothing in your cart do shopping ");
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return cartList;
	}

	@Override
	public int deletefromcart(int pid,String userid) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "delete from products.cart where cartid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
//			preparedStatement.setString(2, userid);
			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			log.info(e);
		}
		return c;
	}

}
