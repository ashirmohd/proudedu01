
package Practice_Pakage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class writeDataFromPropertyTest {

	private static Object dada;

	public static void main(String[] args) throws Throwable {
String path = "./src/test/resources/Commondata.properties";
		
		File file = new File(path);
		file.createNewFile();
		
		Properties pr = new Properties();
		pr.setProperty("FirstName", "mohammed");
		pr.setProperty("LastName", "ashir");
		
		FileOutputStream fis = new FileOutputStream(file);
		pr.store(fis, "Test Data");
		
		fis.close();
		
	}

}
