package com.jsp.ads.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCompany_Servlet extends HttpServlet{
	static Connection conn = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int companyId = Integer.parseInt(req.getParameter("companyId"));
		PrintWriter out = resp.getWriter();
		
		try {
			conn = AddCompany_Servlet.getConnection();
			PreparedStatement pst = conn.prepareStatement("delete from company where companyId=?");
			pst.setInt(1, companyId);
			int rowDeleted = pst.executeUpdate();
			if(rowDeleted>0) {
				out.print("<h1>"+rowDeleted+" row Deleted Successfully</h1>");
				out.print("<h1><a href=\"DeleteCompany.html\">Back</a><h1>");
			}
			else {
				out.print("<h1>row not Deleted</h1>");
				out.print("<h1><a href=\"DeleteCompany.html\">Back</a><h1>");
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
