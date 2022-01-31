package Views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import JdbcConnection.ConnectionManager;
import Main.MainView;
import Product.Product;

public class CustomerView {

	private Connection con = ConnectionManager.getConnection();

	public void view() throws SQLException {

		System.out.println("1) Get list of all products" + "\n" + "2) Get details for one product" + "\n"
				+ "3) Buy a product" + "\n" + "4) Exit");

		int option = new Scanner(System.in).nextInt();
		if (option == 1) {
			this.getProducts();
			this.view();
		} else if (option == 2) {
			System.out.println("Enter the id of the product you want details for: ");
			this.getProduct(new Scanner(System.in).nextInt());
			this.view();
		} else if (option == 3) {
			System.out.println("Enter the id of the product you want to buy: ");
			this.addToCart(new Scanner(System.in).nextInt());
			this.view();
		} else if (option == 4) {
			new MainView().main(null);
		} else {
			System.out.println("Invalid entry ");
			this.view();
		}
	}

	private void getProducts() throws SQLException {
		Statement st = con.createStatement();
		String query = "select * from products";
		ArrayList<Product> products = new ArrayList<>();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}

		for (int i = 0; i < products.size(); i++) {
			System.out.println("++++++++++++++++++++++++");
			System.out.println("ProductId: " + products.get(i).getProductId() + "\n" + "Product Name: "
					+ products.get(i).getProductName() + "\n" + "Product Description: "
					+ products.get(i).getDescription() + "\n" + "Product Price: " + products.get(i).getPrice());
			System.out.println("++++++++++++++++++++++++");
		}

		System.out.println("Do you want to buy any product? if yes enter y else enter n to go to main menu");
		String option = new Scanner(System.in).next();
		if (option.equals("y")) {
			System.out.println("Enter the product id: ");
			int productId = new Scanner(System.in).nextInt();
			this.addToCart(productId);
		} else if (option.equals("n")) {
			this.view();

		}
	}

	private void getProduct(int productId) throws SQLException {
		Statement st = con.createStatement();
		String query = "select * from products where ProductId = " + productId;
		ResultSet rs = st.executeQuery(query);
		Product product = new Product();
		while (rs.next()) {
			product.setProductId(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setDescription(rs.getString(3));
			product.setPrice(rs.getDouble(4));
		}
		System.out.println("+++++++++++++++++++");
		System.out.println("ProductId: " + product.getProductId() + "\n" + "Product Name: " + product.getProductName()
				+ "\n" + "Product Description: " + product.getDescription() + "\n" + "Product price: "
				+ product.getPrice());
		System.out.println("+++++++++++++++++++");
		System.out.println("Do you want to buy this product? If yes enter y else enter n to go to main menu");
		String option = new Scanner(System.in).next();
		if (option.equals("y")) {
			this.addToCart(productId);
		} else if (option.equals("n")) {
			this.view();
		}
	}

	private void addToCart(int productId) throws SQLException {
		Statement st = con.createStatement();
		String query = "select ProductId,ProductName,Price from products where ProductId = " + productId;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String insertQuery = "insert into shopping_cart values(?,?,?,?)";
			PreparedStatement prepSt = con.prepareStatement(insertQuery);
			prepSt.setInt(1, this.getRows("shopping_cart") + 1);
			prepSt.setInt(2, rs.getInt(1));
			prepSt.setString(3, rs.getString(2));
			prepSt.setDouble(4, rs.getDouble(3));
			prepSt.executeUpdate();
		}
		System.out.println("Would you like to add a review for the product you bought?");
		String option = new Scanner(System.in).next();
		if (option.equals("y")) {
			System.out.println("Please type your review: ");
			this.review(productId, new Scanner(System.in).nextLine());
		} else {
			this.view();
		}

	}

	private void review(int productId, String review) throws SQLException {
		Statement st = con.createStatement();
		String query = "select ProductId,ProductName from products where ProductId = " + productId;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String insertQuery = "insert into reviews values(?,?,?,?)";
			PreparedStatement prepSt = con.prepareStatement(insertQuery);
			prepSt.setInt(1, this.getRows("reviews") + 1);
			prepSt.setInt(2, rs.getInt(1));
			prepSt.setString(3, rs.getString(2));
			prepSt.setString(4, review);
			prepSt.executeUpdate();
		}

	}

	private int getRows(String table_name) {
		try {
			int count = 0;
			String query = "Select * from " + table_name;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				count += 1;
			}
			return count;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
