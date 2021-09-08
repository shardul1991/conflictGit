package Com.Cap.Mu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Database_To_Excel {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest", "root", "root");
		Statement stm = con.createStatement();
		ResultSet rs=stm.executeQuery("Select * from employeedetails");
		
		//Excel:
		XSSFWorkbook xsw = new XSSFWorkbook();
		XSSFSheet sheet=xsw.createSheet("Locations Data");
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("RollNo");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Address");
		row.createCell(3).setCellValue("Office");
		
		int r=1;
		while(rs.next())
		{
			int rollno=rs.getInt("RollNo");
			String name=rs.getString("Name");
			String addr=rs.getString("Address");
			String offc=rs.getString("Office");
			
			row=sheet.createRow(r++);
			row.createCell(0).setCellValue(rollno);
			row.createCell(1).setCellValue(name);
			row.createCell(2).setCellValue(addr);
			row.createCell(3).setCellValue(offc);
		}
		
		FileOutputStream fos = new FileOutputStream("F:\\Testing\\Automation Testing\\Software\\Mysql\\Test.xlsx");
		xsw.write(fos);
		xsw.close();
		fos.close();
		con.close();
		
		//Code written by Shardul
		System.out.println("Done");
		
		
	}

}
