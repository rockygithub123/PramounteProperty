package com.AdminModule1TestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.ComplaintRegisterClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.DetailsAndUpdate;
import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.complaintList;
import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterComplaintOnAnyOwnerAndVeriflyInComplaintList {

	public static void compliant() throws Throwable {
		WebDriver driver=null;
		try {JavaUtility jLib = new JavaUtility();
		ExcelUtility Elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		WebdriverUtility wlib = new WebdriverUtility();

		// step 1 :To read all common data from  property file
		// step1.1 :to read url from property file
		String URL = flib.getPropertyKeyValue("url");
		// step1.2 :to read url from property file
		String UserName = flib.getPropertyKeyValue("username");
		// step1.3:to read url from property file
		String PassWord = flib.getPropertyKeyValue("password");
		// step 1.4: to read browser from property file
		String Browser =flib.getPropertyKeyValue("browser");


		// step2 : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=1;

		//step 2.2 :get first name
		String Name1=jLib.getRandomNumber()+""+Elib.getExcelData(sheet, r, 2);

		//step 2.3 :to read Complaint text from excel sheet
		String Text=Elib.getExcelData(sheet, r, 3);


		// step 3:launch the browser
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("no data=>>>>>>not possible to launch");
		}



		// step 4:Navigate to application
		driver.get(URL);

		wlib.waitForElementInDOM(driver);//implicitly wait



		// step 5:Login to application
		HomeClass h_home=new HomeClass(driver);
		h_home.getLoginButtonHome().click();//to click login button in home page
		LoginClass lgn=new LoginClass(driver);
		lgn.default_Login();

		// step 6:Navigate to Details/update page
		AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
		addDB.getDetailsButton().click();

		// step 7: register complaint
		DetailsAndUpdate dtt=new DetailsAndUpdate(driver);
		dtt.registerCoimplaint(driver, Name1, Text);


		//navigate compliant list
		addDB.getComplaintButton().click();
		System.out.println(Name1);
		driver.navigate().refresh();

		Thread.sleep(3000);

		//String actual = cmpList.complaintName(driver, Name1);
		String actual = driver.findElement(By.xpath("//tr[contains(.,'"+Name1+"')]")).getText();

		if(actual.contains(Name1)) {
			System.out.println("Test case pass=>>>>>>"+actual+"=="+Name1);
		}
		else 
		{
			System.out.println("test is fail");

		}


		}
		finally {
			driver.quit();
		}






	}

}
