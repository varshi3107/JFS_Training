package Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class event {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("WELCOME TO THE EVENT HOW CAN I HELP U");
		System.out.println("1.Request New User" + "\n" + "2.Edit Exsisting user" + "\n" + "3.Delete User");
		int ans = s.nextInt();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
			Statement st = con.createStatement();
			if (ans == 1) 
			{
				System.out.println("Give ur collegename:");
				String cname = s.next();
				System.out.println("Give ur eventname:");
				String ename = s.next();
				System.out.println("Give ur emailid:");
				String mail = s.next();
				System.out.println("Give ur password:");
				String pass = s.next();

				String query = "INSERT INTO users (collegename, eventname, pass, gmail) VALUES ('" + cname + "','"
						+ ename + "','" + pass + "','" + mail + "');";
				int change = st.executeUpdate(query);
				if (change > 0) {
					System.out.println("You are successfully registered");
				}
			} else if (ans == 2) {
				System.out.println("Give ur register number:");
				int regno = s.nextInt();

				String query1 = "SELECT * FROM users WHERE regno = '" + regno + "';";
				ResultSet rs = st.executeQuery(query1);
				if (rs.next()) {
					System.out.println("Enter your password:");
					String pass1 = s.next();
					if (pass1.equals(rs.getString("pass"))) {
						System.out.println("Hlo User!! Do you wanna change something from below");
						System.out.println("1.Email" + "\n" + "2.collegename" + "\n" + "3.eventname" + "\n"
								+ "4.Password" + "\n" + "5.You dont Wanna change");
						int ans1 = s.nextInt();
						if (ans1 == 1) {
							System.out.println("Enter your new emailid:");
							String mail1 = s.next();
							String query2 = "UPDATE users SET gmail = '" + mail1 + "' WHERE regno = '" + regno + "';";
							int change1 = st.executeUpdate(query2);
							if (change1 > 0) {
								System.out.println("You have successfully updated");
							}
						} else if (ans1 == 2) {
							System.out.println("Enter your collegename:");
							String college1 = s.next();
							String query3 = "UPDATE users SET collegename = '" + college1 + "' WHERE regno = '" + regno
									+ "';";
							int change2 = st.executeUpdate(query3);
							if (change2 > 0) {
								System.out.println("You have successfully updated");
							}
						} else if (ans1 == 3) {
							System.out.println("Enter your new eventname:");
							String event1 = s.next();
							String query3 = "UPDATE users SET eventname = '" + event1 + "' WHERE regno = '" + regno
									+ "';";
							int change3 = st.executeUpdate(query3);
							if (change3 > 0) {
								System.out.println("You have successfully updated");
							}
						} else if (ans1 == 4) {
							System.out.println("Enter your new password:");
							String passw1 = s.next();
							String query4 = "UPDATE users SET pass = '" + passw1 + "' WHERE regno = '" + regno + "';";
							int change4 = st.executeUpdate(query4);
							if (change4 > 0) {
								System.out.println("You have successfully updated");
							}
						} else {
							String query5 = "SELECT * FROM users;";
							ResultSet rs2 = st.executeQuery(query1);
							while (rs2.next()) {
								System.out.println(rs2.getString("gmail") + "\n" + rs2.getString("collegename") + "\n"
										+ rs2.getString("eventname") + "\n" + rs2.getString("pass"));
							}
						}
					} else {
						System.out.println("You have entered a worng password please enter a correct password");
					}
				} else {
					System.out.println("You are not a exsisting user please create a new account");
				}
			} else {
				System.out.println("Enter your regno:");
				int regno1 = s.nextInt();

				String query6 = "SELECT * FROM users WHERE regno = '" + regno1 + "';";
				ResultSet rs3 = st.executeQuery(query6);
				if (rs3.next()) {
					System.out.println("Enter your password:");
					String pass3 = s.next();
					if (pass3.equals(rs3.getString("pass"))) {
						String query7 = "DELETE FROM users WHERE regno = '" + regno1 + "';";
						int change3 = st.executeUpdate(query7);
						if (change3 > 0) {
							System.out.println("The user is successfully deleted!!!");
						}
					} else {
						System.out.println("You have entered a worng password please enter a correct password");
					}
				} else {
					System.out.println("You are not a exsisting user please create a new account");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
