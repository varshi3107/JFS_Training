package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practice4 
{

	public static void main(String[] args)
	{
		String query="SELECT * FROM users;";
		String url="jdbc:mysql://localhost:3306/projectdb";
		try{
			Connection con=DriverManager.getConnection(url, "root", "root");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("UserId")+ " " + rs.getString("username")+ " "+rs.getString("gmail")+" "+rs.getString("pass"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
