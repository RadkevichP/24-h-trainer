package com.practicaljava.lesson13.codesamples;

public class TestTaxLambda {

	public static void main(String[] args) {
		// Define taxFunction as a lambda expression and store it in a variable

		TaxFunction taxFunction = (double grossIncome) -> {

			double federalTax = 0;
			if (grossIncome < 30000) {
				federalTax = grossIncome * 0.05;
			} else {
				federalTax = grossIncome * 0.06;
			}
			return federalTax;
		};

		// Define another function as a lambda expression
		// for calculating tax for mafia members

		TaxFunction taxFunctionMafia = (double grossIncome) -> {
			double stateTax;
			if (grossIncome < 30000) {
				stateTax = grossIncome * 0.01;
			} else {
				stateTax = grossIncome * 0.02;
			}
			return stateTax;
		};

		// Instantiate customers from different society groups
		// and calculate taxes for them

		Customer customer1 = new Customer();
		customer1.name = "Mary Jane";
		customer1.grossIncome = 50000;
		customer1.applyTaxCalcFunction(taxFunction);

		Customer customer2 = new Customer();
		customer2.name = "Al Capone";
		customer2.grossIncome = 50000;
		customer2.applyTaxCalcFunction(taxFunctionMafia);

	}

}
