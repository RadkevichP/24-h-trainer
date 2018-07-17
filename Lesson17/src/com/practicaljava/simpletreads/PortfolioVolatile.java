package com.practicaljava.simpletreads;

public class PortfolioVolatile extends Thread {
	
	private volatile Thread stopMe;
	
	public PortfolioVolatile (String threadName) {
		super(threadName);
	}
	
	public void stopMe() {
		stopMe = null;
	}
	
	public void run() {
		stopMe = Thread.currentThread();
		
		while(stopMe == Thread.currentThread()) {
			System.out.println("The portfolio thread is running");
		}
		System.out.println("The portfolio thread was killed");
	}

}
