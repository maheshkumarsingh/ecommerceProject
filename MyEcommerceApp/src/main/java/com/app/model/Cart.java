package com.app.model;

public class Cart {
	private int cartid;
	private String username;
	private Product product;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartid, String username, Product product) {
		super();
		this.cartid = cartid;
		this.username = username;
		this.product = product;
	}


	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "[" + product + "]";
	}

	
	

	

}
