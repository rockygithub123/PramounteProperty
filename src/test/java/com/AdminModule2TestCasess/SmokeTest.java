package com.AdminModule2TestCasess;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.AppartmentRegistrationClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.DetailsAndUpdate;
import com.realEstate_ParamountProperty.objectRepositoryUtility.RoomRegistrationClass;
import com.realestate.paramountProperty.gennericUtility.BaseClass;

public class SmokeTest extends BaseClass {

	@Test(groups = "Regression")
	public  void RegisterAppartmentAndVerifyInDetailsPage() throws Throwable {








		// step2 : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=3;

		//step 2.2 :to read apartment name name
		String AppartmentName = eLib.getExcelData(sheet, r, 2);

		//step 2.3 :to read  Mobile number
		int num = new Random().nextInt(9);
		String num1 = String.valueOf(num);
		String number = eLib.getExcelData(sheet, r, 3);
		System.out.println(number);
		String MobileNumber = "8985862"+jLib.getRandomNumber();
		//step 2.3 :to read email from excel sheet
		String Emaill = eLib.getExcelData(sheet, r, 5);
		String Email = "a"+num1+num1+Emaill;
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
		System.out.println(Email);


		//step 6:Navigate to Apartment register page
		AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
		addDB.getRegisterButton().click();

		AppartmentRegistrationClass app=new AppartmentRegistrationClass(driver);
		app.getAppartmentRegistrationButton();
		app.AppartmentRegisterwithCredentials(AppartmentName, MobileNumber, Email, PlotNumber, Country, State, City, Address, Image);

		//addDB.getDetailsButton().click();
		//wLib.waitForElement(driver,  driver.findElement(By.xpath("//p[contains(.,'"+MobileNumber+"')]")));
		WebElement actual = driver.findElement(By.xpath("//h2[text()='Register Room']/preceding-sibling::div[contains(.,'Registration successfull. Thank you')]"));
		wLib.waitForElement(driver,actual);
		System.out.println(actual.getText());
		if(actual.getText().contains("Registration successfull. Thank you"))
		{
			System.out.println("TestCase pass");
		}
		else
		{
			System.out.println("TestCase fail ");
		}




	}








	@Test(groups = "Regression")
	public  void RegisterComplaintOnAnyOwnerAndVeriflyInComplaintList() throws Throwable {



		// step2 : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=1;

		//step 2.2 :get first name
		String Name1=jLib.getRandomNumber()+""+eLib.getExcelData(sheet, r, 2);

		//step 2.3 :to read Complaint text from excel sheet
		String Text=eLib.getExcelData(sheet, r, 3);




		// step :Navigate to Details/update page
		AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
		addDB.getDetailsButton().click();

		// step : register complaint
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




	@Test(groups = "Smoke")
	public void RegisterIndividualRoomAndVerifyInListPage() throws Throwable {


		// step : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=1;
		

		String FirstName = eLib.getExcelData(sheet, r, 5);
		System.out.println(FirstName);
		//step 2.3 :get Mobile number
		int num = new Random().nextInt(9);
		String num1 = String.valueOf(num);
		String number = eLib.getExcelData(sheet, r, 3);
		System.out.println(number);
		String MobileNumber = "8985862"+jLib.getRandomNumber();
		//step 2.3 :to read email from excel sheet
		String Emaill = eLib.getExcelData(sheet, r, 5);
		String Email = "a"+num1+num1+num1+Emaill;
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



		// step :Enter all the details
		RoomRegistrationClass r_reg=new RoomRegistrationClass(driver);
		r_reg.RegisterWithCredentials(FirstName, MobileNumber, Email, PlotNumber, Rooms, Country, State, City, Rent, Deposit, Address, Image);




		//Navigate details page
		addDB.getDetailsButton().click();


		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//p[text()='"+Email+"']")).getText();
		System.out.println(actual);

		//Step- validate with expected result
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




	@Test(groups = "Smoke")
	public  void RegisterRoomASOccupiedAndVeriflyInDetailsList() throws Throwable {





		// step2 : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=7;

		//step 2.2 :get first name
		String FirstName = eLib.getExcelData(sheet, r, 5);
		System.out.println(FirstName);
		//step 2.3 :get Mobile number
		int num = new Random().nextInt(9);
		String num2="986398655";
		String num1 = String.valueOf(num);
		String number = eLib.getExcelData(sheet, r, 3);
		System.out.println(number);
		String MobileNumber = "8985862"+jLib.getRandomNumber();
		//step 2.3 :to read email from excel sheet
		String Emaill = eLib.getExcelData(sheet, r, 5);
		String Email = "h"+num1+num1+num1+Emaill;
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

		driver.findElement(By.name("register_individuals")).click();
		Thread.sleep(5000);

		// step navigate details page
		addDB.getDetailsButton().click();

		//step 8:validate with actual result
		//step 8.1: get actual result
		String actual=driver.findElement(By.xpath("//p[contains(.,'"+Email+"')]/../../descendant::div[@class='alert alert-danger']/p")).getText();

		//Step 8.2 validate with expected result

		if(actual.contains("Occupied"))
		{
			System.out.println("Test is pass==>>>>>"+"Occupied"+"(expected result)=="+actual+"(actual result)");
		}
}

}



