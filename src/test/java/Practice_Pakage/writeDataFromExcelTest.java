package Practice_Pakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writeDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis=new FileInputStream("./src/test/resources/Testdata45.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		    //wb.getSheet("Sheet1").createRow(2).createCell(2).setCellValue("ashir");
          FileOutputStream fos=new FileOutputStream("./src/test/resources/Testdata45.xlsx");
          //wb.write(fos);
         // wb.close();
          wb.createSheet("employee").createRow(1).createCell(0).setCellValue("Ashir");
          wb.write(fos);
	}

}
