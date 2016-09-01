package com.chf.equinox;

import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.eclipse.osgi.framework.internal.core.FrameworkProperties;

public class EquinoxApp {

	public static boolean isNoShutdown = true;

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			args = new String[] { "-console" };
		}

		try {
			FrameworkProperties.setProperty(EclipseStarter.PROP_NOSHUTDOWN, String.valueOf(isNoShutdown));
			EclipseStarter.run(args, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
