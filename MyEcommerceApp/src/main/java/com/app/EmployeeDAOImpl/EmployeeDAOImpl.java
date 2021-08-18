package com.app.EmployeeDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.EmployeeDAO.EmployeeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public int createProduct(Product product) throws BusinessException {

		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into productdetail(pname,cost) values (?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedstatement.setString(1, product.getPname());
			preparedstatement.setDouble(2, product.getCost());
			c = preparedstatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedstatement.getGeneratedKeys();
				if (resultSet.next()) {
					product.setId(resultSet.getInt(1));
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);

		}
		return c;
	}

	@Override
	public List<Product> getAllProduct() throws BusinessException {

		List<Product> productList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,pname,cost from productdetail";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Product product = new Product();
				product.setId(resultset.getInt("id"));
				product.setPname(resultset.getString("pname"));
				product.setCost(resultset.getDouble("cost"));
				productList.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
		}
		return productList;
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "delete from productdetail where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(e);
		}
		return c;
	}

}


