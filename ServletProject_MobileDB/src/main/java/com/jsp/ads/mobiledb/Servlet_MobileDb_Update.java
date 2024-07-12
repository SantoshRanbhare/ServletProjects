package com.jsp.ads.mobiledb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_MobileDb_Update extends GenericServlet{
	
	Connection conn = null;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("id"));
		String mobileBrand = req.getParameter("brand");
		int mobilePrice = Integer.parseInt(req.getParameter("price"));

		PrintWriter out = res.getWriter();

		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiledb?user=root&password=Santosh@123");

			PreparedStatement pst = conn.prepareStatement("update mobile set mobileBrand=? and mobilePrice=? where mobileId=?");
			pst.setString(1, mobileBrand);
			pst.setInt(2, mobilePrice);
			pst.setInt(3, mobileId);

			int rowUpdated = pst.executeUpdate();
			if(rowUpdated>0) {
				out.print("<h1>"+rowUpdated+" row Updated Successfully</h1>");
				out.print("<h1><a href=\"update.html\">Back</a></h1>");
			}
			else {
				out.print("<h1>row not Updated</h1>");
				out.print("<h1><a href=\"update.html\">Back</a></h1>");
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
}


