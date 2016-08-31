package com.chf.ui.web.servlet;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.context.ServletContextHelper;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(service = ServletContextHelper.class, property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=index",
		HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH + "=/" })
public class SimpleServletContextHelper extends ServletContextHelper {

	public SimpleServletContextHelper() {
	}

	public SimpleServletContextHelper(BundleContext context) {
		super(context.getBundle());
	}
}
