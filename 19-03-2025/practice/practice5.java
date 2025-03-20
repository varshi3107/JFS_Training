package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class practice5 
{
	public static void main(String[] args) 
	{
		String query="SELECT * FROM users";
		String url="jdbc:mysql://localhost:3306/projectdb";
		try{
			Connection con=DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established Successfully!!");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			ResultSetMetaData meta=rs.getMetaData();
			
			System.out.println(meta.getColumnCount());
			System.out.println(meta.getColumnName(1));
			System.out.println(meta.getColumnTypeName(1));
			System.out.println(meta.getTableName(1));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
