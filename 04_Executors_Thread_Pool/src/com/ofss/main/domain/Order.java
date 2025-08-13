package com.ofss.main.domain;

import java.util.List;

public class Order {
	private int orderId;
	private int quantity;
	private String description;
	private double amount;
	private List<String> orderStatus;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int quantity, String description, double amount, List<String> orderStatus) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.description = description;
		this.amount = amount;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<String> getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(List<String> orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", description=" + description + ", amount="
				+ amount + ", orderStatus=" + orderStatus + "]";
	}

}
