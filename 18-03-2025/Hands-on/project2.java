package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class project2
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the Mail:");
		String mail=s.next();
		
		String query="SELECT * FROM users WHERE gmail = '" +mail+ "';";
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
				String new_mail=mail;
				System.out.println("Hello NewUser!! Enter ur password");
				String new_pass=s.next();
				
				String new_query="INSERT INTO users(gmail,pass) VALUES ('" + new_mail + "','" + new_pass + "')";
				int rs1=st.executeUpdate(new_query);
				if(rs1>0)
				{
					System.out.println("User registered successfully!");
				}
				else
				{
					System.out.println("User cant create the account!");
				}

			}
			con.close();
			rs.close();
			st.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
