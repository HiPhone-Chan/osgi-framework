package com.chf.ui.web.servlet;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.context.ServletContextHelper;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(service = ServletContextHelper.class, property = { SimpleServletContextHelper.CONTEXT_NAME,
		SimpleServletContextHelper.CONTEXT_PATH })
public class SimpleServletContextHelper extends ServletContextHelper {

	public static final String CONTEXT_NAME = HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=chf";

	public static final String CONTEXT_PATH = HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH + "=/";

	public static final String CONTEXT_SELECT = HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT + "=("
			+ CONTEXT_NAME + ")";

	public SimpleServletContextHelper() {
	}

	public SimpleServletContextHelper(BundleContext context) {
		super(context.getBundle());
	}
}
