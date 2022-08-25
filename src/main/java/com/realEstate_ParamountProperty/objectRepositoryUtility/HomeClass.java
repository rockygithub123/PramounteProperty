package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeClass {
	public HomeClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	public WebElement getLoginButtonHome() {
		return LoginButtonHome;
	}
	public WebElement getRegisterButtonHome() {
		return RegisterButtonHome;
	}
	public WebElement getSearchRooms() {
		return SearchRooms;
	}
	public WebElement getSearchByLOC() {
		return SearchByLOC;
	}
	public WebElement getSearchButtonRoom() {
		return SearchButtonRoom;
	}
	@FindBy(xpath="//a[@class='nav-link js-scroll-trigger']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginButtonHome;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement RegisterButtonHome;
	
	@FindBy(xpath="//input[@id='keywords']")
	private WebElement SearchRooms;
	
	@FindBy(xpath="//input[@id='location']")
	private WebElement SearchByLOC;
	@FindBy(xpath="//button[@name='search']")
	private WebElement SearchButtonRoom;

}
