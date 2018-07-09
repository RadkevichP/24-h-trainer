package com.practicaljava.lesson13.codesamples;

public class Customer {

	public String name;
	public double grossIncome;
	
	public void applyTaxCalcFunction (TaxFunction taxFunc) {
		double calculatedTax = taxFunc.calcTax(grossIncome);
		System.out.printf("The calculated tax for %s is %.2f \n", name, calculatedTax);
	}
	
}
