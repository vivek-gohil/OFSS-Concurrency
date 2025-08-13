package com.ofss.main.util;

import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
	private final AtomicInteger transactionCount = new AtomicInteger(0);

	public void performTransaction(String transactionType) {
		// Increment atomically
		int current = transactionCount.incrementAndGet();
		System.out.println(Thread.currentThread().getName() + " performed " + transactionType
				+ ", total transactions : " + current);
	}

	public int getTransactionCount() {
		return transactionCount.get();
	}
}
