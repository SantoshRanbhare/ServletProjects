package com.jsp.ads.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Calculator_Servlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operation = request.getParameter("operation");
		
		PrintWriter out = response.getWriter();
		
		int result = 0;
		if(operation.equals("+")) {
			result = num1 + num2;
		}
		else if(operation.equals("-")) {
			result = num1 - num2;
		}
		else if(operation.equals("*")) {
			result = num1 * num2;
		}
		else if(operation.equals("/")) {
			if(num2 != 0) {
				result = num1 / num2;
			}
			else {
				out.println("Dinomitor Cannot be Zero");
			}
		}
		else if(operation.equals("%")) {
			if(num2 != 0) {
				result = num1 % num2;
			}
			else {
				out.println("Dinomitor Cannot be Zero");
			}
		}
		
		out.print("<h1>Result: "+result+"</h1>");
	}
}
