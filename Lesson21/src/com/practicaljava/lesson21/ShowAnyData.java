package com.practicaljava.lesson21;

import java.sql.*;

public class ShowAnyData {

	public static void main(String[] args) {
		//process args array
		/*if (args.length == 0) {
			System.out.println(
					"Usage: java ShowAnyData SQLSelectStatement");
			System.out.println(
					"For example: java ShowAnyData \"Select * from Employee\"");
			System.exit(1);
		}*/
		
		String sqlQuery = "SELECT * from employee";
		
		
		//get connection? declare ststement and resultset
		try (Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/Lesson21");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery(sqlQuery);) {
			
			//find out the number of columns, their name and display the data
			ResultSetMetaData rsMeta = rs.getMetaData();
			int colCount = rsMeta.getColumnCount();
			
			for (int i=1; i <= colCount; i++) {
				System.out.println(rsMeta.getColumnName(i) + " ");
			}
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1; i<= colCount; i++) {
					System.out.println(rs.getString(i) + " ");
				}
				System.out.println("\n");
			}

		} catch( SQLException se ) {
			   System.out.println ("SQLError: " + se.getMessage ()
		        + " code: " + se.getErrorCode ());

		} catch( Exception e ) {
		   System.out.println(e.getMessage()); 
		} 
	}

}
