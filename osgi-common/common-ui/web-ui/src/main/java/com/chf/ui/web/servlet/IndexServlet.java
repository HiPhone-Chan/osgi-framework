package com.chf.ui.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = { "alias:String=/" })
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -7194555391669166867L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Welcome to osgi http.");
	}

}
