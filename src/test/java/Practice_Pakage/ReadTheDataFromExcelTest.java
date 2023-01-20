package Practice_Pakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
  FileInputStream fis=new FileInputStream("./src/test/resources/Testdata45.xlsx");
  Workbook wb = WorkbookFactory.create(fis);
  String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
  System.out.println(data);
	}

}
