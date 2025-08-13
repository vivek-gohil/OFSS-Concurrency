package com.ofss.main.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AccountUtil {
	private double balance;
	private final ReentrantLock lock;

	public AccountUtil(double balance, boolean fair) {
		this.balance = balance;
		this.lock = new ReentrantLock(fair);
	}

	public boolean withdaw(double amount) throws InterruptedException {
		// Time lock
		if (lock.tryLock(5, TimeUnit.SECONDS)) {
			System.out.println("withdraw locked " + Thread.currentThread().getName());
			try {
				if (balance >= amount) {
					System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
					balance -= amount;
					return true;
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient funds ");
					return false;
				}
			} finally {
				lock.unlock();
				System.out.println("withdraw - unlocked " + Thread.currentThread().getName());
			}

		} else {
			System.out.println(Thread.currentThread().getName() + " could not get lock, timed out");
		}
		return false;
	}

	public boolean deposit(double amount) throws InterruptedException {
		if (lock.tryLock()) {
			System.out.println("deposit locked " + Thread.currentThread().getName());
			try {
				System.out.println(Thread.currentThread().getName() + " depositing " + amount);
				balance += amount;
				return true;
			} finally {
				lock.unlock();
				System.out.println("deposit - unlocked " + Thread.currentThread().getName());

			}
		} else {
			System.out.println(Thread.currentThread().getName() + " could not get lock , skipping deposit");
			return false;
		}
	}

	public double getBalance() {
		return balance;
	}

}
