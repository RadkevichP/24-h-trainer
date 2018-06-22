package com.practicaljava.lesson4;

public class Tax {
		//declare class member variables
		double grossIncome;
		String state;
		int dependents;
		static int customerCounter;
		
		//constructor
		Tax (double gi, String st, int depen) {
			grossIncome = gi;
			state = st;
			dependents = depen;
			//increment counter by one with every single instance of Tax
			customerCounter++; 
			System.out.println("Preparing the tax data for customer#" + customerCounter);
			
		}
		
		//method for the tax calculation
		double calcTax() {
			return (grossIncome*0.33 - dependents*100);
		}
		
		//utility method to convert your tax amount into euros (with only course 1.25)
		public static void convertToEuros(double taxInDollars) {
			double taxInEuros = taxInDollars /1.25 ;
			System.out.println("Tax in Euros is " +taxInEuros);
		}
	
}
