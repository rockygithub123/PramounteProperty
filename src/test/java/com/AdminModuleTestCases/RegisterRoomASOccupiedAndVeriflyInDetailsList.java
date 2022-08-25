package com.AdminModuleTestCases;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterRoomASOccupiedAndVeriflyInDetailsList {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		try {
			JavaUtility jLib = new JavaUtility();
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			WebdriverUtility wLib = new WebdriverUtility();
			// step 1 :To read all common data from  property file

			// step1.1 :to read url from property file

			String URL = fLib.getPropertyKeyValue("url");
			// step1.2 :to read url from property file
			String UserName =fLib.getPropertyKeyValue("username");
			// step1.3:to read url from property file
			String PassWord = fLib.getPropertyKeyValue("password");
			// step 1.4: to read browser from property file
			String Browser = fLib.getPropertyKeyValue("browser");



			// step2 : to read test data from excel sheet 
			String sheet="Sheet1";
			int r=7;

			//step 2.2 :get first name
			String FirstName = eLib.getExcelData(sheet, r, 5);
			System.out.println(FirstName);
			//step 2.3 :get Mobile number
			int num = new Random().nextInt(9);
			String num2="996398655";
			String num1 = String.valueOf(num);
			String number = eLib.getExcelData(sheet, r, 3);
			System.out.println(number);
			String MobileNumber = num2+num1;
			//step 2.3 :to read email from excel sheet
			String Emaill = eLib.getExcelData(sheet, r, 5);
			String Email = num1+num1+num1+Emaill;
			//step 2.3 :to read plotNumber from excel sheet
			String PlotNumber =eLib.getExcelData(sheet, r, 6);
			//step 2.3 :to read plotNumber from excel sheet
			String Rooms = eLib.getExcelData(sheet, r, 7);
			//step 2.3 :to read country from excel sheet
			String Country = eLib.getExcelData(sheet, r, 8);
			//step 2.3 :to read state from excel sheet
			String State = eLib.getExcelData(sheet, r, 9);
			//step 2.3 :to read state from excel sheet
			String City =eLib.getExcelData(sheet, r, 10);
			//step 2.3 :to read Rent from excel sheet
			String Rent = eLib.getExcelData(sheet, r, 11);
			//step 2.3 :to read Rent from excel sheet
			String Deposit = eLib.getExcelData(sheet, r, 13);
			//step 2.3 :to read Rent from excel sheet
			String Address = eLib.getExcelData(sheet, r, 17);



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
			wLib.waitForElementInDOM(driver);


			// step 5:Login to application
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(UserName);
			driver.findElement(By.id("exampleInputPassword1")).sendKeys(PassWord);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();


			//step 6:Navigate to register page
			driver.findElement(By.xpath("//a[text()='Register']")).click();



			// step 7:Enter all the details
			// step 7.1: to enter the FirstName
			driver.findElement(By.id("fullname")).sendKeys(FirstName);
			// step 7.2: to enter the MobileNumber
			driver.findElement(By.id("mobile")).sendKeys(MobileNumber);
			// step 7.3: to enter the MobileNumber
			driver.findElement(By.id("email")).sendKeys(Email);
			// step 7.4: to enter the PlotNumber
			driver.findElement(By.id("plot_number")).sendKeys(PlotNumber);
			// step 7.1: to enter the Available room type
			driver.findElement(By.id("rooms")).sendKeys(Rooms);
			// step 7.1: to enter the Country
			driver.findElement(By.id("country")).sendKeys(Country);
			// step 7.1: to enter the State
			driver.findElement(By.id("state")).sendKeys(State);
			// step 7.1: to enter the City
			driver.findElement(By.id("city")).sendKeys(City);
			// step 7.1: to enter the rent
			driver.findElement(By.id("rent")).sendKeys(Rent);
			// step 7.1: to enter the Deposit
			driver.findElement(By.id("deposit")).sendKeys(Deposit);	
			// step 7.1: to enter the Address
			driver.findElement(By.id("address")).sendKeys(Address);
			// step7.1 : to select the occupied from dropdown
			WebElement dropDown = driver.findElement(By.xpath("//select[@name='vacant']"));
			Select sel = new Select(dropDown);
			sel.selectByVisibleText("Occupied");
			String text = sel.getFirstSelectedOption().getText();


			// step 7.1: to upload image
			driver.findElement(By.id("image")).sendKeys("C:\\Users\\User\\Desktop\\abc.txt");Thread.sleep(3000);
			// step 7.3 : to click on submit button
			driver.findElement(By.name("register_individuals")).click();Thread.sleep(5000);
			// step navigate details page
			driver.findElement(By.xpath("//a[text()='Details/Update']")).click();Thread.sleep(3000);
			//step 8:validate with actual result
			//step 8.1: get actual result
			String actual=driver.findElement(By.xpath("//p[contains(.,'"+MobileNumber+"')]/../../descendant::div[@class='alert alert-danger']/p")).getText();

			//Step 8.2 validate with expected result
			String expected = text;
			if(actual.contains("Occupied"))
			{
				System.out.println("Test is pass==>>>>>"+expected+"(expected result)=="+actual+"(actual result)");
			}





		}
		//Logout from application

		finally {

			driver.quit();}




	}

}
