package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class complaintList {
	public complaintList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
  public String complaintName(WebDriver driver,String name)
  {
	String value = driver.findElement(By.xpath("//tr[contains(.,'+name+')])[1]")).getText();
	return value;	
  }
}
