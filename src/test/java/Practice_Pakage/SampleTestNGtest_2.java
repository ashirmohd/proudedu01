package Practice_Pakage;

import org.testng.annotations.Test;

public class SampleTestNGtest_2 {

	
	@Test(groups = {"smoke","regression"})
	public void sampletest3() {
		System.out.println("-->sampletest3--");
	}
	@Test(groups = "regression")
	public void sampletest4() {
		System.out.println("--->sampletest4---");
	}
}
