package Practice_Pakage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.ExcelUtility;

public class readdatafromexel {
	@Test(dataProvider = "data")
	public void result(String from,String to) {
		System.out.println(from+"----->"+to);
	
	
	
	
	
	
	
}
	
	@DataProvider
	public Object[][] data() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		Object[][] value = elib.readmultipledata("dataprovider");
		return value;
	}

}
