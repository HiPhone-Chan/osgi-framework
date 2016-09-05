package com.chf.osgi.activator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import com.chf.osgi.http.HttpServiceTracker;
import com.chf.osgi.log.LogServiceTracker;

public class HostActivator implements BundleActivator {

	private BundleContext bundleContext;

	private LogServiceTracker logServiceTracker;

	private HttpServiceTracker httpServiceTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		bundleContext = context;

		logServiceTracker = new LogServiceTracker(context);
		logServiceTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (logServiceTracker != null) {
			logServiceTracker.close();
		}

		if (httpServiceTracker != null) {
			httpServiceTracker.close();
		}
	}

	public Bundle[] getBundles() {
		if (bundleContext != null) {
			return this.bundleContext.getBundles();
		}
		return null;
	}

	public Bundle installBundle(String location) {
		Bundle bundle = null;
		try (InputStream is = new FileInputStream(location)) {
			bundle = bundleContext.installBundle(location, is);
		} catch (BundleException | IOException e) {
			e.printStackTrace();
		}
		return bundle;
	}

	public Bundle installClassBundle(String location) {
		Bundle bundle = null;
		try (InputStream is = getClass().getClassLoader().getResourceAsStream(location)) {
			bundle = bundleContext.installBundle(location, is);
		} catch (BundleException | IOException e) {
			e.printStackTrace();
		}
		return bundle;
	}

	public static final String INIT_BUNDLES_PATH = "initial-bundles/";

	public void intBundles() {
		List<Bundle> bundles = new ArrayList<>();

		URL initBundlesUrl = getClass().getClassLoader().getResource(INIT_BUNDLES_PATH);
		File initBundlesDir = null;
		switch (initBundlesUrl.getProtocol()) {
		case "file":
			initBundlesDir = new File(initBundlesUrl.getFile());
			for (String fileName : initBundlesDir.list()) {
				if (fileName.endsWith(".jar")) {
					bundles.add(installClassBundle(INIT_BUNDLES_PATH + fileName));
				}
			}
			break;
		case "jar":
			initBundlesDir = new File(INIT_BUNDLES_PATH);
			for (String fileName : initBundlesDir.list()) {
				if (fileName.endsWith(".jar")) {
					bundles.add(installClassBundle(INIT_BUNDLES_PATH + fileName));
				}
			}
			break;
		default:
		}

		for (Bundle bundle : bundles) {
			if (bundle != null) {
				try {
					bundle.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
