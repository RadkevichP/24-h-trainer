package com.practicaljava.lesson12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTestClass {
	
	public static void copyEmployees(List<? extends Employee> from, List<Employee> to) {
		for (Employee e : from) {
			to.add(new Employee(e.getName()));
		}
	}

	public static void main(String[] args) {
		
		List<RetiredEmployee> retired = new LinkedList();
		
		retired.add(new RetiredEmployee("John Smith", 2000.0));
		retired.add(new RetiredEmployee("Peter Parker", 3000.0));
		retired.add(new RetiredEmployee("Philipp Grant", 4000.0));
		
		
		
		//Where to copy 
		List<Employee> employees = new LinkedList();
		
		copyEmployees(retired, employees);
		
		for (Employee e: employees) {
			System.out.println(e.getName());
		}

		List<Employee> testList = new LinkedList();
		testList.add(new Employee("Stephen Johns"));
		testList.add(new Employee("Fred Durst"));
		testList.add(new RetiredEmployee("Vasya", 20.0));
		
		for (Employee e:testList) {
			System.out.println(e);
		}
		
		
	}

}
