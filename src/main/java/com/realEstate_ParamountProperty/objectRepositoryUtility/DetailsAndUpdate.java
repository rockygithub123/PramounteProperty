package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsAndUpdate {
	public DetailsAndUpdate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Complaint'])[1]")
	private WebElement complaintBtn;
	
	
	public void selectEdit(WebDriver driver,String mobileNumber)
	{
		driver.findElement(By.xpath("//p[contains(.,'"+mobileNumber+"')]/ancestor::div[@class='card card-inverse card-info mb-3']/descendant::a[text()='Edit']")).click();
	}
	
	public void registerCoimplaint(WebDriver driver,String name,String text)
	{
		complaintBtn.click();
		ComplaintRegisterClass cmp=new ComplaintRegisterClass(driver);
		cmp.compliantWithUserInput(name, text);
	}

}
