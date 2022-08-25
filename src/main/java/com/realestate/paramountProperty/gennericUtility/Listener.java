package com.realestate.paramountProperty.gennericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
		EventFiringWebDriver ef=new EventFiringWebDriver(BaseClass.sDriver);
		File src = ef.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShot1/"+testname+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
