package com.jsp.ads.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCompany_Servlet extends HttpServlet{
	Connection conn = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int companyId = Integer.parseInt(req.getParameter("companyId"));
		String companyName = req.getParameter("companyName");
		String companyAddress = req.getParameter("companyAddress");
		int noOfEmployees = Integer.parseInt(req.getParameter("noOfEmployees"));
		
		PrintWriter out = resp.getWriter();
		
		try {
			conn = AddCompany_Servlet.getConnection();
			PreparedStatement pst = conn.prepareStatement("update company set companyName=?,companyAddress=?,noOfEmployees=? where companyId=?");
			pst.setString(1, companyName);
			pst.setString(2, companyAddress);
			pst.setInt(3, noOfEmployees);
			pst.setInt(4, companyId);
			int rowUpdated = pst.executeUpdate();
			if(rowUpdated>0) {
				out.print("<h1>"+rowUpdated+" row Updated Successfully</h1>");
				out.print("<h1><a href=\"UpdateCompany.html\">Back</a><h1>");
			}
			else {
				out.print("<h1>row Not Updated</h1>");
				out.print("<h1><a href=\"UpdateCompany.html\">Back</a><h1>");
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
