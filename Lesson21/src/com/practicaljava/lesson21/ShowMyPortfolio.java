package com.practicaljava.lesson21;

public class ShowMyPortfolio {

	public static void main(String[] args) {
		Runnable portfolio = new Portfolio();
		Thread portfolioThread = new Thread(portfolio, 
				       "Portfolio Thread");
		portfolioThread.start();
	}

}
