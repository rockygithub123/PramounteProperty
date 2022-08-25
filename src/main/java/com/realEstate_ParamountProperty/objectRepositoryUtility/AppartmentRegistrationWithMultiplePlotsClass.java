package com.realEstate_ParamountProperty.objectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;

public class AppartmentRegistrationWithMultiplePlotsClass {
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='fullname']")
	private WebElement fullName2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='ap_number_of_plats']")
	private WebElement flotNumber2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='rooms']")
	private WebElement rooms2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='area']")
	private WebElement area2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::select[@id='purpose']")
	private WebElement purposeDD2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::select[@id='floor']")
	private WebElement floorDD2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::select[@id='ownership']")
	private WebElement ownerDD2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::select[@id='vacant']")
	private WebElement vacantDD2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='rent']")
	private WebElement rent2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='deposit']")
	private WebElement deposit2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='accommodation']")
	private WebElement facility2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::input[@id='description']")
	private WebElement description2ndPlot;
	
	@FindBy(name="//div[@id='rowCount2']/descendant::a[@class='btn btn-danger btn-sm']")
	private WebElement delete2ndPlot;

	public WebElement getFullName2ndPlot() {
		return fullName2ndPlot;
		
		
	}

	public WebElement getFlotNumber2ndPlot() {
		return flotNumber2ndPlot;
	}

	public WebElement getRooms2ndPlot() {
		return rooms2ndPlot;
	}

	public WebElement getArea2ndPlot() {
		return area2ndPlot;
	}

	public WebElement getPurposeDD2ndPlot() {
		return purposeDD2ndPlot;
	}

	public WebElement getFloorDD2ndPlot() {
		return floorDD2ndPlot;
	}

	public WebElement getOwnerDD2ndPlot() {
		return ownerDD2ndPlot;
	}

	public WebElement getVacantDD2ndPlot() {
		return vacantDD2ndPlot;
	}

	public WebElement getRent2ndPlot() {
		return rent2ndPlot;
	}

	public WebElement getDeposit2ndPlot() {
		return deposit2ndPlot;
	}

	public WebElement getFacility2ndPlot() {
		return facility2ndPlot;
	}

	public WebElement getDescription2ndPlot() {
		return description2ndPlot;
	}

	public WebElement getDelete2ndPlot() {
		return delete2ndPlot;
	}
	
	public void registerWithMultiplePlots(String full_name,String flotNumber, String rooms_,String area_,String purposeVisibleText,String floor_VisibleText,String owner_VisibleText,String rent_,String deposit_,String facility_,String description_,String vacantVisibleText)
	{
		fullName2ndPlot.sendKeys(full_name);
		flotNumber2ndPlot.sendKeys(flotNumber);
		rooms2ndPlot.sendKeys(rooms_);
		area2ndPlot.sendKeys(area_);
		WebdriverUtility wLib=new WebdriverUtility();
		wLib.select(purposeDD2ndPlot, purposeVisibleText);
		
		
	
	}

	
	
	

}
