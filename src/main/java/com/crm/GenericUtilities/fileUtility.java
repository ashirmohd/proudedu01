package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class fileUtility {
/**
 * @author ashir
 * @category generic for properties file
 * @param url
 * @param usn
 * @param pwd
 * @return
 * @throws Throwable
 */
	
	public String getDataFromProperties(String key) throws Throwable
{
		FileInputStream fis=new FileInputStream(IPathConstant.FILEPATH);
		Properties p=new Properties();
		p.load(fis);
		String KEY=p.getProperty(key);
		return KEY;
		
		}
}
