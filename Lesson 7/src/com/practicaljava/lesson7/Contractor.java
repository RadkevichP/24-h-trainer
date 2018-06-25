package com.practicaljava.lesson7;

public class Contractor implements Payable {
		private String name;
		
		public Contractor(String name) {
			this.name = name;			
		}
		
	@Override
	public boolean increasePay(int percent) {
			if (percent < INCREASE_CAP) {
				System.out.println("Increasing hourly rate by " + percent + " % " + name);
		return true;
		} else {
			System.out.println("Can't increase hourly rate by more than " + Payable.INCREASE_CAP + " % " + name );
			return false;
		}
	}

}
