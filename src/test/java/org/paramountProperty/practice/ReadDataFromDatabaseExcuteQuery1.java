package org.paramountProperty.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseExcuteQuery1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//crete a object for driver class
		
		Driver dri=new Driver();
		//register the driver 

		DriverManager.registerDriver(dri);
		// establish the connection 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38", "root", "root");
		//create a statement
		Statement sta = con.createStatement();
		//execute query
		String q = "update ok set name='who' where id=111";
		 int r = sta.executeUpdate(q);
		 if(r==1) {System.out.println("ok");}
		
	}

}
