package com.app.GetProductbyidDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.GetProductbyidDAO.GetProductbyidDAO;
import com.app.dao.dbutil.MySqlDbConnection;

import com.app.exception.BusinessException;
import com.app.model.Product;

public class GetProductbyidDAOImpl implements GetProductbyidDAO{
	private static Logger log = Logger.getLogger(GetProductbyidDAOImpl.class);
	@Override
	public Product getProductById(int id) throws BusinessException {
		
		Product product=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,pname,cost from productdetail where id=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				product=new Product();
				product.setId(id);
				product.setPname(resultset.getString("pname"));
				product.setCost(resultset.getDouble("cost"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			log.info("check daoimpl");
		}
		return product;
	}
	

}
