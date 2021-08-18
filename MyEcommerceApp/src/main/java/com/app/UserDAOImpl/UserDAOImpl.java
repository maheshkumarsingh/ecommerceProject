package com.app.UserDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.EmployeeDAOImpl.EmployeeDAOImpl;
import com.app.UserDAO.UserDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

import com.app.model.Product;

import com.app.model.User;

public class UserDAOImpl implements UserDAO {
	private static Logger log = Logger.getLogger(UserDAOImpl.class);

	@Override
	public int createUser(User user) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into user(useremail,firstname,lastname,pass) values (?,?,?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedstatement.setString(1, user.getUserEmail());
			preparedstatement.setString(2, user.getFname());
			preparedstatement.setString(3, user.getLname());
			preparedstatement.setString(4, user.getUserpass());
			c = preparedstatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedstatement.getGeneratedKeys();
				if (resultSet.next()) {
					user.setUserid(resultSet.getInt(1));
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn("check daoimpl");

		}
		return c;

	}

	@Override
	public List<User> getAllUser() throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select userid,useremail,firstname,lastname from user";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				User user = new User();
				user.setUserid(resultset.getInt("userid"));
				user.setUserEmail(resultset.getString("useremail"));
				user.setFname(resultset.getString("firstname"));
				user.setLname(resultset.getString("lastname"));
				userList.add(user);

			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
		}
		return userList;

	}

	@Override
	public int checkLogin(String str) throws BusinessException {
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select useremail from user where useremail=?";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, str);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next())
				return 1;
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
		}
		return 0;
	}

}
