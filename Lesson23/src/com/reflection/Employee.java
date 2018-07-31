package com.reflection;

public class Employee extends Person {
	
	public String name = "Pavel";
	private int id = 235;
	public boolean isMarried = true;

	@Override
	public void raiseSalary() {
		System.out.println("Raising salary for Employee...");
	}
	
	public void changeAdress(String newAddress) {
		System.out.println("The new address is " + newAddress);
	}
}
