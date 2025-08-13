package com.ofss.main;

//sleep , join methods
public class ThreadManagementMain {
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
			for (int i = 1; i <= 3; i++) {
				System.out.println("Thread 2 :: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
