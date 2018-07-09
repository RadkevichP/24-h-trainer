package com.practicaljava.lesson13;

import com.practicaljava.lesson13.Person;

public class TestPayIncreaseLambda {

	public static void main(String[] args) {


		Person workers[] = new Person[3];
		workers[0] = new Person("John Watson", 'E');
		workers[1] = new Person("Freddy Mercury", 'C');
		workers[2] = new Person("Steve Jobs", 'E');
		
		//Lambda expression for increasing Employee's pay
		Payable increaseRuleEmployee = (int percent) -> {
			return true;
		};

		//Lambda exp for increasing Contractor's pay
		Payable increaseRuleContractor = (int percent) -> {
			if (percent > Payable.INCREASE_CAP) {
				System.out.println("Sorry, can't increase hourly rate by more than " + 
			Payable.INCREASE_CAP + "%");
				return false;
			} else {
				return true;
			}
		};
		
		
		for (Person p: workers) {
			if ('E' == p.getWorkerStatus()) {
				p.validatePayIncrease(increaseRuleEmployee, 30);
			} else if('C' == p.getWorkerStatus()) {
				p.validatePayIncrease(increaseRuleContractor, 30);
			}
		}

	}

}
