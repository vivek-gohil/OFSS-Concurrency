package com.ofss.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.ofss.main.thread.CallableTask;

public class CallableMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main start");
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Future<Integer> future = executorService.submit(new CallableTask());
		System.out.println("Task is submitted");

		System.out.println("main");
		for (int i = 0; i < 30; i++) {
			System.out.println("main :: " + i);
			// Thread.sleep(100);
		}

		// blocking
		int result = future.get();
		System.out.println("Result = " + result);
		System.out.println("main end");

	}
}
