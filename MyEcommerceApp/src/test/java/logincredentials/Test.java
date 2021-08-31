package logincredentials;

import static org.junit.jupiter.api.Assertions.*;

import com.app.CartUserDAO.CartUserDAO;
import com.app.CartUserDAOImpl.CartUserDAOImpl;
import com.app.EmployeeDAO.EmployeeDAO;
import com.app.EmployeeDAOImpl.EmployeeDAOImpl;
import com.app.UserDAO.UserDAO;
import com.app.UserDAOImpl.UserDAOImpl;
import com.app.UserOrderDAO.UserOrderDAO;
import com.app.UserOrderDAOImpl.UserOrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.logincredentials.Logincredentials;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.model.User;

class Test {

/*	@org.junit.jupiter.api.Test
	void testEmployeeLogin() {

		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2", "21"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh", "217@"), "Invalid Credentials");
		assertEquals(true, Logincredentials.EmployeeLogin("mahesh217", "2170@"), "valid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh217", "2170"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2170", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh222", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh21", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2", "214"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2wqdjkhd", "214"), "Invalid Credentials");
	}

	// add product
	@org.junit.jupiter.api.Test
	void testAddProducts() throws BusinessException {
		EmployeeDAO dao = new EmployeeDAOImpl();
		Product product = new Product(1, "Asics shoes", 5000);
		assertEquals(1, dao.createProduct(product), "Not a valid Product");
	}

	// add user

	@org.junit.jupiter.api.Test

	void testAddUser() throws BusinessException {
		UserDAO dao = new UserDAOImpl();
		User user = new User(24, "xyzz@gmail.com", "2170@", "mahesh", "singh");  //change always
		assertEquals(1, dao.createUser(user), "Not a valid user");

	}

	// product into cart

	@org.junit.jupiter.api.Test

	void testProductintoCart() throws BusinessException {
		CartUserDAO dao = new CartUserDAOImpl();
		assertEquals(1, dao.insertintocart(17, "sm.singhmahesh@gmail.com"), "Not added into cart");

	}
	
	
	@org.junit.jupiter.api.Test
	
	void testCartintoOrder() throws BusinessException{
		
		UserOrderDAO dao=new UserOrderDAOImpl();
		assertEquals(1, dao.CarttoOrder("sm.singhmahesh@gmail.com", 7),"Not added into order");
		
	}
	
	@org.junit.jupiter.api.Test
	
	void testDeleteProduct() throws BusinessException{
		EmployeeDAO dao=new EmployeeDAOImpl();
		assertEquals(1, dao.deleteProduct(1),"cannot delete product");   //change pid always
	}
	
*/
}
