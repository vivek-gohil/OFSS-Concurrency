package com.ofss.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolmain {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

		// 1. Run a task once after 3 seconds
		scheduledExecutorService.schedule(
				() -> System.out.println("Task 1 : Runs after 3 seconds - " + Thread.currentThread().getName()), 3,
				TimeUnit.SECONDS);

		// 2. Run a task repeatedly every 2 seconds, starting after 1 second
		scheduledExecutorService.scheduleAtFixedRate(
				() -> System.out.println("Task 2 : Fixed Rate - " + Thread.currentThread().getName()), 1, 2,
				TimeUnit.SECONDS);

		scheduledExecutorService.schedule(() -> {
			System.out.println("Shutting down scheduler");
			scheduledExecutorService.shutdown();
		}, 10, TimeUnit.SECONDS);

	}
}
