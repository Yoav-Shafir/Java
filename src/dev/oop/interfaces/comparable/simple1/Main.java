package dev.oop.interfaces.comparable.simple1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * Comparable Interface.
 * 
 * */
class Person implements Comparable<Person>{
	private int age;
	private int height;
	Person(int age, int height) {
		this.age = age;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "age: " + age + ", height: " + height;
	}
	
	public int getHeight() {
		return height;
	}
	
	/*
	 * 
	 * Implementing the compareTo() method.
	 * 
	 * */
	@Override
	public int compareTo(Person other) {
		if (this.age > other.age) {
			return 1;
		}
		
		if (this.age < other.age) {
			return -1;
		}
		
		return 0;
	}
}

public class Main {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(new Person(1, 10), new Person(3, 30), new Person(2, 20));
		Collections.sort(people);
		
		people.forEach(System.out::println);
		
		/*
		 * 
		 * Using Comparator Functional Interface
		 * 
		 * */
		
		// Sometime the class doesn't implement the Comparable interface
		// or maybe want to sort by different params in run time.
		// This why we have the Comparator which we can pass to the Collections.sort(list, comparator)
		// at run time.
		
		// Using anonymous class.
		Collections.sort((people), new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				if (p1.getHeight() > p2.getHeight()) {
					return -1;
				}
				
				if (p1.getHeight() < p2.getHeight()) {
					return 1;
				}
				
				return 0;
			}
		});
		
		people.forEach(System.out::println);
		
		// Using Java 1.8 lambda.
		Collections.sort((people), (p1, p2) -> {
			if (p1.getHeight() > p2.getHeight()) {
				return 1;
			}
			
			if (p1.getHeight() < p2.getHeight()) {
				return -1;
			}
			
			return 0;
		});
		
		people.forEach(System.out::println);
		
	}

}
