package com.practicaljava.lesson10;

public class ExceptionTestDemo {
	
	public ExceptionTestDemo() {
		//divideByZero();
	}
	
	private void withdraw(double sum) {
		if(sum > 5000) {
			throw new RuntimeException("You're exceeded the withdraw limit!");
		} else 
			System.out.println("You're welcome!");
		
	}

	public static void main(String[] args) {
		ExceptionTestDemo ex = new ExceptionTestDemo();
		
		try {
		ex.withdraw(2400);
		ex.withdraw(6000);
		ex.withdraw(2000);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
