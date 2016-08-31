package com.chf.osgi.event;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;

import com.chf.osgi.simplify.SimpleServiceTracker;

public class EventAdminTracker extends SimpleServiceTracker<EventAdmin> {

	public EventAdminTracker(BundleContext context) {
		super(context, EventAdmin.class);
	}

	@Override
	public EventAdmin addingService(ServiceReference<EventAdmin> reference) {
		EventAdmin eventAdmin = super.addingService(reference);
		EventSender.setEventAdmin(eventAdmin);
		return eventAdmin;
	}
}
