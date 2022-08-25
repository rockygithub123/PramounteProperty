package com.AdminModuleTestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterAppartmentAndVerifyInDetailsPage {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		try {
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
			String MobileNumber = number+num1;
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

			wlib.waitForElementInDOM(driver);


			// step 5:Login to application
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(UserName);
			driver.findElement(By.id("exampleInputPassword1")).sendKeys(PassWord);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();


			//step 6:Navigate to Apartment register page
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			driver.findElement(By.xpath("//a[text()='Apartment Registration']")).click();



			// step 7:Enter all the details
			// step 7.1: to enter the FirstName
			driver.findElement(By.id("apartment_name")).sendKeys(AppartmentName);
			// step 7.2: to enter the MobileNumber
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='mobile']")).sendKeys(MobileNumber);
			// step 7.3: to enter the MobileNumber
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='email']")).sendKeys(Email);
			// step 7.4: to enter the PlotNumber
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='plot_number']")).sendKeys(PlotNumber);

			// step 7.1: to enter the Country
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='country']")).sendKeys(Country);

			// step 7.1: to enter the State
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='state']")).sendKeys(State);

			// step 7.1: to enter the City
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='city']")).sendKeys(City);

			// step 7.1: to enter the rent	
			// step 7.1: to enter the Address
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='address']")).sendKeys(Address);

			// step 7.1: to upload image
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='image']")).sendKeys("C:\\Users\\User\\Desktop\\abc.txt");Thread.sleep(3000);
			// step 7.3 : to click on submit button
			driver.findElement(By.name("register_apartment")).click();
			//driver.findElement(By.name("register_individuals")).click();
			//step 8 navigate to details page
			driver.findElement(By.xpath("//a[text()='Details/Update']")).click();
			// step 8.1 : fetch mobile number from list
			String actual = driver.findElement(By.xpath("//p[text()='"+MobileNumber+"']")).getText();





			//Step 8.2 validate with expected result
			String expected ="Mobile Number: "+MobileNumber;
			System.out.println(expected);
			if(actual.contains(expected))
			{
				System.out.println("Test is pass==>>>>>"+expected+"(expected result)=="+actual+"(actual result)");
			}
			else 
			{
				System.out.println("test is fail");
			}





		}
		//Logout from application
		finally 
		{

			driver.quit();
		}



	}

}
