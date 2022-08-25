package com.AdminModuleTestCases;

import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterComplaintOnAnyOwnerAndVeriflyInComplaintList {

	public static void main(String[] args) throws Throwable {
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
		String Name1=Elib.getExcelData(sheet, r, 2);

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
		wlib.waitForElementInDOM(driver);


		// step 5:Login to application
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UserName);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PassWord);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// step 6:Navigate to Details/update page
		driver.findElement(By.xpath("//a[text()='Details/Update']")).click();

		// step 7: Click on complaint button
		driver.findElement(By.xpath("(//a[text()='Complaint'])[1]")).click();

		// step 8:Register the complaint with details
		// step 8.1:Enter the name

		int no=jLib.getRandomNumber();

		String Name = Name1+String.valueOf(no);
		driver.findElement(By.id("name")).sendKeys(Name);
		// step 8.2:to enter the complaint text
		driver.findElement(By.id("cmp")).sendKeys(Text);
		// step 8.3: click on submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//step 9: navigate to complaint list page
		driver.findElement(By.xpath("//a[text()='Complaint List']")).click();
		Thread.sleep(5000);
		//step 10:To validate to registered complaint displayed
		// step 10.1 : to get registered name from complaint list
		String actualResult = driver.findElement(By.xpath("//td[text()='"+Name+ "']")).getText();

		//to validate with actual registered complaint	
		String expectedResult = Name;
		if(expectedResult.contains(actualResult)) {
			System.out.println("Test case pass=>>>>>>"+expectedResult+"=="+actualResult);
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
