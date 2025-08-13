package com.ofss.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonThradSafeListMain {
	public static void main(String[] args) throws InterruptedException {
		/// List<Integer> list = new ArrayList<Integer>();
		// CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		// Vector<Integer> list = new Vector<Integer>();
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Size :: " + list.size());
	}
}
