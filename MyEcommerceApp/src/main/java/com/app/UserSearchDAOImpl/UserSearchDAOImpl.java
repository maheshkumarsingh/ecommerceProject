package com.app.UserSearchDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.UserSearchDAO.UserSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.User;

public class UserSearchDAOImpl implements UserSearchDAO{
	private static Logger log=Logger.getLogger(UserSearchDAOImpl.class);

	@Override
	public User GetUserById(int id) throws BusinessException {
		User user=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select userid,firstname,lastname,useremail from user where userid=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				user=new User();
				user.setUserid(resultset.getInt("userid"));
				user.setFname(resultset.getString("firstname"));
				user.setLname(resultset.getString("lastname"));
				user.setUserEmail(resultset.getString("useremail"));
			}else {
				log.warn("No user with this "+id+" is present");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("UserSearchDAOImpl",e);
		}
		return user;
	}

	@Override
	public List<User> getUserByFirstName(String firstname) throws BusinessException {
	    List<User> userlist=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select userid,firstname,lastname,useremail from user where firstname=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, firstname);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				User user=new User();
				user.setUserid(resultset.getInt("userid"));
				user.setFname(resultset.getString("firstname"));
				user.setLname(resultset.getString("lastname"));
				user.setUserEmail(resultset.getString("useremail"));
				userlist.add(user);
			}
			if(userlist.size()==0) {
				throw new BusinessException("No user with firstname "+firstname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("UserSearchDAOImpl",e);
		}
		return userlist;
	    
		
	}

	@Override
	public List<User> getUserByLastName(String lastname) throws BusinessException {
	    List<User> userlist=new ArrayList<>();
			try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="select userid,firstname,lastname,useremail from user where lastname=?";
				PreparedStatement preparedstatement=connection.prepareStatement(sql);
				preparedstatement.setString(1, lastname);
				ResultSet resultset=preparedstatement.executeQuery();
				while(resultset.next()) {
					User user=new User();
					user.setUserid(resultset.getInt("userid"));
					user.setFname(resultset.getString("firstname"));
					user.setLname(resultset.getString("lastname"));
					user.setUserEmail(resultset.getString("useremail"));
					userlist.add(user);
				}
				if(userlist.size()==0) {
					throw new BusinessException("No user with firstname "+lastname);
				}
			} catch (ClassNotFoundException | SQLException e) {
				log.warn("UserSearchDAOImpl",e);
			}
			return userlist;
	}

	@Override
	public User getUserByEmail(String email) throws BusinessException {
		User user=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select userid,firstname,lastname,useremail from user where useremail=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, email);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				user=new User();
				user.setUserid(resultset.getInt("userid"));
				user.setFname(resultset.getString("firstname"));
				user.setLname(resultset.getString("lastname"));
				user.setUserEmail(resultset.getString("useremail"));
			}else {
				log.warn("No user with this "+email+" is present");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("UserSearchDAOImpl",e);
		}
		return user;
	}



}
