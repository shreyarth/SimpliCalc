package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
