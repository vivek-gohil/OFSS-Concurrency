package com.ofss.main;

import com.ofss.main.util.TransactionManager;

public class TransactionMain {
	public static void main(String[] args) {
		TransactionManager transactionManager = new TransactionManager();

		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				transactionManager.performTransaction("DEPOSIT");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread1 = new Thread(task, "Thread-One");
		Thread thread2 = new Thread(task, "Thread-Two");

		thread1.start();
		thread2.start();

		try {
			thread2.join();
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Total Transactions :: " + transactionManager.getTransactionCount());

	}
}
