package com.ofss.main.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.ofss.main.domain.Order;
import com.ofss.main.thread.DispatchOrderThread;
import com.ofss.main.thread.EnrichOrderThread;
import com.ofss.main.thread.FetchOrderThread;
import com.ofss.main.thread.PaymentThread;
import com.ofss.main.thread.SendEmailThread;

public class OrderProcessing {
	public static void doOrderProcessing(ExecutorService executorService, Order order) {
		Order fetchOrder = fetchOrder(executorService, order);
		Order enrichOrder = enrichOrder(executorService, fetchOrder);
		Order paymentOrder = payment(executorService, enrichOrder);
		Order dispatchOrder = dispatch(executorService, paymentOrder);
		sendEmail(executorService, dispatchOrder);
	}

	public static void doAsyncOrderProcessing(ExecutorService executorService, Order order) {
		CompletableFuture.supplyAsync(() -> fetchOrder(executorService, order))
				.thenApply(o -> enrichOrder(executorService, o)).thenApply(o -> payment(executorService, o))
				.thenApply(o -> dispatch(executorService, o)).thenAccept(o -> sendEmail(executorService, o));
	}

	public static Order sendEmail(ExecutorService executorService, Order order) {
		try {
			SendEmailThread sendEmailThread = new SendEmailThread(order);
			Future<Order> future = executorService.submit(sendEmailThread);
			Order updaedOrder = future.get();
			return updaedOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Order dispatch(ExecutorService executorService, Order order) {
		try {
			DispatchOrderThread dispatchOrderThread = new DispatchOrderThread(order);
			Future<Order> future = executorService.submit(dispatchOrderThread);
			Order updaedOrder = future.get();
			return updaedOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Order payment(ExecutorService executorService, Order order) {
		try {
			PaymentThread paymentThread = new PaymentThread(order);
			Future<Order> future = executorService.submit(paymentThread);
			Order updaedOrder = future.get();
			return updaedOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Order enrichOrder(ExecutorService executorService, Order order) {
		try {
			EnrichOrderThread enrichOrderThread = new EnrichOrderThread(order);
			Future<Order> future = executorService.submit(enrichOrderThread);
			Order updaedOrder = future.get();
			return updaedOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Order fetchOrder(ExecutorService executorService, Order order) {
		try {
			FetchOrderThread fetchOrderThread = new FetchOrderThread(order);
			Future<Order> future = executorService.submit(fetchOrderThread);
			Order updaedOrder = future.get();
			return updaedOrder;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
