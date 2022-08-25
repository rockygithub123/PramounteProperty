package com.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realEstate_ParamountProperty.objectRepositoryUtility.HomeClass;
import com.realEstate_ParamountProperty.objectRepositoryUtility.LoginClass;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebdriverUtility wLib=new WebdriverUtility();
		FileUtility fLib=new FileUtility();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		
		String URL = fLib.getPropertyKeyValue("url");
		driver.get(URL);
		System.out.println(URL);
		wLib.waitForElementInDOM(driver);
		HomeClass h_home=new HomeClass(driver);
		h_home.getLoginButtonHome().click();
		LoginClass lgn=new LoginClass(driver);
		lgn.default_Login();

	}

}
