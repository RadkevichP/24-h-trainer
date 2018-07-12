package com.practicaljava.codesamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassB {

	public static void main(String[] args) {

		try (FileInputStream fInput = new FileInputStream("BestEmployee.ser");
				ObjectInputStream oIn = new ObjectInputStream(fInput);) {
		
			Employee bestEmployee = (Employee) oIn.readObject();
			System.out.println(bestEmployee.fName);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("The Employee object has been deserialized succesfully!");

		

	}

}
