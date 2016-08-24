package com.chf.ui.web;

import java.util.Hashtable;

import javax.servlet.Servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.chf.ui.web.servlet.IndexServlet;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Activator implements BundleActivator {

	private ServiceRegistration registration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start web ui.");
		Hashtable props = new Hashtable();
		props.put("osgi.http.whiteboard.servlet.pattern", "/hello");
		props.put("servlet.init.message", "Hello World!");

//		registration = context.registerService(Servlet.class.getName(), new IndexServlet(), props);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop web ui.");
//		registration.unregister();
	}

}
