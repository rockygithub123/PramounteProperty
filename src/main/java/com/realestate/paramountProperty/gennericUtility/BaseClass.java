package com.realestate.paramountProperty.gennericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.realEstate_ParamountProperty.objectRepositoryUtility.AdminDashBoardClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sDriver;
	public  WebDriver driver;
	
	public WebdriverUtility wLib=new WebdriverUtility();
	public FileUtility fLib=new FileUtility();
	public  ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	
	// connect to database
	public void configureBS()
	{
		System.out.println("connect to database");
	}
	
	
	// to launch the browser
	@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Regression"})
	public void configBC(String Browser) throws Throwable
	{
		System.out.println("======launch the browser========");
		//String Browser = fLib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			
		}
		else
		{
			System.out.println("no browser to be launch");
		}
		sDriver=driver;
		
	}
	
	

	// to login to application
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void configureBM() throws Throwable
	{
		System.out.println();
		 String UserName = fLib.getPropertyKeyValue("username");
		 String PassWord = fLib.getPropertyKeyValue("password");
		 String URL = fLib.getPropertyKeyValue("url");
		 driver.get(URL);
		 LoginClass lgn=new LoginClass(driver);
		 HomeClass hm = new HomeClass(driver);
		 hm.getLoginButtonHome().click();
		 lgn.Login(UserName, PassWord);
		 
		
	}
	// to logout from application
	@AfterMethod(groups = {"Smoke","Regression"})
	public void configureAM()
	{
		System.out.println("======Logout from application========");
		AdminDashBoardClass addDB=new AdminDashBoardClass(driver);
		addDB.getLogOutButton().click();
		
	}
	//to close the application
	@AfterClass(groups = {"Smoke","Regression"})
	public void configureAc()
	{
		System.out.println("=======close the browser=======");
		driver.quit();
	}
	//to close the database connection
	@AfterSuite(groups = {"Smoke","Regression"})
	public void configureAS()
	{
		System.out.println("dataBase connection closed");
	}

}
