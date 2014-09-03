package test.testng;

import org.testng.annotations.Test;

/**
 * Here goes the actual Test Class
 * 
 * @author ppahare
 *
 */
public class TestImplementation {
	int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public TestImplementation(int instance) {
		this.order = instance;
	}

	/*
	 * Write your test here.
	 */
	@Test
	public void printMethod1() {
		System.out.println("Method 1, Instance Num is " + order);
	}
	
	/*
	 * Write your test here.
	 */
	@Test
	public void printMethod2() {
		System.out.println("Method 2, Instance Num is " + order);
	}
}