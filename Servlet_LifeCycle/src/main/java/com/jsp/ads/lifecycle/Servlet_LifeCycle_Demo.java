package com.jsp.ads.lifecycle;

import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/onClick")
public class Servlet_LifeCycle_Demo extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service Method Called");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init Method Called");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy Method Called");
	}
}
