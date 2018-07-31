package com.reflection;

import java.lang.reflect.*;

public class ReflectionSample {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.reflection.Employee");
			Method methods[] = c.getDeclaredMethods();
			System.out.println("The Employee methods:");
			for (int i=0; i < methods.length; i++) {
				System.out.println("*** Method signature:" + methods[i].toString());
			}
			
			Class superClass = c.getSuperclass();
			System.out.println("The name of the superclass is " + superClass.getName());
			
			Method superMethods[] = superClass.getDeclaredMethods();
			System.out.println("The superclass has: ");
			
			for (int i=0; i < superMethods.length; i++) {
				System.out.println("***Method Signature: " + superMethods[i].toString());
				System.out.println("    Return type: " + superMethods[i].getReturnType().getName());
			}		
			
			Field[] fields = c.getFields();
			for (int i= 0; i < fields.length; i++) {
				String name = fields[i].getName();
				String type = fields[i].getType().getName();
				
				System.out.println("Creating an instance of Employee");
				Object obj = c.newInstance();
				Object value = fields[i].get(obj);
				System.out.println("Field name: " + name + ", type: " + type + " value: " + value.toString());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
