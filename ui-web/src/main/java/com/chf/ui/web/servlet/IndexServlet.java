package com.chf.ui.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(service = Servlet.class, property = { HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/",
		HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT + "=("
				+ HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=index)" })
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -7194555391669166867L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Welcome to Felix http.");
	}

}
