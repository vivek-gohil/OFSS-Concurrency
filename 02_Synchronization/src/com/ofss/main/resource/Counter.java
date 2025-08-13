package com.ofss.main.resource;

public class Counter {
	private static int count = 0;

	public static synchronized void increment() {
		
		count++;
	}

	public static int getCount() {
		return count;
	}
}
