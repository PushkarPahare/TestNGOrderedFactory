package test.testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class CustomMethodInterceptor implements  IMethodInterceptor {

	/**
	 * Overriding the intercept method. 
	 * 
	 * Get the list of IMethodInstance that testng will if not modified by this method.
	 * 
	 * Intercept provides you to play with the list of methods at runtime. That is you, intentionally 
	 * or unintentionally remove a couple of method, those method will be gone for good and wil not be executed by
	 * TestNG.
	 * 
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,
			ITestContext context) {
		List<Tuple> transientList = new ArrayList<Tuple>();
		
		//Creating a transient Data Structure to hold TestNg method instacne and 
		//our test class instance together.
		for(IMethodInstance method : methods) {
			if(method.getInstance() instanceof TestImplementation) {
				TestImplementation factoryImpl = (TestImplementation)method.getInstance();
				transientList.add(new Tuple(method, factoryImpl));
			}
		}
		
		//Sort based on TestImplementation
		Collections.sort(transientList);
		
		List<IMethodInstance> orderITestMethodInstance = 
				new ArrayList<IMethodInstance>();
		for(Tuple testMethod : transientList) {
			orderITestMethodInstance.add(testMethod.method);
		}
		
		return orderITestMethodInstance;
	}

	/**
	 * This class solely exists to sort list of IMethod Execution
	 * 
	 * You can use any other method to sort the List (based on your Test class)
	 * 
	 * @author ppahare
	 *
	 */
	class Tuple implements Comparable<Tuple> {
		IMethodInstance method;
		TestImplementation test;
		
		Tuple(IMethodInstance method, TestImplementation test) {
			this.method = method;
			this.test = test;
		}

		@Override
		public int compareTo(Tuple o) {
			if (o.test.getOrder() == this.test.getOrder()) {
				return 0;
			} else if (o.test.getOrder() > this.test.getOrder()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
