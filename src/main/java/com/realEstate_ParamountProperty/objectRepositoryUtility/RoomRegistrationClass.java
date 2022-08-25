package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

public class RoomRegistrationClass {
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterButton;
	
	@FindBy(id="fullname")
	private WebElement FullName;
	
	@FindBy(id="mobile")
	private WebElement MoibileNumber;
	
	@FindBy(id="alternat_mobile")
	private WebElement AlternateMoibileNumber;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="plot_number")
	private WebElement PlotNumber;
	
	@FindBy(id="rooms")
	private WebElement AvailableRooms;
	
	@FindBy(id="country")
	private WebElement country;
	
	@FindBy(id="state")
	private WebElement State;
	
	@FindBy(id="city")
	private WebElement City;
	
	@FindBy(id="rent")
	private WebElement Rent;
	
	@FindBy(id="sale")
	private WebElement Sale;
	
	
	
	@FindBy(id="deposit")
	private WebElement Deposit;
	
	@FindBy(id="accommodation")
	private WebElement Facilities;
	
	@FindBy(id="description")
	private WebElement Description;
	
	@FindBy(id="mobile")
	private WebElement LandMark;
	
	@FindBy(id="address")
	private WebElement Address;
	
	@FindBy(id="mobile")
	private WebElement Occupied;
	
	@FindBy(id="image")
	private WebElement Image;
	
	@FindBy(name="register_individuals")
	private WebElement Login;
	
	@FindBy(xpath="//select")
	private WebElement DropDown;
	
	
	public  RoomRegistrationClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getRegisterButton() {
		return RegisterButton;
	}


	public WebElement getFullName() {
		return FullName;
	}


	public WebElement getMoibileNumber() {
		return MoibileNumber;
	}


	public WebElement getEmail() {
		return Email;
	}


	public WebElement getPlotNumber() {
		return PlotNumber;
	}


	public WebElement getAvailableRooms() {
		return AvailableRooms;
	}


	public WebElement getCountry() {
		return country;
	}


	public WebElement getState() {
		return State;
	}


	public WebElement getCity() {
		return City;
	}


	public WebElement getRent() {
		return Rent;
	}


	public WebElement getSale() {
		return Sale;
	}


	public WebElement getDeposit() {
		return Deposit;
	}


	public WebElement getFacilities() {
		return Facilities;
	}


	public WebElement getDescription() {
		return Description;
	}


	public WebElement getLandMark() {
		return LandMark;
	}


	public WebElement getAddress() {
		return Address;
	}


	public WebElement getOccupied() {
		return Occupied;
	}


	public WebElement getImage() {
		return Image;
	}


	public WebElement getLogin() {
		return Login;
	}
	
public void RegisterWithCredentials(String F_name,String M_number,String E_mail,String Plot_number,String Available_rooms,String country_,String state_,String city_,String rent_,String deposit_,String address_,String image_)
{
	FullName.sendKeys(F_name);
	MoibileNumber.sendKeys(M_number);
	Email.sendKeys(E_mail);
	PlotNumber.sendKeys(Plot_number);
	AvailableRooms.sendKeys(Available_rooms);
	country.sendKeys(country_);
    State.sendKeys(state_);
    City.sendKeys(city_);
    Rent.sendKeys(rent_);
	Deposit.sendKeys(deposit_);
	Address.sendKeys(address_);
	Image.sendKeys(image_);
	Login.click();
	
	
	
	}
public void RegisterWithCredentialsAsOccupied(String F_name,String M_number,String E_mail,String Plot_number,String Available_rooms,String country_,String state_,String city_,String rent_,String deposit_,String address_,String image_)
{
	FullName.sendKeys(F_name);
	MoibileNumber.sendKeys(M_number);
	Email.sendKeys(E_mail);
	PlotNumber.sendKeys(Plot_number);
	AvailableRooms.sendKeys(Available_rooms);
	country.sendKeys(country_);
    State.sendKeys(state_);
    City.sendKeys(city_);
    Rent.sendKeys(rent_);
	Deposit.sendKeys(deposit_);
	Address.sendKeys(address_);
	WebdriverUtility wLib=new WebdriverUtility();
	wLib.select(DropDown, 1);
	Image.sendKeys(image_);
	Login.click();
	
	
	
	}
public void defaultRoomRegistration()
{
	FullName.sendKeys("Jhoney");
	MoibileNumber.sendKeys("7795608985");
	Email.sendKeys("jhon123@gmail.com");
	PlotNumber.sendKeys("112");
	AvailableRooms.sendKeys("1BHK");
	country.sendKeys("India");
    State.sendKeys("Karnataka");
    City.sendKeys("Bengaluru");
    Rent.sendKeys("rent");
	Deposit.sendKeys("50000");
	Address.sendKeys("#12,12th main west of cord road bangalore");
	Image.sendKeys("C:\\Users\\User\\Desktop\\abc.txt");
	Login.click();
	}
	
	
	


}
