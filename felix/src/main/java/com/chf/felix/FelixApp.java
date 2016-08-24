package com.chf.felix;

import com.chf.osgi.util.RunUtil;

public class FelixApp {

	public static void main(String[] args) throws InterruptedException {
		RunUtil.run(args, FelixFramework.class);
	}

}
