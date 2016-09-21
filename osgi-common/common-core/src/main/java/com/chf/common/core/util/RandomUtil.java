package com.chf.common.core.util;

import java.util.Random;

public class RandomUtil {

	private static final Random random = new Random(System.currentTimeMillis());

	public static int nextInt() {
		return random.nextInt();
	}
}
