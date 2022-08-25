package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	//@FindBy(xpath="//a[text()='Login']")
	//private WebElement LoginButton;


	@FindBy(id="exampleInputEmail1")
	private WebElement UserName;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement PassWord;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement LoginButton;


	public LoginClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserName() {
		return UserName;
	}


	public WebElement getPassWord() {
		return PassWord;
	}


	public WebElement getLoginButton() {
		return LoginButton;
	}

public void Login(String U_Name,String Pass_Word)

{
	UserName.sendKeys(U_Name);
	PassWord.sendKeys(Pass_Word);
	LoginButton.click();
	
	}
public void default_Login()

{
	UserName.sendKeys("admin");
	PassWord.sendKeys("admin");
	LoginButton.click();
	
	}




}
