package com.ofss.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolMain {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 6; i++) {
			int taskId = i;
			executorService.submit(() -> {
				System.out.println("Taks " + taskId + " started by " + Thread.currentThread().getName());
				sleep(1000);
				System.out.println("Taks " + taskId + " finished by " + Thread.currentThread().getName());
			});
			System.out.println();
		}

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
