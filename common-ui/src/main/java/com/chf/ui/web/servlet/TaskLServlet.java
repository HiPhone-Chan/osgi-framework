package com.chf.ui.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import com.chf.common.core.domain.Task;
import com.chf.common.core.service.TaskService;

@OsgiServiceProvider(classes = { Servlet.class })
@Properties({ @Property(name = "alias", value = "/task") })
@Singleton
public class TaskLServlet extends HttpServlet {

	private static final long serialVersionUID = 34992072289535683L;

	@Inject
	@OsgiService
	private TaskService taskService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("<h1>Tasks</h1>");
		for (Task task : taskService.getTasks()) {
			writer.println(task);
		}

	}

}
