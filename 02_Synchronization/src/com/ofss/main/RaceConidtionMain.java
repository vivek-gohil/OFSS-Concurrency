package com.ofss.main;

import com.ofss.main.resource.Counter;

public class RaceConidtionMain {
	public static void main(String[] args) {
		// Counter counter = new Counter();

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				Counter.increment();
			}
		};

		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Count = " + Counter.getCount());
		// Expected : 2000
	}
}
