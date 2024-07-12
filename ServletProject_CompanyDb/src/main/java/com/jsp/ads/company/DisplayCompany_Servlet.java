package com.jsp.ads.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayCompany_Servlet extends HttpServlet{
	
	Connection conn = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			conn = AddCompany_Servlet.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from company");
			ResultSet result= pst.executeQuery();
			req.setAttribute("result", result);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayCompany.jsp");
			rd.forward(req, resp);
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
