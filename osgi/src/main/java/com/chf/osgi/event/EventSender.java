package com.chf.osgi.event;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public class EventSender {

	private static EventAdmin eventAdmin;

	public static void setEventAdmin(EventAdmin eventAdmin) {
		EventSender.eventAdmin = eventAdmin;
	}

	public static void synSend(Event event) {
		if (eventAdmin != null) {
			eventAdmin.sendEvent(event);
		}
	}

	public static void asynSend(Event event) {
		if (eventAdmin != null) {
			eventAdmin.postEvent(event);
		}
	}
}
