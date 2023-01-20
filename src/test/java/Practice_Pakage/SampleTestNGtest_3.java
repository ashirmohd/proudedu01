package Practice_Pakage;

import org.testng.annotations.Test;

public class SampleTestNGtest_3 {

	@Test(groups = {"smoke","regression"})
	public void smapletest5() {
		System.out.println("-->sampletest5--");
	}
	@Test(groups ="smoke")
	public void sampletest6() {
		System.out.println("-->sampletest6--");
	}
}
