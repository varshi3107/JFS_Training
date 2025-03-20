package practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class practice6 
{
	public static void main(String[] args) 
	{
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established Successfully");
			
			DatabaseMetaData metainfo=con.getMetaData();
			System.out.println(metainfo.getDriverName());
			System.out.println(metainfo.getDriverVersion());
			System.out.println(metainfo.getUserName());
			System.out.println(metainfo.getDatabaseProductName());
			System.out.println(metainfo.getDatabaseProductVersion());
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
