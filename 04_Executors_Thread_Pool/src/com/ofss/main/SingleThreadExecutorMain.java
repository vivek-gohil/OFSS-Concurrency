package com.ofss.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorMain {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(() -> {
			System.out.println("Task 1 started by " + Thread.currentThread().getName());
			sleep(1000);
			System.out.println("Task 1 finished");
		});
		
		executorService.submit(() -> {
			System.out.println("Task 2 started by " + Thread.currentThread().getName());
			sleep(1000);
			System.out.println("Task 2 finished");
		});
		
		executorService.submit(() -> {
			System.out.println("Task 3 started by " + Thread.currentThread().getName());
			sleep(1000);
			System.out.println("Task 3 finished");
		});
		
		executorService.shutdown();
	}

	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
