package com.AdminModule2TestCasess;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.ComplaintRegisterClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.DetailsAndUpdate;
import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.complaintList;
import com.realestate.paramountProperty.gennericUtility.BaseClass;
import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterComplaintOnAnyOwnerAndVeriflyInComplaintList extends BaseClass {
@Test(groups = "Regression")
	public  void complaint() throws Throwable {
		


		// step2 : to read test data from excel sheet 
		String sheet="Sheet1";
		int r=1;

		//step 2.2 :get first name
		String Name1=jLib.getRandomNumber()+""+eLib.getExcelData(sheet, r, 2);

		//step 2.3 :to read Complaint text from excel sheet
		String Text=eLib.getExcelData(sheet, r, 3);



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
		String expected=Name1+" 779560896 Mahantesh Kumbar";
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actual, expected);
		sa.assertAll();

	

}

}
