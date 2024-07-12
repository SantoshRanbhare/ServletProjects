package com.jsp.ads.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Server extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
//		System.out.println(name);
//		
//		PrintWriter out = response.getWriter();
//		out.print("<h1>Welcome User "+name+"</h1>");
		
		request.setAttribute("key", name); // What to Transfer
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp"); // Where To Transfer
		rd.forward(request, response); // Transfer
	}

}
