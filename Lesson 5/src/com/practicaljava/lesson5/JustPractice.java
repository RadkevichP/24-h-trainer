package com.practicaljava.lesson5;

public class JustPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaring an array and populating it
		String[] friends = new String[10];
		friends[0] = "Masha";
		friends[1] = "Dasha";
		friends[2] = "Petya";
		friends[3] = "Vanya";
		friends[4] = "Felix";
		friends[5] = "John";
		friends[6] = "Dima";
		
		System.out.println("The third friend is " + friends[2]);
		//how many friends you have
		
		int numberOfFriends = friends.length;
		System.out.println("You've got " + numberOfFriends + " friends");
		
		//printing names from the friend-list with "for" loop
		for (int i=0; i < numberOfFriends; i++) {
			System.out.println("Your friend is " + friends[i]);
		}
		//printing names from friend-list with "for-each" loop
		for(String friend: friends) {
			System.out.println(friend + " is a friend of mine:)");
		}
		
		//printing with "while" loop
		int i = 0;
		while (i<numberOfFriends) {
			if (friends[i] == null) {
				System.out.println("The element " + (i+1) + " is null");
				break;

			}
			else {
			System.out.println("The name of your friend is " + friends[i]);
			i++;
			}
		}
		
		//practice with "continue"
		String[] friends2 = new String[20];
		friends2[0] = "Masha";
		friends2[1] = "Dasha";
		friends2[6] = "Petya";
		friends2[8] = "Vanya";
		friends2[10] = "Felix";
		friends2[15] = "John";
		friends2[17] = "Dima";
		
		int totalElements = friends2.length;
		int j = 0;
		
		while (j < totalElements) {
			if (friends2[j]==null) {
				j++;
				continue;
			} else {
			System.out.println("MY GREAT friend is: " + friends2[j]);
			j++;
			}
		}
		System.out.println("The iteration is over");
	
		
		//practice with StringBuffer
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("Mary");
		sbf.append(" is ");
		sbf.append("my best friend!");
		System.out.println(sbf);
		System.out.println(sbf.toString());
		System.out.println(sbf.equals(sbf.toString()));
		
		//compare Strings with method "equals"
		
		String friend1 = "Ivan";
		String friend2 = "Petr";
		String friend3 = "Ivan";
		System.out.println(friend1 == friend3);
		
		
		String friend4 =new String("Ivan");
		String friend5 = new String("Petr");
		String friend6 = new String("Ivan");
		System.out.println(friend4 == friend6);
		System.out.println(friend4.equals(friend6));
		
		
	}

}
