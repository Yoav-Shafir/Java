package dev.oop.defaultMethod.simple1;

// What is the motivation of adding default methods to interfaces?
// because it helps extend the interface with additional functionality without breaking
// the implementation classes.

interface Shape {
	void fill();
	
	default void setTransparency(int transparency) {
		System.out.println("The setTransparency wasn't implemented");
	}
}

// With default methods on interfaces we can create multiple inheritance.
// so in case of 2 interfaces with the same method name and signature, we get a compiler error.
// In order to solve it we must to override it in the child class.
interface Transparency {

	default void setTransparency() {
		System.out.println("The setTransparency wasn't implemented");
	}
}

class Circle implements Shape, Transparency {
	
	public void fill() {
		System.out.println("Filling Circle");
	}
	
	@Override
	public void setTransparency() {
		System.out.println("Circle setTransparency() implementation");
	}
}

class Rectangle implements Shape, Transparency {
	Rectangle() {
		System.out.println("From Rectangle Constructor");
	}
	 
	public void fill() {
		System.out.println("Filling Rectangle");
	}

	@Override
	public void setTransparency() {
		System.out.println("Rectangle setTransparency() implementation");
	}
}

public class Main {

	public static void main(String[] args) {
		Transparency circle = new Circle();
		Transparency rectangle = new Rectangle();
		
		callingFill(circle);
		callingFill(rectangle);
	}
	
	static void callingFill(Transparency shape) {
		shape.setTransparency();
	}
}
