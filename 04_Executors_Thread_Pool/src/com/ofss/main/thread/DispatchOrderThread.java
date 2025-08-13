package com.ofss.main.thread;

import java.util.List;
import java.util.concurrent.Callable;

import com.ofss.main.domain.Order;

public class DispatchOrderThread implements Callable<Order> {
	private Order order;

	public DispatchOrderThread(Order order) {
		super();
		this.order = order;
	}

	@Override
	public Order call() throws Exception {
		List<String> orderStatus = order.getOrderStatus();
		Thread.sleep(200);
		orderStatus.add("Dispatch Order");
		System.out.println(order);
		return order;
	}

}
