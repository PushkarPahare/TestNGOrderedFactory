package test.testng;

import org.testng.annotations.Test;

public class TestImplementation {
	int c_instance;

	public int getC_instance() {
		return c_instance;
	}

	public void setC_instance(int c_instance) {
		this.c_instance = c_instance;
	}

	public TestImplementation(int instance) {
		this.c_instance = instance;
	}

	@Test
	public void printMethod() {
		System.out.println("Instance Num is " + c_instance);
	}
}