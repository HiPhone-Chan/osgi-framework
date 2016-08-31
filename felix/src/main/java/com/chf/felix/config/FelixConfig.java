package com.chf.felix.config;

import static org.apache.felix.framework.util.FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;

import com.chf.osgi.activator.HostActivator;

public class FelixConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new HostActivator());
	}

	public Map<String, Object> startConfig() {
		Map<String, Object> config = new HashMap<>();
		List<BundleActivator> activators = new ArrayList<BundleActivator>();
		startConfig(config, activators);
		config.put(SYSTEMBUNDLE_ACTIVATORS_PROP, activators);
		return config;
	}
}
