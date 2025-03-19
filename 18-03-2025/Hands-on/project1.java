package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class project1 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the Mail:");//get mail from user
		String mail=s.next();
		
		String query="SELECT * FROM users WHERE gmail = '" +mail+ "';";//gets mail from user
		String url="jdbc:mysql://localhost:3306/testdb";//connectivity with data
		try
		{
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("?Connection Established Successfuly!!");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())//check for the email id if its there go ahead else check the next one if there is no next fields then print else.
			{
				String password=rs.getString("pass");
				System.out.println("Enter the password:");
				String curr_pass=s.next();
				if(curr_pass.equals(password))
				{
					System.out.println("Welcome back how are u?? User "+rs.getInt("UserId"));
				}
				else
				{
					System.out.println("Incorrect PAssword");
				}
			}
			else
			{
				System.out.println("There is no next field");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
