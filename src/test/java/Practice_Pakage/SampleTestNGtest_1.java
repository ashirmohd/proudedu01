package Practice_Pakage;

import org.testng.annotations.Test;

public class SampleTestNGtest_1 {

	
	@Test(groups = "smoke")
	public void sampletest1() {
		System.out.println("-->sampletest1--");
	}
	@Test(groups = "regression")
	public void sampletest2() {
		System.out.println("-->sampletest2--");
	}
}
