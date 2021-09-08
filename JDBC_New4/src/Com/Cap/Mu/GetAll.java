package Com.Cap.Mu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAll {
public static void main(String[] args) {
	

	try {
	//Step 1: Load the driver class
	Class.forName("com.mysql.jdbc.Driver");
//Step 2: Establish Connection
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest", "root", "root");
	
//Step 3:GetAll data Sql query
	String sql = "Select * from student where RollNo=2"; 
	
//Step4: Create statement Object
	Statement stm = con.createStatement();

//Step 5:Execute sql query
	ResultSet rs=stm.executeQuery(sql);
	while(rs.next())
	{
		int RollNo=rs.getInt(1);
		String Name=rs.getString(2);
		String Address=rs.getString(3);
		
		System.out.println("Roll No is: "+RollNo);
		System.out.println("Name is: "+Name);
		System.out.println("Address is: "+Address);
	}
	
//Step 6: Close Connection
	con.close();
	}

catch (Exception e) {
	e.printStackTrace();
	}
	
}

}


