package dev.oop.hiding.simple1;

class A {
	
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static void myStaticMethod() {
		System.out.println("Printed from A::myStaticMethod");
	}
	
	public void myInstanceMethod() {
		System.out.println("Printed from A::myInstanceMethod");
	}
	
	public void foo() {
		System.out.println("A:foo");
	}
	
}

class B extends A {
	
	// We can't inherit private fields,
	// so if we want to override the setId() method
	// we should create a local `id` field which is called hiding.
	private int id;
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	// Method hiding.
	public static void myStaticMethod() {
		System.out.println("Printed from B::myStaticMethod");
	}
	
	public void myInstanceMethod() {
		System.out.println("Printed from B::myInstanceMethod");
	}
	
	//  You can’t reduce the visibility of a method while overriding it
//	private void foo() {
//		System.out.println("A:foo");
//	}
}

public class Main {

	public static void main(String[] args) {
		
		// Static methods are early binded.
		// We cannot override static methods.
		// So, in this example the static method of the parent class (A) will be called
		A obj1 = new B();
		obj1.myStaticMethod(); // -> Will print Printed from A::myStaticMethod
		
		// This is an instance method, so, at run time
		// the method in B class will be invoked
		obj1.myInstanceMethod(); // -> Will print Printed from B::myInstanceMethod
		
		// Here the early binindg will be on the static method on class B.
		B obj2 = new B();
		obj2.myStaticMethod(); // -> Will print Printed from B::myStaticMethod
		
	}

}
