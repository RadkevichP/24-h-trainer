package com.practicaljava.lesson20.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
		
		/*beers.stream()
			.sorted(Comparator.comparing(b -> b.price))
			.forEach(System.out::println);
		
		beers.stream()
			.sorted(Comparator.comparing((Beer b) -> b.country)
					.thenComparing(b -> b.price))
			.forEach(System.out::println);
		*/
		List<Beer> sortedBeers = beers.stream()
				.sorted(Comparator.comparing(b -> b.price))
				.collect(Collectors.toList());
		
		sortedBeers.forEach(System.out::println);
		
		/*
		System.out.println("===Sorting by ascending price");
		beers.sort(Comparator.comparing(beer -> beer.price));
		beers.forEach(System.out::println);
		
		System.out.println("===Sorting by descending price");
		
		Comparator<Beer> priceComparator = Comparator.comparing(beer -> beer.price);
		beers.sort(priceComparator.reversed());
		beers.forEach(System.out::println);
		
		System.out.println("Sorting by name and price");
		beers.sort(Comparator.comparing((Beer beer) -> beer.name).thenComparing(beer -> beer.price));
		beers.forEach(System.out::println);
		*/
		
		
		

	}

}
