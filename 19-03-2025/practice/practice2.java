package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class practice2 
{

	public static void main(String[] args) 
	{
		String query="DELETE fROM users WHERE UserId=?;";
		String url="jdbc:mysql://localhost:3306/projectdb";
		try{
			Connection con=DriverManager.getConnection(url, "root", "root");
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,100);
			
			int rows=ps.executeUpdate();
			System.out.println(rows+"row(s) is affected");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
