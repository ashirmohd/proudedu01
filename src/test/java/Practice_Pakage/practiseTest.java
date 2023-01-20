package Practice_Pakage;

import org.testng.annotations.Test;

public class practiseTest {
	
	

	@Test(priority = -1,dependsOnMethods = "delete")
	public void create() {
		System.out.println("created");
	}
	@Test(priority = 1)
	public void excute() {
		System.out.println("excuted");
	}
	@Test(priority = 1,invocationCount = 2)
	public void delete() {
		System.out.println("deleted");
	}
}
