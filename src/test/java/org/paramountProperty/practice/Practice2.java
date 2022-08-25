package org.paramountProperty.practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.realestate.paramountProperty.gennericUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		=ne

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://www.clinique.in/");
driver.findElement(By.xpath("//*[name()='svg' and @class='header-gnav-cart__icon svgicon svgicon--bag hide_auth']")).click();;
	}

}
