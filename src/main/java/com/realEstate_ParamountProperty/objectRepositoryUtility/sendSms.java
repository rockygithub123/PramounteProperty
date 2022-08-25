package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class sendSms {

	public sendSms(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement TextField;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement SendSmsButton;
	//input[@id='selectAll']
	@FindBy(id="selectAll")
	private WebElement SelectAllButton;
	

}
