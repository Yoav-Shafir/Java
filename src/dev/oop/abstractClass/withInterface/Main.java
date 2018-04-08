package dev.oop.abstractClass.withInterface;

interface MyInterface {
	public abstract void foo();
}

abstract class A implements MyInterface {
	// abstract class don't need to implement the MyInterface foo() method!!!
	
	protected String identifier;
	
	public A() {
		this.identifier = "This is a special identifier";
	}
	
	public abstract String getIdentifier();
	
	// We can declare a `throws` on an abstract method.(also interface method)
	public abstract void doSomething() throws Exception;
}

// B extends A which is abstract class, A also implements the MyInterface interface.
class B extends A {
	
	// This implementation is because of the MyInterface foo() method
	@Override
	public void foo() {
		System.out.println("Foo from B");
	}
	
	// This implementation is because of the A class getId() method
	@Override
	public String getIdentifier() {
		return "identifier: " + this.identifier + " From B implementation";
	}

	@Override
	public void doSomething() throws Exception {
		// Do something
	}
	
}

public class Main {

	public static void main(String[] args) {
		B b = new B();
		b.foo();
		System.out.println(b.getIdentifier());
	}
}
