package com.ParamountProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterUseraccountTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//	WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();

		// step 1:read the common data
		FileInputStream fis=new FileInputStream(".\\Data\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");

		// step 2:read test data from excel sheet
		FileInputStream excel = new FileInputStream(".\\Data\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(excel);
		Row row = book.getSheet("Sheet2").getRow(1);

		//List<String> list = new ArrayList<>();
		for (int i = 0; i < row.getLastCellNum(); i++) {

		//	list.add(row.getCell(i).getStringCellValue());
		}
		

		// step 3:Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		// step 4:Login to application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		driver.get("https://192.168.0.190/domain/House_Rental_Application/"); Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[.='Submit']")).click();


		// step 5: navigate register 
		driver.findElement(By.xpath("//a[.='Register']")).click();

		/*// step 6: register the owner account
		driver.findElement(By.id("fullname")).sendKeys(list.get(0));
		driver.findElement(By.id("mobile")).sendKeys(list.get(1));
		driver.findElement(By.id("alternat_mobile")).sendKeys(list.get(2));
		driver.findElement(By.id("email")).sendKeys(list.get(3));
		driver.findElement(By.id("plot_number")).sendKeys(list.get(4));
		driver.findElement(By.id("rooms")).sendKeys(list.get(5));
		driver.findElement(By.id("country")).sendKeys(list.get(6));
		driver.findElement(By.id("state")).sendKeys(list.get(7));
		driver.findElement(By.id("city")).sendKeys(list.get(8));
		driver.findElement(By.id("rent")).sendKeys(list.get(9));
		driver.findElement(By.id("deposit")).sendKeys(list.get(10));
		driver.findElement(By.id("accommodation")).sendKeys(list.get(11));
		driver.findElement(By.id("landmark")).sendKeys(list.get(12));
		driver.findElement(By.id("address")).sendKeys(list.get(13));Thread.sleep(3000);
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\User\\Desktop\\abc.txt");
		driver.findElement(By.name("register_individuals")).click();


		// step 8: save the account
		// step 9: close the browser/tab*/
		driver.quit();


	}

}
