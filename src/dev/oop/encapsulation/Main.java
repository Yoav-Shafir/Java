package dev.oop.encapsulation;

class AirConsition1 {
	// Bad encapsulation, can be accessed without setters.
	int power;
	boolean working;
	int temp;
}

class AirConsition2 {
	// Good encapsulation, variables are "hidden"
	// can be accessed or modified only by getters and setters.
	
	// Using setter we can apply logic/validation it gives us control over the fields!
	
	private int power;
	private boolean working;
	private int temp;
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
}

public class Main {

	public static void main(String[] args) {
		AirConsition1 ac1 = new AirConsition1();
		
		// Bad encapsulation
		ac1.power = 1;
		ac1.working = true;
		ac1.temp = 10;
		
		// Good encapsulation.
		AirConsition2 ac2 = new AirConsition2();
		ac2.setPower(1);
		ac2.setWorking(true);
		ac2.setTemp(10);
	}

}
