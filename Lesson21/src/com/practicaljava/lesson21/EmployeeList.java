package com.practicaljava.lesson21;

//Class EmployeeList displays Employees from the table EMP 
//using JDBC drivers of type 4

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeList {

public static void main(String argv[]) {

String sqlQuery = "SELECT * from Employee"; 
List<EmployeeDTO> employees = new ArrayList();

// Open autocloseable Connection, Statement and get the result set
try (Connection conn = DriverManager.getConnection( "jdbc:derby://localhost:1527/Lesson21");
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(sqlQuery); ) {  
	//process reultset: create arraylist of DTO's and populate it with data from the db

	while (rs.next()) {
		EmployeeDTO currentEmp = new EmployeeDTO();
		currentEmp.setEmpNo(rs.getInt("EMPNO"));
		currentEmp.setEName(rs.getString("ENAME"));
		currentEmp.setJobTitle(rs.getString("JOB_TITLE"));
		
		employees.add(currentEmp);	
   }
} catch( SQLException se ) {
   System.out.println ("SQLError: " + se.getMessage ()
        + " code: " + se.getErrorCode ());

} catch( Exception e ) {
   System.out.println(e.getMessage()); 
} 

employees.forEach(System.out::println);
}
}