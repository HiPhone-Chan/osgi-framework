package com.chf.ui.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.chf.common.core.domain.User;
import com.chf.common.core.service.UserService;

@Component(service = { Servlet.class }, property = { "alias:String=/user" })
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -6952458064649668819L;

	@Reference
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("<h1>Users</h1>");
		for (User user : userService.getUsers()) {
			writer.println(user);
		}
	}

}
