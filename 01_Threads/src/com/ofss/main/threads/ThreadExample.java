package com.ofss.main.threads;

public class ThreadExample {
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
