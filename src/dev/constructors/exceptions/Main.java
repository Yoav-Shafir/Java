package dev.constructors.exceptions;

// A Constructor can throw Exception.
class Employee {
	
	public Employee() throws Exception {
		System.out.println("Inside Employee Constructor");
		throw new Exception("From Constructor");
	}
	
}

public class Main {

	public static void main(String[] args) throws Exception {
		new Employee();
	}

}
