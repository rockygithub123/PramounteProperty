package com.Practice;

import org.testng.annotations.Test;

public class Practice3 {

  @Test(priority = 2)
	public void enter()
	{
		System.out.println("enter your name");
		
	}
  @Test(invocationCount = 2)
	public void login()
	{
		System.out.println("enter your login details");
	}
  @Test(priority = 1)
	public void delete()
	{
		System.out.println("delete your records from list");
	}

}
