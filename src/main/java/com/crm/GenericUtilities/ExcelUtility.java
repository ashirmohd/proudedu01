package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * @author ashir
	 * @category generic
	 * @param sheetname
	 * @param rowname
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String readExceldata(String sheetname,int rowname,int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rowname).getCell(cellnum).getStringCellValue();
		return data;
		
	}

	/**
	 * @author ashir
	 * @category generic
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int readLastrownumb(String sheetname) throws Throwable {
	    FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetname);
	    int data = sh.getLastRowNum();
	    return data;
	}
	/**
	 * @author ashir
	 * @category generic
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param setvalue
	 * @throws Throwable
	 */
	public void writeExcelData(String sheetname,int rownum,int cellnum,String setvalue) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		   wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(setvalue);
		   FileOutputStream fos=new FileOutputStream(IPathConstant.EXCELPATH);
		   wb.write(fos);
		
	}
	/**
	 * @author ashir
	 * @category generic
	 * @param sheetname
	 * @param keycell
	 * @param valuecell
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getlist(String sheetname,int keycell,int valuecell) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		HashMap<String,String> hm=new HashMap<String,String>();
	    for(int i=0;i<=count;i++) {
	    	String key = sh.getRow(i).getCell(keycell).getStringCellValue();
	    	String value = sh.getRow(i).getCell(valuecell).getStringCellValue();
	    	hm.put(key, value);
	    }
		return hm;
	}
	/**
	 * @author ashir
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	
	public ArrayList<String> getlistUsingArraylist(String sheetname,int cellnum) throws Throwable {
		WebDriver driver=null;
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		int count=sh.getLastRowNum();
		ArrayList<String> ar=new ArrayList<String>();
		for(int i=0;i<=count;i++) {
			String value=sh.getRow(i).getCell(cellnum).getStringCellValue();
		ar.add(value);
		}
		return ar;
	}
	public Object[][] readmultipledata(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
	   int row = sh.getLastRowNum()+1;
	   
	   int cell = sh.getRow(0).getLastCellNum();
	   
	   Object[][] obj = new Object[row][cell];
	   for(int i=0;i<row;i++) {
		   for(int j=0;j<cell;j++) {
			  obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
		   }
	   }
	   return obj;
	}

}
