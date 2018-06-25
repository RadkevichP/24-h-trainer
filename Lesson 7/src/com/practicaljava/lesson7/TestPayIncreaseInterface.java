package com.practicaljava.lesson7;

public class TestPayIncreaseInterface {

	public static void main(String[] args) {
		//Create an array of Payable and populate it
		Payable[] workers = new Payable[3];
			workers[0] = new Employee("Berta");
			workers[1] = new Contractor("Liza");
			workers[2] = new Employee("John");
		
		//Increase salaries to all members of the team
				for (Payable p: workers) {
					((Payable)p).increasePay(35);
				}
	}

}
