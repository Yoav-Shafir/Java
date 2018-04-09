package dev.oop.interfaces.Iterable.custom1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Person{
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Persons implements Iterable<Person> {
	
	List<Person> persons = new ArrayList<>();
	
	public void add(Person p) {
		persons.add(p);
	}

	@Override
	public Iterator<Person> iterator() {
		return new PersonIterator();
	}
	
	private class PersonIterator implements Iterator<Person> {
		
		private int pos = 0;
		
		@Override
		public boolean hasNext() {
			return pos < persons.size();
		}

		@Override
		public Person next() {
			return persons.get(pos++);
		}
		
	}
}

public class Main {

	public static void main(String[] args) {
		Persons persons = new Persons();
		persons.add(new Person("Yoav"));
		persons.add(new Person("Eiyar"));
		
		// Using iterator.
		Iterator<Person> it = persons.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Implementing the Iterable interface allows us us "the for-each loop" 
		for (Person p : persons) {
			System.out.println(p);
		}
		
		// Since Java 1.8
		persons.forEach(System.out::println);
	}

}
