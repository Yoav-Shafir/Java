package dev.oop.polymorphism.simple1;

// Polymorphism is the ability of an object to take on many forms.
// The most common use of Polymorphism in oop 
// is when a parent class is used to refer to a child class object.

// This can be achieved by Dynamic binding, late binding which happens in run time.
// like here in the callingFill() method, the object type can be determine by the compiler, 
// so the binding happens only in run time.

class Shape {
	Shape() {
		System.out.println("From Shape Constructor");
	}
	
	void fill() {
		System.out.println("Filling Shape");
	}
}

class Circle extends Shape {
	Circle() {
		System.out.println("From Circle Constructor");
	}
	
	void fill() {
		System.out.println("Filling Circle");
	}
}

class Rectangle extends Shape {
	Rectangle() {
		System.out.println("From Rectangle Constructor");
	}
	
	void fill() {
		System.out.println("Filling Rectangle");
	}
}

public class Main {

	public static void main(String[] args) {
		
		Shape shape = new Shape();
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		
		callingFill(shape);
		callingFill(circle);
		callingFill(rectangle);
	}
	
	static void callingFill(Shape shape) {
		shape.fill();
	}
}
