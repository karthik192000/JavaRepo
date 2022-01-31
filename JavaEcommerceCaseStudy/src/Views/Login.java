package Views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JdbcConnection.ConnectionManager;
import Users.Customer;
import Users.Seller;

public class Login {

	private final Connection con = ConnectionManager.getConnection();
	Scanner sc = new Scanner(System.in);

	public boolean sellerLogin() throws SQLException {
		Statement st = con.createStatement();
		String query = "select username,password from seller_profile";
		ResultSet rs = st.executeQuery(query);
		Seller seller = new Seller();
		System.out.println("Enter username: ");
		seller.setUserName(new Scanner(System.in).next());
		System.out.println("Enter password");
		seller.setPassWord(new Scanner(System.in).next());

		while (rs.next()) {
			if (seller.getUserName().equals(rs.getString(1)) && seller.getPassWord().equals(rs.getString(2))) {
				System.out.println("Login succesful");
				System.out.println("Welcome: " + seller.getUserName());
				return true;
			}
		}
		return false;
	}

	public boolean customerLogin() throws SQLException {
		Statement st = con.createStatement();
		String query = "select username,password from customer_profile";
		ResultSet rs = st.executeQuery(query);
		Customer customer = new Customer();
		System.out.println("Enter username: ");
		customer.setUserName(new Scanner(System.in).next());
		System.out.println("Enter password");
		customer.setPassWord(new Scanner(System.in).next());

		while (rs.next()) {
			if (customer.getUserName().equals(rs.getString(1)) && customer.getPassWord().equals(rs.getString(2))) {
				System.out.println("Login successful");
				System.out.println("Welcome: " + customer.getUserName());
				return true;
			}

		}
		return false;

	}

}
