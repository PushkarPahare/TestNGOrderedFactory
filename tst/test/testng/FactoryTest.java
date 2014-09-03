package test.testng;

import org.testng.annotations.Factory;

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
