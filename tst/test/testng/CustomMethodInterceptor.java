package test.testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class CustomMethodInterceptor implements  IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,
			ITestContext context) {
		List<Tuple> transientList = new ArrayList<Tuple>();
		
		for(IMethodInstance method : methods) {
			if(method.getInstance() instanceof TestImplementation) {
				TestImplementation factoryImpl = (TestImplementation)method.getInstance();
				transientList.add(new Tuple(method, factoryImpl));
			}
		}
		
		Collections.sort(transientList);
		
		List<IMethodInstance> orderITestMethodInstance = 
				new ArrayList<IMethodInstance>();
		for(Tuple testMethod : transientList) {
			orderITestMethodInstance.add(testMethod.method);
		}
		
		return orderITestMethodInstance;
	}

	class Tuple implements Comparable<Tuple> {
		IMethodInstance method;
		TestImplementation test;
		
		Tuple(IMethodInstance method, TestImplementation test) {
			this.method = method;
			this.test = test;
		}

		@Override
		public int compareTo(Tuple o) {
			if (o.test.getC_instance() == this.test.getC_instance()) {
				return 0;
			} else if (o.test.getC_instance() > this.test.getC_instance()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
