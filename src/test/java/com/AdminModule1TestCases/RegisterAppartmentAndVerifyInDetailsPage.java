package com.AdminModule1TestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.AppartmentRegistrationClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;
import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterAppartmentAndVerifyInDetailsPage {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
			JavaUtility Jlib = new JavaUtility();
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
			int r=3;

			//step 2.2 :to read apartment name name
			String AppartmentName = Elib.getExcelData(sheet, r, 2);

			//step 2.3 :to read  Mobile number
			int num = new Random().nextInt(9);
			String num1 = String.valueOf(num);
			String number = Elib.getExcelData(sheet, r, 3);
			System.out.println(number);
			String MobileNumber = "898589895"+num1;
			//step 2.3 :to read email from excel sheet
			String Emaill = Elib.getExcelData(sheet, r, 5);
			String Email = num1+Emaill;
			//step 2.3 :to read plotNumber from excel sheet
			String PlotNumber = Elib.getExcelData(sheet, r, 6);
			//step 2.3 :to read country from excel sheet
			String Country = Elib.getExcelData(sheet, r, 7);
			//step 2.3 :to read state from excel sheet
			String State =Elib.getExcelData(sheet, r, 8);
			//step 2.3 :to read city from excel sheet
			String City = Elib.getExcelData(sheet, r, 9);
			//step 2.3 :to read address from excel sheet
			String Address =Elib.getExcelData(sheet, r, 10);
			String Image="C:\\Users\\User\\Desktop\\abc.txt";





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
			HomeClass h_home=new HomeClass(driver);
			h_home.getLoginButtonHome().click();
			LoginClass lgn=new LoginClass(driver);
			lgn.default_Login();
			
			

			//step 6:Navigate to Apartment register page
			AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
			addDB.getRegisterButton().click();
	
			AppartmentRegistrationClass app=new AppartmentRegistrationClass(driver);
			app.getAppartmentRegistrationButton();
			app.AppartmentRegisterwithCredentials(AppartmentName, MobileNumber, Email, PlotNumber, Country, State, City, Address, Image);

             addDB.getDetailsButton().click();
              WebElement actual = driver.findElement(By.xpath("//p[contains(.,'"+Email+"')]"));
              wlib.waitForElement(driver,actual);
              System.out.println(actual.getText());
			 try { if(actual.getText().contains(Email))
			  {
				  System.out.println("TestCase pass");
			  }
			  else
			  {
				  System.out.println("TestCase fail ");
			  }
			 }
			  
			  finally
			  {
				  Thread.sleep(3000);
				  driver.quit();
			  }
			
		




		}}


