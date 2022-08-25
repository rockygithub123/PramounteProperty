package org.paramountProperty.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseExcuteQuery {

	public static void main(String[] args) throws SQLException {
		// step 1: create object of Driver
		Driver driverref = new Driver();
		Connection con=null;

		//step2 : register the driver


		DriverManager.registerDriver(driverref);


		// step3 :establish connection-provide datbase name
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38","root", "root");


		//step4 : create statement
		Statement statement = con.createStatement();
		//step5 :Execute the query-provide table name

		String query="select * from empdetails where address='pune'";
		String expData = "Rakesh1";
		ResultSet result = statement.executeQuery(query);
		/System.out.println(result.getString(0));






		boolean flag=false;
		while(result.next())
		{
			String actData = result.getString(2);

			if(actData.equalsIgnoreCase(expData)) {
				System.out.println(actData);
				flag=true;  // flag rising
				break;

			}}
		// step 6:Validation

		if(flag)
		{
			System.out.println("data present");

		}
		else
		{
			System.out.println("data is not present");
		}


		//step 7: close connection

		con.close();

	}



}


