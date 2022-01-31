package Main;

import java.sql.SQLException;

import java.util.Scanner;

import Views.CustomerView;
import Views.Login;
import Views.SellerView;

public class MainView {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to E-commerce CLI application");
		System.out.println("To login as a seller type 1 or to login as a customer type 2");
		Login login = new Login();
		int option = sc.nextInt();

		if (option == 1) {
			if (login.sellerLogin()) {
				SellerView sellerView = new SellerView();
				sellerView.view();
			} else {
				System.out.println("Invalid credentials");
				main(null);

			}
		} else if (option == 2) {
			if (login.customerLogin()) {
				CustomerView customerview = new CustomerView();
				customerview.view();
			} else {
				System.out.println("Invalid credentials");
				main(null);
			}
		}

	}

}
