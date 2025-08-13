package com.ofss.main;

import com.ofss.main.threads.ThreadExample;

public class ThreadExampleMain {
	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread threadOne = new Thread(() -> ThreadExample.task("Task 1"));
		Thread threadTwo = new Thread(() -> ThreadExample.task("Task 2"));
		
		threadOne.start();
		threadTwo.start();
		
		
		System.out.println("main end");
	}
}
