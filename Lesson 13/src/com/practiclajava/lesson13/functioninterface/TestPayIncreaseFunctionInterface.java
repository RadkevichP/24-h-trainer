package com.practiclajava.lesson13.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TestPayIncreaseFunctionInterface {

	public static void main(String[] args) {


		final int INCREASE_CAP = 20;
		
		int proposedIncrease = 30;
		
		Person workers[] = new Person[3];
		workers[0] = new Person("John Watson", 'E');
		workers[1] = new Person("Freddy Mercury", 'C');
		workers[2] = new Person("Steve Jobs", 'E');
		
		List<Person> workersList = Arrays.asList(workers);
		//define function with 2 arguments: Person & percent that returns boolean
		BiFunction<Person ,Integer, Boolean> increaseRulesEmployee = (pers, percent) -> {
			System.out.println("Increasing pay for " + pers.getName() + " is valid");
			return true;
		};
		
		//define function for increasing contractor's pay
		BiFunction<Person, Integer, Boolean> increaseRulesContractor = (pers, percent) -> {
			if (percent > INCREASE_CAP) {
				System.out.println("Sorry, can't increase hourly rate by more than " + INCREASE_CAP + " % for " + pers.getName() );
				return false;
			} else {
				return true;
			}
		};
		
		//validate pay increase
		workersList.forEach(pers -> {
			if ('E' == pers.getWorkerStatus()) {
			pers.validateIncreasePay(increaseRulesEmployee, proposedIncrease);
			
			} else if ('C' == pers.getWorkerStatus()) {
				pers.validateIncreasePay(increaseRulesContractor, proposedIncrease);
			}
		});
	}
}
