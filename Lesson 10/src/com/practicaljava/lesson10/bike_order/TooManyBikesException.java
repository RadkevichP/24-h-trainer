package com.practicaljava.lesson10.bike_order;

public class TooManyBikesException extends Exception {

	public TooManyBikesException(String msgText) {
		super(msgText);
	}
}
