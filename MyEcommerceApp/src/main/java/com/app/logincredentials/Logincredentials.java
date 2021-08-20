package com.app.logincredentials;

public class Logincredentials {
	public static boolean EmployeeLogin(String name, String pass) {
		if (name.equals("mahesh217") && pass.equals("2170@"))
			return true;
		return false;

	}
	
	public static boolean checkforspeacialcharacters(String str) {
		if(str.matches("[a-zA-z]{2,10}")) {
			return true;
		}
		else
		return false;
	}
	public static boolean checkforspeacialcharactersLastname(String str) {
		if(str.matches("[a-zA-z]{2,10}")) {
			return true;
		}
		else
			return false;
	}
	
	
	

}
