package com.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderr {
	@Test(dataProvider = "dataProviderrr")
	public void register(String src, String dst,String testt)
	{
		
		System.out.println(src+"===>>>>"+dst+"===>>"+testt);
		
		
		
		
		
		
		
		
		
		
	}
	@DataProvider
	public Object[][] dataProviderrr()
	{
		Object[][] obj = new Object[5][2];
		obj[0][0]="first name";
		obj[0][1]="test";
		obj[1][0]="last name";
		obj[1][1]="yantra";
		obj[2][0]="mobile";
		obj[2][1]="7795608985";
		obj[3][0]="alte mobile";
		obj[3][1]="8895628985";
		obj[4][0]="country";
		obj[4][1]="India";
		//return obj ;
		Object[][] obj1 = new Object[5][3];
		obj[0][0]="first name";
		obj[0][1]="test";
		
		obj1[1][0]="last name";
		obj1[1][1]="yantra";
		obj1[2][0]="mobile";
		obj1[2][1]="7795608985";
		obj1[3][0]="alte mobile";
		obj1[3][1]="8895628985";
		obj1[4][0]="country";
		obj1[4][1]="India";
		obj1[0][2]="test";
		obj1[1][2]="test";
		obj1[2][2]="test";
		obj1[3][2]="test";
		obj1[4][2]="test";
		return obj1 ;
		
	}

}
