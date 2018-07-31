package com.tryit;

@DBParams(dbName = "staff", password = "admin", uid = 55)

public class MyDBWorker {
	
	public String name;
	public int id;
	
	public void sayHello() {
		System.out.println("Hello!");
	}
}
