package com.realestate.paramountProperty.gennericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;
import org.testng.internal.annotations.ITest;

public class LisImpClass implements ITestListener {


	public void onTestFailure(ITestResult result)
	{
		JavaUtility jLib=new JavaUtility();
		String date = jLib.getSystemDate();
		
		System.out.println(date);
		String testname = result.getMethod().getMethodName();
		System.out.println(testname);
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
	
		
		
		
		try {
			
			FileUtils.copyFile(src, new File("./ScreenShot/"+testname+date+".png"));
			
		
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
	}

	
	
	

}
