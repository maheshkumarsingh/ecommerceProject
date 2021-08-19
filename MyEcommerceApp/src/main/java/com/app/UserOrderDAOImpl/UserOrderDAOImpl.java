package com.app.UserOrderDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.UserOrderDAO.UserOrderDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Order;
import com.app.model.Product;

public class UserOrderDAOImpl implements UserOrderDAO {

	private static Logger log = Logger.getLogger(UserOrderDAOImpl.class);

	@Override
	public int CarttoOrder(String userid) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into products.order(userid) values(?)";
			Order order = new Order();
			PreparedStatement preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, userid);
			c = preparedstatement.executeUpdate();
			if (c == 1) {

				ResultSet resultset = preparedstatement.getGeneratedKeys();
				if (resultset.next()) {
					order.setOrderid(resultset.getInt(1));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.info("Now Processed to Add cart into Order\n");
		}

		return c;
	}

	@Override
	public List<Order> getProductid(String userid) throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = ("select orderid, userid,productid,status from products.order o join cart c on o.userid=c.username where c.username=?");
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, userid);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Order order = new Order();
				order.setOrderid(resultset.getInt("orderid"));
				order.setUsername(userid);
				order.setProductid(resultset.getInt("productid"));
				order.setStatus(resultset.getString("status"));
				orderList.add(order);
				
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return orderList;
		
	}

}
