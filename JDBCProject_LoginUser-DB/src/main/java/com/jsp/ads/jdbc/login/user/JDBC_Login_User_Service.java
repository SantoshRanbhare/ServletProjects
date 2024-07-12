package com.jsp.ads.jdbc.login.user;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC_Login_User_Service 
{
    static Connection conn = null;
    static Scanner scanner = new Scanner(System.in);
    
    private static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	FileReader fr = new FileReader("connection.properties");
    	Properties p = new Properties();
    	p.load(fr);
    	String dburl = p.getProperty("url");
    	conn = DriverManager.getConnection(dburl,p);
    	return conn;
    }
    
    public static void registerUser() {
    	try {
			conn = getConnection();
			
			CallableStatement cst = conn.prepareCall("call addUser(?,?,?)");
			scanner.nextLine();
			System.out.println("Enter Your Name:");
			cst.setString(1, scanner.nextLine());
			System.out.println("Enter Your Email:");
			cst.setString(2, scanner.next());
			System.out.println("Create Password:");
			cst.setString(3, scanner.next());
			int userRegistered =  cst.executeUpdate();
			if(userRegistered>0) {
				System.out.println("Regitered Successfully😉");
			}
			else {
				System.err.println("Not Registered Please try Again");
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    
    public static void loginUser() {
    	try {
    		conn = getConnection();
    		
    		CallableStatement cst = conn.prepareCall("call loginUser(?,?)");
    		System.out.println("Enter Your Email:");
    		cst.setString(1, scanner.next());
    		System.out.println("Enter Your Password:");
    		cst.setString(2, scanner.next());
    		boolean checkLogin =  cst.execute();
    		if(checkLogin != false) {
    			System.out.println("Login Successfully😉");
    		}
    		else {
    			System.err.println("Incorrect UserName or Password");
    		}
    		
    	} catch (ClassNotFoundException | SQLException | IOException e) {
    		e.printStackTrace();
    	} finally {
    		if(conn != null) {
    			try {
    				conn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    
    public static void forgotPassword() {
    	try {
    		conn = getConnection();
    		
    		CallableStatement cst = conn.prepareCall("call loginUser(?,?)");
    		System.out.println("Enter Your Email:");
    		cst.setString(2, scanner.next());
    		System.out.println("Create Password:");
    		cst.setString(3, scanner.next());
    		boolean checkLogin =  cst.execute();
    		if(checkLogin != false) {
    			System.out.println("Login Successfully😉");
    		}
    		else {
    			System.err.println("Incorrect UserName or Password");
    		}
    		
    	} catch (ClassNotFoundException | SQLException | IOException e) {
    		e.printStackTrace();
    	} finally {
    		if(conn != null) {
    			try {
    				conn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    
   
    
    
    
    
    
    
    
    
    
}
