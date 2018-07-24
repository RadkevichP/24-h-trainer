package com.practicaljava.lesson20.streams;

public class Beer {
	public String name;
	public String country;
	public float price;
	
	public Beer(String name, String country, float price) {
		this.name = name;
		this.country = country;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", price: " + price;
	}
}
