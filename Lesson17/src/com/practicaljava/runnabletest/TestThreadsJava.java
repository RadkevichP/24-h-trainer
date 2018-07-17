package com.practicaljava.runnabletest;

public class TestThreadsJava {

	public static void main(String[] args) {
		// Lambda expression for market news
		Runnable mn = () -> {
			try {
				for (int i=0; i<10; i++) {
					Thread.sleep(1000); //assign sleeping time
					System.out.println("The market is improving " + i);
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};
		
		Thread marketNews = new Thread(mn, "Market News");
		marketNews.start();
		
		//Lambda expression for Portfolio
		Runnable port = () -> {
			try {
				for (int i=0; i<10; i++) {
					Thread.sleep(700); //sleep for 700 milliseconds
					System.out.println("You have " + (500 + i) + " shares of IBM");
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};
		
		Thread portfolio = new Thread(port, "Portfolio");
		portfolio.start();
		System.out.println("The main method is finished");

	}

}
