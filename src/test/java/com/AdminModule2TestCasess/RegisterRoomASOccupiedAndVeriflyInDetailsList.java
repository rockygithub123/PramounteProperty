package com.AdminModule2TestCasess;


import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.RoomRegistrationClass;
import com.realestate.paramountProperty.gennericUtility.BaseClass;

public class RegisterRoomASOccupiedAndVeriflyInDetailsList extends BaseClass {
@Test(groups = "Regression")
	public  void details() throws Throwable {
	




			// step2 : to read test data from excel sheet 
			String sheet="Sheet1";
			int r=7;

			//step 2.2 :get first name
			String FirstName = eLib.getExcelData(sheet, r, 5);
			System.out.println(FirstName);
			//step 2.3 :get Mobile number
			int num = new Random().nextInt(9);
			String num2="9825869";
			String num1 = String.valueOf(num);
			String number = eLib.getExcelData(sheet, r, 3);
			System.out.println(number);
			String MobileNumber = num2+jLib.getRandomNumber();
			//step 2.3 :to read email from excel sheet
			String Emaill = eLib.getExcelData(sheet, r, 5);
			String Email = MobileNumber+Emaill;
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
			String Image="C:\\Users\\User\\Desktop\\abc.txt";



		
					

			//step 6:Navigate to register page
			AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
			addDB.getRegisterButton().click();
			



			// step 7:Enter all the details
			RoomRegistrationClass r_reg=new RoomRegistrationClass(driver);
			r_reg.RegisterWithCredentialsAsOccupied(FirstName, MobileNumber, Email, PlotNumber, Rooms, Country, State, City, Rent, Deposit, Address, Image);
			
		


			// step 7.1: to upload image
			driver.findElement(By.id("image")).sendKeys("C:\\Users\\User\\Desktop\\abc.txt");Thread.sleep(3000);
			// step 7.3 : to click on submit button
			Thread.sleep(5000);
		
			driver.findElement(By.name("register_individuals")).click();Thread.sleep(5000);
			
			// step navigate details page
			addDB.getDetailsButton().click();
			
			//step 8:validate with actual result
			//step 8.1: get actual result
			String actual=driver.findElement(By.xpath("//p[contains(.,'"+Email+"')]/../../descendant::div[@class='alert alert-danger']/p")).getText();
            String expected="Occupied";
			//Step 8.2 validate with expected result
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(actual, expected);
            sa.assertAll();
	



		}
	




	}


