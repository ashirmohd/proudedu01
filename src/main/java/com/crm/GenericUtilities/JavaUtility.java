package com.crm.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int javautil(int i) {
	
	Random run=new Random();
	int rundom = run.nextInt(i);
	return rundom;
	
	}
	public String setDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	public String getSystemDateAndTimeInFormat() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemdate=new Date();
		        String systemdateformat= dateformat.format(systemdate);
		        System.out.println(systemdateformat);
		        return systemdateformat.replaceAll(":", "-");
	}
	}

