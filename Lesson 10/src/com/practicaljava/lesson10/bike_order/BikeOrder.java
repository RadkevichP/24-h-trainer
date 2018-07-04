package com.practicaljava.lesson10.bike_order;

public class BikeOrder {
	//initial state of the order
	private String order = "";
	
	public String getOrder() {
		return order;
	}
	//method for order validation
	public void validateOrder(String bikeName, int quantity) throws TooManyBikesException {
		if ((bikeName.equals("KidDream") && quantity > 40) || (bikeName.equals("JuniorArrow") && quantity < 35)
				|| (bikeName.equals("TinyLady") && quantity < 30) || (bikeName.equals("KingKong") && quantity < 25)) {
			order = "Your order is accepted: " + bikeName + " : " + quantity;
		}
		else
		{
			throw new TooManyBikesException("You order of " + quantity + " " + bikeName + " can't be shipped, sorry!");
		}
	}
}
