package com.jsp.ads.jdbc.hospital;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC_Hospital_Service {
	static Connection conn = null;
	static Scanner scanner = new Scanner(System.in);

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		FileReader fr = new FileReader("connection.properties");

		Properties p = new Properties();
		p.load(fr);

		String db_url = p.getProperty("url");

		conn = DriverManager.getConnection(db_url,p);
		return conn;
	}

	public static void displayClientData(ResultSet rs) throws Exception {
		System.out.println("Cliend Id\tClient Name\tClient Desease");
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t\t");
			System.out.print(rs.getString(2)+"\t\t");
			System.out.print(rs.getString(3)+"\t\t");
			System.out.println();
		}
	}

	public static void addClient() {
		try {
			conn = getConnection();
			CallableStatement cst = conn.prepareCall("call addClient(?,?,?)");
			System.out.println("Enter Client Id");
			cst.setInt(1, scanner.nextInt());
			System.out.println("Enter Client Name");
			cst.setString(2, scanner.next());
			System.out.println("Enter Client Desease");
			cst.setString(3, scanner.next());

			int rowInserted = cst.executeUpdate();
			if(rowInserted>0) {
				System.out.println(rowInserted+" row Inserted Successfully");
			}
			else {
				System.out.println("row not Inserted");
			}

		} catch (Exception e) {
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

	public static void findAllClient() {
		try {
			conn = getConnection();

			CallableStatement cst = conn.prepareCall("call findAllClient()");
			ResultSet result = cst.executeQuery();
			displayClientData(result);

		} catch (Exception e) {
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

	public static void updateClient() {
		try {
			conn = getConnection();

			CallableStatement cst = conn.prepareCall("call updateClient(?,?,?)");
			System.out.println("Enter Client Id to Update");
			cst.setInt(1, scanner.nextInt());
			System.out.println("Enter Client Name");
			cst.setString(2, scanner.next());
			System.out.println("Enter Client Desease");
			cst.setString(3, scanner.next());

			int rowUpdated = cst.executeUpdate();
			if(rowUpdated>0) {
				System.out.println(rowUpdated+" row Updated Successfully");
			}
			else {
				System.out.println("row not Updated");
			}

		} catch (Exception e) {
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
	
	public static void deleteClient() {
		try {
			conn = getConnection();
			
			CallableStatement cst = conn.prepareCall("call deleteClientById(?)");
			System.out.println("Enter Client Id to Delete");
			cst.setInt(1, scanner.nextInt());
			
			int rowdeleted = cst.executeUpdate();
			if(rowdeleted>0) {
				System.out.println(rowdeleted+" row Deleted Successfully");
			}
			else {
				System.out.println("row not Deleted");
			}
			
		} catch (Exception e) {
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
