package com.practicaljava.codesamples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClassA {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.lName = "Watson";
		emp.fName = "John";
		emp.saalary = 50000;
		
		try (FileOutputStream fOut = new FileOutputStream("BestEmployee.ser");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);){
			
			oOut.writeObject(emp); //serializing employee
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("Employee object has been serialized into BestEmployee.ser");
		
	}

}
