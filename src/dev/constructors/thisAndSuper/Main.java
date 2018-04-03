package dev.constructors.thisAndSuper;

class Person {
	
	protected int id;
	protected String fname;
	protected String lname;
	
	public Person() {
		System.out.println("Person default constructor");
	}
	public Person(int id) {
		// this() inside a constructor must be the first statement.
		// the JVM must be sure that the class is fully initialized.
		this();
		this.id = id;
	}
	public Person(int id, String fname) {
		this(id);
		this.fname = fname;
	}
	public Person(int id, String fname, String lname) {
		this(id, fname);
		this.lname = lname;
		System.out.println("Person 3 args constructor");
	}
}

class Student extends Person {
	
	private String degree;
	
	// With this constructor, the Person default constructor will be called first.
//	public Student(int id, String fname, String lname, String degree) {
//		this.id = id;
//		this.fname = fname;
//		this.lname = lname;
//		this.degree = degree;
//		System.out.println("Student constructor");
//	}
	
	// With this constructor, the Person default constructor will be called first,
	// then the Person 3 args constructor and finally this constructor.
	public Student(int id, String fname, String lname, String degree) {
		super(id, fname, lname);
		this.degree = degree;
		System.out.println("Student constructor");
	}
	
}

public class Main {

	public static void main(String[] args) {
		Student student = new Student(41, "Yoav", "Shafir", "Some Degree");
	}

}
