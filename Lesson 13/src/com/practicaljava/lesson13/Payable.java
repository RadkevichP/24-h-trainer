package com.practicaljava.lesson13;

public interface Payable {
	int INCREASE_CAP_CONTRACTOR = 20;
	int INCREASE_CAP_FOREIGNER = 5;
	boolean increasePay(int percent);
}
