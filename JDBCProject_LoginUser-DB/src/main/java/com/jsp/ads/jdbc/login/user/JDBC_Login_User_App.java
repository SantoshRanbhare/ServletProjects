package com.jsp.ads.jdbc.login.user;

public class JDBC_Login_User_App {
	public static void main(String[] args) {
		System.out.println("------Welcome to SignUp & SignIn Page-----\n1.Regiter   2.Login   3.Forgot Password");
		int choice = JDBC_Login_User_Service.scanner.nextInt();
		switch(choice) {
		case 1:{
			JDBC_Login_User_Service.registerUser();
		}
		break;
		case 2:{
			JDBC_Login_User_Service.loginUser();
		}
		break;
		case 3:{
			
		}
		break;
		default : System.err.println("Please Select Only Above Choice");
		}
	}

}
