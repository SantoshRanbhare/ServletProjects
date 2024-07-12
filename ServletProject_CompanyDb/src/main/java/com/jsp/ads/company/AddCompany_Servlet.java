package com.jsp.ads.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCompany_Servlet extends HttpServlet{
	static Connection conn = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int companyId = Integer.parseInt(req.getParameter("companyId"));
		String companyName = req.getParameter("companyName");
		String companyAddress = req.getParameter("companyAddress");
		int noOfEmployees = Integer.parseInt(req.getParameter("noOfEmployees"));
		
		PrintWriter out = resp.getWriter();
		
		try {
			conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into company values(?,?,?,?)");
			pst.setInt(1, companyId);
			pst.setString(2, companyName);
			pst.setString(3, companyAddress);
			pst.setInt(4, noOfEmployees);
			int rowInserted = pst.executeUpdate();
			if(rowInserted>0) {
				out.print("<h1>"+rowInserted+" row Inserted Successfully</h1>");
				out.print("<h1><a href=\"AddCompany.html\">Back</a><h1>");
			}
			else {
				out.print("<h1>row Not Inserted</h1>");
				out.print("<h1><a href=\"AddCompany.html\">Back</a><h1>");
			}
		} catch (SQLException e) {
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

	public static Connection getConnection() throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?user=root&password=Santosh@123");
		return conn;
	}
}
