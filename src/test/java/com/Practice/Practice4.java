package com.Practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.realestate.paramountProperty.gennericUtility.BaseClass;
@Listeners(com.realestate.paramountProperty.gennericUtility.LisImpClass.class)

public class Practice4  {
	@Test(retryAnalyzer = com.realestate.paramountProperty.gennericUtility.RetryImpClass.class)
	public void ok() throws IOException
	{
		System.out.println("k");
		
	Assert.fail();
	}
	

}
