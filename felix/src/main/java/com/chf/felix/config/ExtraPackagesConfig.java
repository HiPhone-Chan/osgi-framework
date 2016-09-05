package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.Constants;

import com.chf.common.core.util.StreamUtil;

/**
 * if appear missing requirement ... osgi.wiring.package;, add the package here
 * 
 * @author chf
 *
 */
public class ExtraPackagesConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		List<String> packageInfos = StreamUtil
				.readLines(getClass().getClassLoader().getResourceAsStream("conf/extra-packages"));
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
