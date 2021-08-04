package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Step 1: load the driver
		//Class.forName("jdbc:mysql://localhost:3306/demo_database");
		
		//Step2: Create connection object
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_database", "root", "Geonova1!");
		
		//Step 3: Create Statement Object
		Statement statement = conn.createStatement();
		
		//Step 4: Execute Query
		//Need a different statement to manipulate database
		//statement.executeQuery("insert into employee (name, email, gender) values ('Maddie', 'maddie@gmail.com', '2')");
		//statement.executeUpdate("insert into employee (name, email, gender) values ('Maddie', 'maddie@gmail.com', '2')");
		ResultSet resultSet = statement.executeQuery("select * from employee;");
		//ResultSet resultSet = statement.executeQuery("select emp_name, SUM(working_hours) from time_sheet group by emp_name;");
//		while(resultSet.next()) {
//			System.out.println("name=" + resultSet.getString(1) + " hours_worked=" + resultSet.getString(2));
//		}
		while(resultSet.next())	{
			System.out.println("id=" + resultSet.getInt(1) + " name=" + resultSet.getString(2) 
			+ " email=" + resultSet.getString(3));
		}
		//Step 5: CLose the connection
		
		conn.close();

	}

}
