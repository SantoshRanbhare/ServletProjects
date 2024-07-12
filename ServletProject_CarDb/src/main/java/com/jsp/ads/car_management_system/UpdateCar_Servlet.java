package com.jsp.ads.car_management_system;

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

@WebServlet("/updateCar")
public class UpdateCar_Servlet extends HttpServlet{
	
	Connection conn = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int carId = Integer.parseInt(req.getParameter("carId"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_management_system?user=root&password=Santosh@123");
			PreparedStatement pst = conn.prepareStatement("select * from car where carId=?");
			pst.setInt(1, carId);
			ResultSet result = pst.executeQuery();
			
			req.setAttribute("resultSet", result);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateCar.jsp");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
