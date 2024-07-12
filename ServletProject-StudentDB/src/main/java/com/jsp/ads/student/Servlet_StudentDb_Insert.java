package com.jsp.ads.student;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_StudentDb_Insert extends GenericServlet{

	static Connection conn = null;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		insert(request, response);
	}
	
	public void insert(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("id"));
		String studentName = request.getParameter("name");
		String studentMail = request.getParameter("mail");
		int studentMarks = Integer.parseInt(request.getParameter("marks"));
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader fr = new FileReader("connection.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			conn = DriverManager.getConnection(dburl,p);
			PreparedStatement pst = conn.prepareStatement("insert into student values(?,?,?,?)");
			pst.setInt(1, studentId);
			pst.setString(2, studentName);
			pst.setString(3, studentMail);
			pst.setInt(4, studentMarks); 
			int rowInserted = pst.executeUpdate();
			if(rowInserted>0) {
				out.println("<h1>"+rowInserted+" row Inserted Successfully</h1>");
			}else {
				out.println("<h1>row not Inserted</h1>");
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
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

//	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
//			
//		return conn;
//	}
}
