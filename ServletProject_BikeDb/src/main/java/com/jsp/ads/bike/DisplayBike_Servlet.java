package com.jsp.ads.bike;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("displayAllBikes")
public class DisplayBike_Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bike_management_system?user=root&password=Santosh@123");
			PreparedStatement pst = conn.prepareStatement("select * from bike");
			ResultSet result = pst.executeQuery();
			
			req.setAttribute("resultSet", result);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayAllBikes.jsp");
			rd.forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
