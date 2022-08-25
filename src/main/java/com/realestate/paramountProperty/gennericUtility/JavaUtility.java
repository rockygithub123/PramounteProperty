package com.realestate.paramountProperty.gennericUtility;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	public static int getRandomNumber()
	{
		Random ranDom=new Random();
		int num=100;
		 int ranDomNumber = num +ranDom.nextInt(899);
		return ranDomNumber;
		}
	public  String getSystemDate()
	{
		Date date= new Date();
		String currentdaate = date.toString();
		String yyyy = currentdaate.split("-")[5];
		String dd = currentdaate.split("-")[2];
		int mm = date.getMonth()+1;
		String formate=yyyy+"-"+mm+"-"+dd;
		return formate;
		
	}
	
	public String getSystemDateIST()
	{

		Date date= new Date();
		String currentdaate = date.toString();
		String yyyy = currentdaate.split(" ")[5];
		String dd = currentdaate.split(" ")[2];
		int mm = date.getMonth()+1;
		String formate=dd+"-"+mm+"-"+yyyy;
		System.out.println(formate);
	
		return formate;
		
		
		
	}
	

}
