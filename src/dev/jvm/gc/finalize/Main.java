package dev.jvm.gc.finalize;

import java.util.concurrent.TimeUnit;

class TestClassForGc {
	public TestClassForGc() {
		System.out.println("TestClassForGc initialized");
	}
	
	public void doingSomething() {
		System.out.println("TestClassForGc.doingSomething method");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Inside the TestClassForGc.finalize method before it being garbage collected");
		super.finalize();
	}
}

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.checkGcInAction();
		
		// Activate the GC, so we can see that finalize method was executed.
		System.gc();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finishing Main");
	}

	private void checkGcInAction() {
		new TestClassForGc().doingSomething();
	}

}
