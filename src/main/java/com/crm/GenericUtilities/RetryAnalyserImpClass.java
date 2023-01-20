package com.crm.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class RetryAnalyserImpClass implements IRetryAnalyzer {
	int count=0;
	int value=3;
	public boolean retry(ITestResult result) {
		
		
		
			if(count<value) {
				count++;
			return true;
			}
		
		return false;
	}

	
}
