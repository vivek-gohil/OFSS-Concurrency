package com.ofss.main;

import com.ofss.main.util.ConditionAccountUtil;

public class ConditionAccountMain {
	public static void main(String[] args) throws InterruptedException {
		ConditionAccountUtil accountUtil = new ConditionAccountUtil(500);

		Thread withdrawThread = new Thread(() -> {
			try {
				accountUtil.withdraw(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread depositThread = new Thread(() -> accountUtil.deposit(700));

		withdrawThread.start();

		Thread.sleep(2000);

		depositThread.start();

	}
}
