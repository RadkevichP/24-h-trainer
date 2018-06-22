package com.practicaljava.lesson4;

public class CalcTax {

	public static void main(String[] args) {
		// declare local variables
		double grossIncome;
		String state;
		int dependents;
		
		grossIncome = 50000;
		state = "IL";
		dependents = 4;
		
		Tax t = new Tax(grossIncome, state, dependents);
		double yourTax = t.calcTax();
		
		//Printing the result of tax calculations
		System.out.println("Your tax is: " + yourTax);
		Tax.convertToEuros(yourTax);
		
		Tax t2 = new Tax(80000, "AZ", 3);
		double hisTax = t2.calcTax();
		
		//Printing the result of the tax calculations for another customer
		System.out.println("His tax is: " + hisTax);
		Tax.convertToEuros(hisTax);
	}

}
