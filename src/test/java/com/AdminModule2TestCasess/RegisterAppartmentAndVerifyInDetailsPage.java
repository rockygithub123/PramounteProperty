package com.AdminModule2TestCasess;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.AppartmentRegistrationClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;
import com.realestate.paramountProperty.gennericUtility.BaseClass;
import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.realestate.paramountProperty.gennericUtility.LisImpClass.class)
public class RegisterAppartmentAndVerifyInDetailsPage extends BaseClass{
@Test//(groups = "Smoke",retryAnalyzer = com.realestate.paramountProperty.gennericUtility.RetryImpClass.class)
	public  void appartment() throws Throwable {
	

			//step : to read test data from excel sheet 
			String sheet="Sheet1";
			int r=3;

			//step 2.2 :to read apartment name name
			String AppartmentName = eLib.getExcelData(sheet, r, 2);

			//step 2.3 :to read  Mobile number
			int num = new Random().nextInt(9);
			String num1 = String.valueOf(num);
			String number = eLib.getExcelData(sheet, r, 3);
			System.out.println(number);
			String MobileNumber = "8958965"+jLib.getRandomNumber();
			System.out.println(MobileNumber);
			//step 2.3 :to read email from excel sheet
			String Emaill = eLib.getExcelData(sheet, r, 5);
			String Email = num1+Emaill;
			//step 2.3 :to read plotNumber from excel sheet
			String PlotNumber = eLib.getExcelData(sheet, r, 6);
			//step 2.3 :to read country from excel sheet
			String Country = eLib.getExcelData(sheet, r, 7);
			//step 2.3 :to read state from excel sheet
			String State =eLib.getExcelData(sheet, r, 8);
			//step 2.3 :to read city from excel sheet
			String City = eLib.getExcelData(sheet, r, 9);
			//step 2.3 :to read address from excel sheet
			String Address =eLib.getExcelData(sheet, r, 10);
			String Image="C:\\Users\\User\\Desktop\\abc.txt";
			



			//step 6:Navigate to Apartment register page
			AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
			addDB.getRegisterButton().click();
			System.out.println("k");
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(2, 3);
			sa.assertAll();
			//Assert.fail();
	
			AppartmentRegistrationClass app=new AppartmentRegistrationClass(driver);
			app.getAppartmentRegistrationButton();
			app.AppartmentRegisterwithCredentials(AppartmentName, MobileNumber, Email, PlotNumber, Country, State, City, Address, Image);

             //addDB.getDetailsButton().click();
			Thread.sleep(3000);
			String expected="Registration successfull. Thank you";
               String actual = driver.findElement(By.xpath("//h2[text()='Register Room']/preceding-sibling::div[contains(.,'Registration successfull. Thank you')]")).getText();
              wLib.waitForElement(driver,driver.findElement(By.xpath("//h2[text()='Register Room']/preceding-sibling::div[contains(.,'Registration successfull. Thank you')]")));
              System.out.println(actual);
              
              sa.assertEquals(actual,expected);
			sa.assertAll();
			
			 
			 }

			 }


