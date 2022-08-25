package org.paramountProperty.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFrompropertyFile {

	public static void main(String[] args) throws IOException {
		// step 1:use File input stream to load the property file
		FileInputStream fis = new FileInputStream(".\\Data\\CommonData.properties");

		//step2 : create object of properties and load file
		Properties prop=new Properties();
		prop.load(fis);

		//step3 :provide key to read the value

		// to read url from property file

		String URL = prop.getProperty("url");
		System.out.println(URL);
		// to read username from property file
		String UN = prop.getProperty("username");
		System.out.println(UN);
		// to read password from property file
		String PWD = prop.getProperty("password");
		System.out.println(PWD);


	}

}
