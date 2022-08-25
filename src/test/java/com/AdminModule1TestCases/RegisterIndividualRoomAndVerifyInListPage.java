package com.AdminModule1TestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.RoomRegistrationClass;
import com.realestate.paramountProperty.gennericUtility.BaseClass;

public class RegisterIndividualRoomAndVerifyInListPage extends BaseClass {
    @Test
	 public void mainn() throws Throwable {
		
		/*
			//JavaUtility jLib = new JavaUtility();
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			//WebdriverUtility wLib = new WebdriverUtility();*/
			
			// step 1 :To read all common data from  property file

			// step1.1 :to read url from property file

			/*String URL = fLib.getPropertyKeyValue("url");
			// step1.2 :to read url from property file
			String UserName =fLib.getPropertyKeyValue("username");
			// step1.3:to read url from property file
			String PassWord = fLib.getPropertyKeyValue("password");
			// step 1.4: to read browser from property file
			String Browser = fLib.getPropertyKeyValue("browser");*/




			// step2 : to read test data from excel sheet 
			String sheet="Sheet1";
			int r=1;
			;

			String FirstName = eLib.getExcelData(sheet, r, 5);
			System.out.println(FirstName);
			//step 2.3 :get Mobile number
			int num = new Random().nextInt(9);
			String num1 = String.valueOf(num);
			String number = eLib.getExcelData(sheet, r, 3);
			System.out.println(number);
			String MobileNumber = num1+number;
			//step 2.3 :to read email from excel sheet
			String Emaill = eLib.getExcelData(sheet, r, 5);
			String Email = num1+num1+Emaill;
			//step 2.3 :to read plotNumber from excel sheet
			String PlotNumber = eLib.getExcelData(sheet, r, 5);
			//step 2.3 :to read plotNumber from excel sheet
			String Rooms = eLib.getExcelData(sheet, r, 7);
			//step 2.3 :to read country from excel sheet
			String Country = eLib.getExcelData(sheet, r, 8);
			//step 2.3 :to read state from excel sheet
			String State = eLib.getExcelData(sheet, r, 9);
			//step 2.3 :to read state from excel sheet
			String City = eLib.getExcelData(sheet, r, 10);
			//step 2.3 :to read Rent from excel sheet
			String Rent = eLib.getExcelData(sheet, r, 11);
			//step 2.3 :to read Rent from excel sheet
			String Deposit = eLib.getExcelData(sheet, r, 13);
			//step 2.3 :to read Rent from excel sheet
			String Address = eLib.getExcelData(sheet, r, 17);
			String Image="C:\\Users\\User\\Desktop\\abc.txt";



			// step 3:launch the browser
			/*if(Browser.equalsIgnoreCase("chrome"))
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
			}*/



			/*// step 4:Navigate to application
			driver.get(URL);
			wLib.waitForElementInDOM(driver);


			// step 5:Login to application
			HomeClass h_home=new HomeClass(driver);
			h_home.getLoginButtonHome().click();
			LoginClass lgn=new LoginClass(driver);
			lgn.default_Login();
			*/
			


			//step 6:Navigate to register page
			AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
			addDB.getRegisterButton().click();
			


			// step 7:Enter all the details
			RoomRegistrationClass r_reg=new RoomRegistrationClass(driver);
			r_reg.RegisterWithCredentials(FirstName, MobileNumber, Email, PlotNumber, Rooms, Country, State, City, Rent, Deposit, Address, Image);
			
			
			

			//Navigate details page
			addDB.getDetailsButton().click();
			
		
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//p[text()='"+MobileNumber+"']")).getText();
			System.out.println(actual);

			//Step 8.2 validate with expected result
			String expected ="Mobile Number: "+MobileNumber;
			System.out.println(expected);
			if(actual.contains(MobileNumber))
			{
				System.out.println("Test is pass==>>>>>"+expected+"(expected result)=="+actual+"(actual result)");
			}
			else 
			{
				System.out.println("test is fail");
			}




		}
	

	}


