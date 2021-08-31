package com.app.model;

public class Product {

	private int id;
	private String pname;
	private double cost;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String pname, double cost) {
		super();
		this.id = id;
		this.pname = pname;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void PrintStream() {
		System.out.printf("Productid = %-4d Product Name = %-20s Product Cost = %-10.2f\n", id, pname, cost);
	}

	

}
