package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class practice3 {

	public static void main(String[] args) 
	{
		String query = "UPDATE users SET username = ?,gmail = ?,pass = ? WHERE username = ?;";
		String url="jdbc:mysql://localhost:3306/projectdb";
		
		try{
			Connection con=DriverManager.getConnection(url, "root", "root");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, "renu");
			ps.setString(2, "renu@gmail.com");
			ps.setString(3, "renu@123");
			ps.setString(4, "neha_jain");
			
			int rows=ps.executeUpdate();
			System.out.println(rows+"row(s) is affected");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
