package com.ofss.main;

public class LambdaThreadMain {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(() -> System.out.println("Lambda Thread " + Thread.currentThread().getName()));
		t1.start();
		System.out.println("main end");
	}
}
