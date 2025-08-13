package com.ofss.main;

public class DaemonThreadMain {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Thread 1 :: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			while (true) {
				System.out.println("Daemon thread is running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.setDaemon(true);
		t2.start();
		System.out.println("main end");
	}
}
