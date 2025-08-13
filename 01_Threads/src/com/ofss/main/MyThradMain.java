package com.ofss.main;

import com.ofss.main.threads.MyThread;

public class MyThradMain {
	public static void main(String[] args) {
		System.out.println("main start");
		
		MyThread t1 = new MyThread();
		t1.setName("child-thread");
		//t1.start(); // start new thread in jvm
		t1.run(); //not create new thread - its a simple function call 
		
		System.out.println("main end");
	}
}
