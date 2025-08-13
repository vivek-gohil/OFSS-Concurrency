package com.ofss.main.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionAccountUtil {
	private double balance;
	private final Lock lock = new ReentrantLock();
	private final Condition sufficientFunds = lock.newCondition();

	public ConditionAccountUtil(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		lock.lock();
		try {
			balance += amount;
			System.out.println(Thread.currentThread().getName() + " deposited : " + amount + " balance :" + balance);
			sufficientFunds.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public void withdraw(double amount) throws InterruptedException {
		lock.lock();
		try {
			while (balance < amount) {
				System.out.println(Thread.currentThread().getName() + " waiting for funds...");
				sufficientFunds.await();
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " withdrew : " + amount + " ,balance :" + balance);
		} finally {
			lock.unlock();
		}

	}
}
