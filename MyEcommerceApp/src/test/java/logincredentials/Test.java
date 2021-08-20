package logincredentials;

import static org.junit.jupiter.api.Assertions.*;

import com.app.logincredentials.Logincredentials;

class Test {

	@org.junit.jupiter.api.Test
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

	@org.junit.jupiter.api.Test
	void testCheckforspeacialcharacters() {
		assertEquals(false, Logincredentials.checkforspeacialcharacters("@mahesh"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh!"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh#"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh$"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh%"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh&"), "Invalid");
		assertEquals(true, Logincredentials.checkforspeacialcharacters("mahesh"), "valid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("*mahesh"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh("), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("mahesh)"), "Invalid");

	}

	@org.junit.jupiter.api.Test
	void checkforspeacialcharactersLastname() {
		assertEquals(false, Logincredentials.checkforspeacialcharacters("singh@"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("#singh"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("si*ngh"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("&singh"), "Invalid");
		assertEquals(false, Logincredentials.checkforspeacialcharacters("(singh)"), "Invalid");

	}

}
