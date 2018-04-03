package dev.constructors.overloading;

// Java constructor is invoked by the JVM at the time of object creation.
// Must have the same name as the class name and must have no return type.
// Constructor is not mandatory in class, there is always a default constructor which doesn't uses
// any input parameters.
// If we create a constructor the default constructor wont be valid anymore.

class Employee {
	private String firstName;
	private String lastName;
	private int id;
	
	// Constructor overloading.
	public Employee() {
	
	}
	
	public Employee(String firstName) {
		this.firstName = firstName;
	}
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Employee(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employ [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println(new Employee()); // -> Employ [firstName=null, lastName=null, id=0]
		System.out.println(new Employee("Yoav"));
		System.out.println(new Employee("Yoav", "Shafir"));
		System.out.println(new Employee("Yoav", "Shafir", 41));
	}

}
 