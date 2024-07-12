package com.jsp.ads.bike;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addNewBike")
public class AddNewBike_Servlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bikeId = Integer.parseInt(req.getParameter("bikeId"));
		String bikeName = req.getParameter("bikeName");
		String bikeBrand = req.getParameter("bikeBrand");
		String bikeColor = req.getParameter("bikeColor");
		int bikePrice = Integer.parseInt(req.getParameter("bikePrice"));
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bike_management_system?user=root&password=Santosh@123");
			PreparedStatement pst = conn.prepareStatement("insert into bike values(?,?,?,?,?)");
			pst.setInt(1, bikeId);
			pst.setString(2, bikeName);
			pst.setString(3, bikeBrand);
			pst.setString(4, bikeColor);
			pst.setInt(5, bikePrice);
			pst.executeUpdate();
			
			resp.sendRedirect("index.jsp");
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
