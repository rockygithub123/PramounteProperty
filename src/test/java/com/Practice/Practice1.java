package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realestate.paramountProperty.gennericUtility.ExcelUtility;
import com.realestate.paramountProperty.gennericUtility.FileUtility;
import com.realestate.paramountProperty.gennericUtility.JavaUtility;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		try {
			JavaUtility jLib = new JavaUtility();
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			WebdriverUtility wLib = new WebdriverUtility();
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			// to launch the application
			driver.get("https://www.makemytrip.com");
			
			wLib.waitForElementInDOM(driver);
			driver.manage().window().maximize();
			//driver.findElement(By.xpath("(//div[@class='landingContainer'])[1]")).click();
			// to click train major tab
			driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chTrains']")).click();
			// click on search
			driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn']")).click();
			// to enter the city name
			driver.findElement(By.xpath("//span[text()='From City']")).click();
			driver.findElement(By.xpath("react-autosuggest__input")).sendKeys("bangalore");
			driver.findElement(By.xpath("//span[text()='Bengaluru - All Stations']")).click();


			//to enter to city
			driver.findElement(By.xpath("//span[text()='To City']")).click();
			driver.findElement(By.xpath("//input[@class='react-autosuggest__input']")).sendKeys("chennai");

			driver.findElement(By.xpath("//span[text()='Chennai - All Stations']")).click();

			// to select the date drop down
			driver.findElement(By.xpath("//div[@class='rsw_inputBox dayPickerRailWrap dates  ']  ")).click();
			//to select today date
			String date="11";
			driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[text()='"+date+"']")).click();
			//click on search
			driver.findElement(By.xpath("//span[@class='font14 latoBlack capText']")).click();
		}

		finally {
			Thread.sleep(3000);

			driver.quit();
		}

	}}
