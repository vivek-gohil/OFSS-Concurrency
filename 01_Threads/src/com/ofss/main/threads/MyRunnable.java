package com.ofss.main.threads;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Running in Thread :: " + Thread.currentThread().getName());
	}

}
