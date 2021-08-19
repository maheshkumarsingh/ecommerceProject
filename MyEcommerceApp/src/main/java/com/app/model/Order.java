package com.app.model;

public class Order {
	private int orderid;
	private String username;
	private int productid;
	private String status;

	public Order() {
		super();

	}

	public Order(int orderid, String username, int productid, String status) {
		super();
		this.orderid = orderid;
		this.username = username;
		this.productid = productid;
		this.status = status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "orderid=" + orderid + ", productid=" + productid + ", status=" + status + "";
	}

}
