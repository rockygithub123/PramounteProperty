package org.paramountProperty.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromdatabaseExecuetUpdate {

	public static void main(String[] args) throws SQLException {

		// create the object for db driver class(mysql.cj,driver)

		Driver dbDriver = new Driver();

		// Register the driver( driver manager is singleton class)

		DriverManager.registerDriver(dbDriver);

		// Establish the connection-provide datbase name

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38", "root", "root");

			// create a statement-statement is interface
			Statement statement = connection.createStatement();

			// Execute the query -it will return int

			String query="create table EmpDetails1(empId int(4) not null unique, empName varchar(30), phone_number int(10) not null unique, address varchar(50));";
			//query to create one more table/table2
			String query2="create table stddetails(stdName varchar(30) not null,stdID int(10),phone int(11) not null unique,city varchar(30));";

			//Execute query to insert values in to emptable
			String query1="insert into empdetails values(6,'Rakesh6',779564895,'bangalore'),(5,'Rakesh5',779563895,'pune')";

			//Execute query to insert values into stddetails table
			String query4="insert into stddetails values('rocky',100,779560898,'bangalore');";

			//to delete record from table
			String query5 = "delete from empdetails where empId=1";

			//to drop the table
			String query6="drop table stddetails";
			// 

			int result = statement.executeUpdate(query);

			System.out.println("data created successfully");
			//validate


			if(result==1) {
				System.out.println("data addedd succesfully");
			}
			else {
				System.out.println("not added");
			}
		}


		// close the connection
		finally {
			connection.close();
		}

	}
}


