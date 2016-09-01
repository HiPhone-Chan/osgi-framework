package com.chf.felix.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.Constants;

/**
 * if appear missing requirement ... osgi.wiring.package;, add the package here
 * 
 * @author chf
 *
 */
public class ExtraPackagesConfig extends ConfigChain {

	public List<String> packageInfos;

	public ExtraPackagesConfig() {
		packageInfos = new ArrayList<>();
		packageInfos.add("javax.servlet;javax.servlet.http;version=3.1.0");
		packageInfos.add("org.osgi.service.log;version=1.3");
		packageInfos.add("org.osgi.service.http.context;version=1.0");
		packageInfos.add("javax.inject;version=1");
		packageInfos.add("org.osgi.service.blueprint;version=1.0.0");
	}

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		StringBuilder sb = new StringBuilder();

		for (String packageInfo : packageInfos) {
			if (sb.length() > 0) {
				sb.append(',');
			}
			sb.append(packageInfo);
		}

		config.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA, sb.toString());
	}

}
