package com.realEstate_ParamountProperty.objectRepositoryUtility;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintRegisterClass {
	public ComplaintRegisterClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
    private WebElement NameTextField;
	
	@FindBy(id="cmp")
    private WebElement ComplaintTextField;
	
	@FindBy(xpath="//button[text()='Submit']")
    private WebElement SubmitButton;
	
	public WebElement getNameTextField() {
		return NameTextField;
	}
	public WebElement getComplaintTextField() {
		return ComplaintTextField;
	}
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	public void compliantWithUserInput (String name,String text )
	{
		NameTextField.sendKeys(name);
		ComplaintTextField.sendKeys(text);
		SubmitButton.click();
	}
	public void compliantWithDefaultValues()
	{
		Random ran=new Random();
		
		NameTextField.sendKeys(ran.nextInt(200)+"abc");
		ComplaintTextField.sendKeys("not good");
		SubmitButton.click();
	}
	
	
	

}
