
package Practice_Pakage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_data_provider {

	@Test(dataProvider = "checkdataprovider")
	public void travel(String src,String dest,int fare) {
		System.out.println("from"+src+"----->"+"to"+dest+fare);
	}
	
	
	
	
	@DataProvider
	public Object[][] checkdataprovider() {
		Object[][] objet=new Object[3][3];
		objet[0][0]="bangalore";
		objet[0][1]="mysore";
		objet[0][2]=200;


		objet[1][0]="mysore";
		objet[1][1]="bangalore";
		objet[1][2]=50;


		objet[2][0]="mysore";
		objet[2][1]="bangalore";
		objet[2][2]=250;
		
		return objet;

	}
}
