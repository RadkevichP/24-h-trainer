package com.practicaljava.lesson13.codesamples;

import java.util.Arrays;
import java.util.List;

public class TestCollectionForEach {

	public static void main(String[] args) {
		// Create array of workers and populate it
		
		Person workers[] = new Person[3];
		workers[0] = new Person("John Watson", 'E');
		workers[1] = new Person("Freddy Mercury", 'C');
		workers[2] = new Person("Steve Jobs", 'E');
		
		List<Person> workersList = Arrays.asList(workers);
		
		//Imperative loop
		System.out.println("Running imperative loop");
		
		for (Person person: workersList) {
			if('E' == person.getWorkerStatus()) {
				System.out.println(person.getName() + " is employee");
			} else if('C' == person.getWorkerStatus()) {
				System.out.println(person.getName() + " is contractor");
			}
		}
		
		//Functional loop
		System.out.println("Running functional loop");
		
		workersList.forEach(person -> {
			if('E' == person.getWorkerStatus()) {
				System.out.println(person.getName() + " is employee");
			} else if('C' == person.getWorkerStatus()) {
				System.out.println(person.getName() + " is contractor");
			}
		});
		

	}

}
