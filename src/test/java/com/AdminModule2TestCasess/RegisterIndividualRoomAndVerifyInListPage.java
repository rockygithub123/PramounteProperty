package com.AdminModule2TestCasess;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.RoomRegistrationClass;
import com.realestate.paramountProperty.gennericUtility.BaseClass;
@Listeners(com.realestate.paramountProperty.gennericUtility.Listener.class)
public class RegisterIndividualRoomAndVerifyInListPage extends BaseClass {
    @Test(groups = "Smoke")
	 public void register() throws Throwable {
		




			// step : to read test data from excel sheet 
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
			String MobileNumber = "9874562"+jLib.getRandomNumber();
			//step 2.3 :to read email from excel sheet
			String Emaill = eLib.getExcelData(sheet, r, 5);
			String Email = MobileNumber+Emaill;
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





			//step :Navigate to register page
			AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
			addDB.getRegisterButton().click();
			
Assert.fail();

			// step :Enter all the details
			RoomRegistrationClass r_reg=new RoomRegistrationClass(driver);
			r_reg.RegisterWithCredentials(FirstName, MobileNumber, Email, PlotNumber, Rooms, Country, State, City, Rent, Deposit, Address, Image);
			
			
			

			//Navigate details page
			addDB.getDetailsButton().click();
			
		
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//p[text()='"+Email+"']")).getText();
			
			
		String expected=	"Email: "+MobileNumber+"rakesh@gmail.com";
			System.out.println(actual);

			//Step- validate with expected result
			
			System.out.println(expected);
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(actual, expected);
			sa.assertAll();
		



		}
	

	}


