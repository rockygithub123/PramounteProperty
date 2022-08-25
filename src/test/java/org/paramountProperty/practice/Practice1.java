package org.paramountProperty.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/index.php?module=Accounts&action=index");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	
		
		List<WebElement> lis = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		for (WebElement we : lis) {
			String abc = we.getText();
			if(abc.equals("xyz")) {
			
				driver.findElement(By.xpath("//a[text()='xyz']/../../td[1]")).click();
				driver.findElement(By.xpath("//a[text()='xyz']/../../td[8]/a[text()='del']")).click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				
	break;
			}

	}
		driver.close();

}
}
