package com.ofss.main;

import com.ofss.main.util.NoThreadExample;

public class NoThreadMain {
	public static void main(String[] args) {
		System.out.println("main start");
		NoThreadExample.task("Task 1");
		System.out.println("Back to main");
		NoThreadExample.task("Task 2");
		System.out.println("main end");
	}
}
