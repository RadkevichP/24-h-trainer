package com.practicaljava.runnabletest;

public class TestLambdaNotify {
	
	private static Runnable getMktNewsRunnable (Object whoToNotify){
		//returning a closure
		return () -> {
			try {
				for (int i =0; i<10; i++) {
					Thread.sleep(1000); //sleep for 1 second
					System.out.println("The market is improving " + i);
				}
				
				synchronized(whoToNotify) {
					whoToNotify.notify(); //send notification to parent
				}
			} catch(InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + e.toString());
			}
		};	
		
	}

	public static void main(String[] args) {
		
		TestLambdaNotify thisInstance = new TestLambdaNotify();
		
		Runnable mktNewsRunnable = getMktNewsRunnable(thisInstance);
		Thread marketNews = new Thread(mktNewsRunnable, "");
		marketNews.start();
		
		synchronized (thisInstance) {
			try {
			thisInstance.wait(20000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
		System.out.println("The main method of TestLambdaNotify is finished");

	}

}
