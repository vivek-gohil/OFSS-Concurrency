package com.ofss.main.threads;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Running in Thread :: " + Thread.currentThread().getName());
	}
}
