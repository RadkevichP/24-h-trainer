package com.practicaljava.lesson20.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class LazyStreamsDemo {
	
	//Populate beer collection
	static List<Beer> loadCellar() {
		List<Beer> beerStock = new ArrayList<>();
		
		beerStock.add(new Beer("Stella", "Belgium", 7.75f));
		beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
		beerStock.add(new Beer("Obolon", "Ukraine", 4.05f));
		beerStock.add(new Beer("Bud Light", "USA", 5.00f));
		beerStock.add(new Beer("Yengling", "USA", 5.50f));
		beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
		beerStock.add(new Beer("Chimay Blue", "Belgium", 10.75f));
		beerStock.add(new Beer("Artois", "Belgium", 11.75f));
		beerStock.add(new Beer("Alivaria", "Belarus", 3.75f));
		
		return beerStock;
	}

	public static void main(String[] args) {
		
		List<Beer> beers = loadCellar();
		
		//first intermediate operation
		Stream<Beer> americanBeers = beers.stream()
				.filter(brss -> {
					System.out.println("Inside filter: " + brss.country);
					return "USA".equals(brss.country);
				});
		
		//second intermediate operation
		DoubleStream americanBeerPrices = americanBeers
				.mapToDouble(brrr -> {
					System.out.println("Inside mapToDouble: "
							+ brrr.price);
					return brrr.price;
				});
		
		//terminal operation
		System.out.println("The average American beer price is $" + 
				americanBeerPrices.average().getAsDouble());

	}

}
