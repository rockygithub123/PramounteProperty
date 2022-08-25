package org.paramountProperty.practice;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	public static void main(String[] args) {
		//
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/index.php?module=Accounts&action=index");
		
		List<WebElement> lis = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		for (WebElement we : lis) {
			System.out.println(we.getText());
			
		}
		// open the application and enter the url
		
	}

}

