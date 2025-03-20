package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class practice1 
{
	public static void main(String[] args) 
	{
		String query = "INSERT INTO users (username, gmail, pass) VALUES (?, ?, ?);";
		String url="jdbc:mysql://localhost:3306/projectdb";
		try
		{
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("The connection is established.");
			
			PreparedStatement ps=con.prepareStatement(query);//comparitively more faster then the normal statement
			ps.setString(1,"varshita1");
			ps.setString(2,"Varshita1@gmail.com");
			ps.setString(3,"123varshi");
			
			int rows=ps.executeUpdate();
			System.out.println(rows+"Row(s) is affected");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
