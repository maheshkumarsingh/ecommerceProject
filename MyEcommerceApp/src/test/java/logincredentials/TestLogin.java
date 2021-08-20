package logincredentials;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.logincredentials.Logincredentials;

class TestLogin {

	@Test
	void testEmployeeLogin() {
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2", "21"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh", "217@"), "Invalid Credentials");
		assertEquals(true, Logincredentials.EmployeeLogin("mahesh217", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh217", "2170"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2170", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh222", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh21", "2170@"), "Invalid Credentials");
		assertEquals(false, Logincredentials.EmployeeLogin("mahesh2", "214"), "Invalid Credentials");
	}

}
