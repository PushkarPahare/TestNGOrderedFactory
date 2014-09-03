package test.testng;

import org.testng.annotations.Factory;

/**
 * Factory class that creates instances of TestImplementation and sets the order of execution
 * 
 * @author ppahare
 *
 */
public class FactoryTest {
	@Factory
	public Object[] createTest() {
		Object[] res = new Object[3];
		for (int i = 1; i <= 3; i++) {
			res[i - 1] = new test.testng.TestImplementation(i);
		}
		return res;
	}
}
