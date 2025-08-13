package com.ofss.main;

import com.ofss.main.threads.MyRunnable;

public class MyRunnableMain {
	public static void main(String[] args) {
		System.out.println("main start");
		
		//Type Runnable - Runnable
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		
		System.out.println("main end");
	}
}
