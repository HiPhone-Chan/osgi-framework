package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.apache.felix.http.whiteboard.internal.WhiteboardActivator;
import org.osgi.framework.BundleActivator;

public class HttpConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new org.apache.felix.http.jetty.internal.JettyActivator());
		activators.add(new WhiteboardActivator());
		activators.add(new org.apache.felix.http.bridge.internal.BridgeActivator());
//		config.put("org.apache.felix.http.jettyEnabled", "true");
//		config.put("org.apache.felix.http.whiteboardEnabled", "true");
	}

}
