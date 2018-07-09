package com.practicaljava.lesson13;

import com.practicaljava.lesson13.Person;

public class TestPayIncreaseLambda {

	public static void main(String[] args) {


		Person workers[] = new Person[5];
		workers[0] = new Person("John Watson", 'E');
		workers[1] = new Person("Freddy Mercury", 'C');
		workers[2] = new Person("Steve Jobs", 'E');
		workers[3] = new Person("Peter Parker", 'F');
		workers[4] = new Person("David Bowie", 'F');
		
		//Lambda expression for increasing Employee's pay
		Payable increaseRuleEmployee = (int percent) -> {
			return true;
		};

		//Lambda exp for increasing Contractor's pay
		Payable increaseRuleContractor = (int percent) -> {
			if (percent > Payable.INCREASE_CAP_CONTRACTOR) {
				System.out.println("Sorry, can't increase hourly rate by more than " + 
			Payable.INCREASE_CAP_CONTRACTOR + "%");
				return false;
			} else {
				return true;
			}
		};
		
		//lambda exp for increasing Foreigner's pay
		Payable increaseRuleForeigner = (int percent) -> {
			if (percent > Payable.INCREASE_CAP_FOREIGNER) {
				System.out.println("Sorry, we haven't permissio to increase by more than " + Payable.INCREASE_CAP_FOREIGNER);
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
			} else if ('F' == p.getWorkerStatus()) {
				p.validatePayIncrease(increaseRuleForeigner, 14);
			}
		}

	}

}
