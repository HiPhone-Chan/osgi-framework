package com.chf.osgi.http;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

import com.chf.osgi.simplify.SimpleServiceTracker;

public class HttpServiceTracker extends SimpleServiceTracker<HttpService> {

	public HttpServiceTracker(BundleContext context) {
		super(context, HttpService.class.getName());
	}

	@Override
	public HttpService addingService(ServiceReference<HttpService> reference) {
		HttpService httpService = super.addingService(reference);
		return httpService;
	}
}
