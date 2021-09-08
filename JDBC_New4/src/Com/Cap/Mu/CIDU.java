package Com.Cap.Mu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CIDU {

public static void main(String[] args) {
	
	try {
//Step 1: Load the driver class
		Class.forName("com.mysql.jdbc.Driver");
//Step 2: Establish Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest", "root", "root");
		//localhost as mqsql database is present in local machine, 3306 is port number, datatest is  database name
//Step 3:Create Sql query
		//String sql = "create table EmployeeDetails(RollNo int, Name varchar(20), Address varchar(50), Office varchar(30))"; 

		//Various Operations Add, Delete, Update
		
		// Add Values in Table
		String sql1 = "insert into EmployeeDetails(RollNo,Name,Address,Office) values(5, 'Apurv', 'Hadap', 'DE')";
		//String sql1 = "insert into student(RollNo, Name,Address) values(2, 'pooja', 'kothrud')";
		
		//Delete data
		//String  sql1 = "delete from student where RollNo=1"; 
		
		//Update Data
		//String sql1 ="update student set Name='Shlok' where RollNo=1";
		
		
//Step4: Create statement Object
		Statement stm = con.createStatement();
//Step 5:Exexute sql query
		stm.execute(sql1);
		
//		int a=stm.executeUpdate(sql);// Print count 
//		System.out.println(a);

//Step 6: Close Connection
		con.close();
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
}
