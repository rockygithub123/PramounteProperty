package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppartmentRegistrationClass {



public AppartmentRegistrationClass(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//a[text()='Apartment Registration']")
private WebElement appartmentRegistrationButton;
	

	@FindBy(id="apartment_name")
	private WebElement AppartmentName;



	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='mobile']")
	private WebElement MobileNumber;


	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='email']")
	private WebElement Email;




	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='plot_number']")
	private WebElement PlotNumber;


	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='country']")
	private WebElement Country;



	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='state']")
	private WebElement State;


	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='city']")
	private WebElement City;


	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='address']")
	private WebElement Address;


	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@id='image']")
	private WebElement Image;
	
	@FindBy(name="//a[@class='btn btn-info btn-sm']")
	private WebElement addMoreBtn;

	@FindBy(name="register_apartment")
	private WebElement LoginButton;
	
	
	
	
	public WebElement getAppartmentRegistrationButton() {
		return appartmentRegistrationButton;
	}

	public WebElement getAppartmentName() {
		return AppartmentName;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPlotNumber() {
		return PlotNumber;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getImage() {
		return Image;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	
	public WebElement getAddMoreBtn() {
		return addMoreBtn;
	}

	public void AppartmentRegisterwithCredentials(String Appartment_name,String Mobile_number,String E_mail,String Plot_number,String Country_,String State_,String City_,String Address_,String Image_)
	{
		appartmentRegistrationButton.click();
		AppartmentName.sendKeys(Appartment_name);
		MobileNumber.sendKeys(Mobile_number);
		Email.sendKeys(E_mail);
		PlotNumber.sendKeys(Plot_number);
		Country.sendKeys(Country_);
		State.sendKeys(State_);
		City.sendKeys(City_);
		Address.sendKeys(Address_);
		Image.sendKeys(Image_);
		LoginButton.click();
		
	}


	public void defaultAppartmentRegisterwithCredentials()
	{
		AppartmentName.sendKeys("Appartment1");
		MobileNumber.sendKeys("8458986858");
		Email.sendKeys("app123@gmail.com");
		PlotNumber.sendKeys("1212");
		Country.sendKeys("India");
		State.sendKeys("Karnataka");
		City.sendKeys("Bangalore");
		Address.sendKeys("#102,est of cord road bangalore");
		Image.sendKeys("C:\\Users\\User\\Desktop\\abc.txt");
		LoginButton.click();
		
	}
}
