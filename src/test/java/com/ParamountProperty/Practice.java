package com.ParamountProperty;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.realestate.paramountProperty.gennericUtility.BaseClass;
import com.realestate.paramountProperty.gennericUtility.WebdriverUtility;
@Listeners(com.realestate.paramountProperty.gennericUtility.LisImpClass.class)
 class Practice1 extends BaseClass {
	@Test
	 public void abc()
	 {
		Assert.assertEquals(true, false);
		 
	 }
	
}
