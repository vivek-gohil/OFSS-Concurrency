package com.ofss.main;

import com.ofss.main.util.AccountUtil;

public class AccountsUtilMain {
	public static void main(String[] args) {
		AccountUtil accountUtil = new AccountUtil(2000, true);

		Runnable taskWithdraw = () -> {
			try {
				accountUtil.withdaw(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable taskDeposit = () -> {
			try {
				accountUtil.deposit(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(taskWithdraw, "Withdraw-Thread-1");
		Thread t2 = new Thread(taskDeposit, "Deposit-Thread-2");
		Thread t3 = new Thread(taskWithdraw, "Withdraw-Thread-3");
		Thread t4 = new Thread(taskDeposit, "Deposit-Thread-4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
