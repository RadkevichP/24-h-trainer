package com.practicaljava.codesamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class EmpProcessor {

	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		emp.fName = "John";
		emp.lName = "Watson";
		emp.salary = 50000;
		emp.address = "12 main street";
		emp.hireDate = new Date();
		emp.id = 123;
		
		try (FileOutputStream fOut = new FileOutputStream("NewEmployee2.ser");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);) {
			emp.writeExternal(oOut);
			System.out.println("An employee is externalized into NewEmployee2.ser");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try (FileInputStream fInp = new FileInputStream("NewEmployee2.ser");
			ObjectInputStream oInp = new ObjectInputStream(fInp);) {
			
			Employee2 fenixEmployee = new Employee2();
			fenixEmployee.readExternal(oInp);
			
			System.out.println("Deserialized employee with id: " + fenixEmployee.id);
			System.out.printf("salary = $%7.2f \n", fenixEmployee.salary);
			System.out.println("name =" + fenixEmployee.fName);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

}
