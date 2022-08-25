package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardClass {
	public AdminDashBoardClass(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeButton;

	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterButton;

	@FindBy(xpath="//a[text()='Details/Update']")
	private WebElement DetailsButton;

	@FindBy(xpath="//a[text()='Send SMS']")
	private WebElement SendSMSButton;

	@FindBy(xpath="//a[text()='Complaint List']")
	private WebElement ComplaintButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOutButton;

	public WebElement getLogOutButton() {
		return logOutButton;
	}

	public WebElement getHomeButton() {
		return HomeButton;
	}

	public WebElement getRegisterButton() {
		return RegisterButton;
	}

	public WebElement getDetailsButton() {
		return DetailsButton;
	}

	public WebElement getSendSMSButton() {
		return SendSMSButton;
	}

	public WebElement getComplaintButton() {
		return ComplaintButton;
	}
	
	

}
