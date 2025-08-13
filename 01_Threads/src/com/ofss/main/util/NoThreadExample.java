package com.ofss.main.util;

public class NoThreadExample {
	public static void task(String name) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(name + " - step " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
