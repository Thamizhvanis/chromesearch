package chromebing;

import org.testng.TestNG;

import chromebing.chrometest;

public class chromerunner {
	
	public static void main(String[] args) {
		TestNG testNg = new TestNG();
		 testNg.setTestClasses(new Class[] {chrometest.class});
			testNg.run();

}
}