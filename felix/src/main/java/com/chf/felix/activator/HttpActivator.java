package com.chf.felix.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.chf.ui.web.servlet.IndexServlet;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class HttpActivator implements BundleActivator {

	private ServiceTracker httpTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start web ui.");

		httpTracker = new ServiceTracker(context, HttpService.class, null) {
			public void removedService(ServiceReference reference, Object service) {
				try {
					((HttpService) service).unregister("/hello");
				} catch (IllegalArgumentException exception) {
				}
			}

			public Object addingService(ServiceReference reference) {
				HttpService httpService = (HttpService) this.context.getService(reference);
				try {
					System.out.println("http service.");
					httpService.registerServlet("/hello", new IndexServlet(), null, null);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				return httpService;
			}
		};
		// start tracking all HTTP services...
		httpTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop web ui.");
		httpTracker.close();
	}

}
