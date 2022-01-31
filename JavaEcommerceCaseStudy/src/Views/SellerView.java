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

public class SellerView {
	private final Connection con = ConnectionManager.getConnection();

	public void view() throws SQLException {
		System.out.println("1) Get the list of all products" + "\n" + "2) Get details of one product" + "\n"
				+ "3) Insert new product" + "\n" + "4) Delete a product" + "\n" + "5) Update details for a product"
				+ "\n" + "6) Exit");

		int option = new Scanner(System.in).nextInt();

		if (option == 1) {
			this.getProducts();
			this.view();
		} else if (option == 2) {
			System.out.println("Enter the id of product: ");
			this.getProduct(new Scanner(System.in).nextInt());
			this.view();
		} else if (option == 3) {
			Product product = new Product();
			System.out.println("Enter the ProductID for the product: ");
			product.setProductId(new Scanner(System.in).nextInt());
			System.out.println("Enter the name of the product: ");
			product.setProductName(new Scanner(System.in).nextLine());
			System.out.println("Enter a description for the product: ");
			product.setDescription(new Scanner(System.in).nextLine());
			System.out.println("Enter the price of product: ");
			product.setPrice(new Scanner(System.in).nextDouble());
			this.addNewProduct(product);
			this.view();
		} else if (option == 4) {
			System.out.println("Enter the ProductID of the product to be deleted: ");
			this.deleteProduct(new Scanner(System.in).nextInt());
			this.view();
		} else if (option == 5) {
			System.out.println("Enter the ID of the product you want to update: ");
			Product product = this.getProductObject(new Scanner(System.in).nextInt());
			System.out.println("Enter the new Name of the product: ");
			product.setProductName(new Scanner(System.in).nextLine());
			System.out.println("Enter new description for product: ");
			product.setDescription(new Scanner(System.in).nextLine());
			System.out.println("Enter new price for the product: ");
			product.setPrice(new Scanner(System.in).nextDouble());
			this.updateProduct(product);
			this.view();
		} else if (option == 6) {
			new MainView().main(null);
		} else {
			System.out.println("Invalid input");
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
	}

	private void addNewProduct(Product product) throws SQLException {
		String query = "insert into products values(?,?,?,?)";
		PreparedStatement prepSt = con.prepareStatement(query);
		prepSt.setInt(1, product.getProductId());
		prepSt.setString(2, product.getProductName());
		prepSt.setString(3, product.getDescription());
		prepSt.setDouble(4, product.getPrice());
		int result = prepSt.executeUpdate();
		System.out.println("Inserted " + result + " rows");
	}

	private void deleteProduct(int productId) throws SQLException {
		String query = "delete from products where ProductId = " + productId;
		Statement st = con.createStatement();
		int result = st.executeUpdate(query);
		System.out.println("Deleted " + result + " rows");
	}

	private void updateProduct(Product product) throws SQLException {
		String query = "update products set ProductName = ?, Description = ?, Price = ? where ProductId = ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, product.getProductName());
		st.setString(2, product.getDescription());
		st.setDouble(3, product.getPrice());
		st.setInt(4, product.getProductId());
		int result = st.executeUpdate();
		System.out.println("Updated " + result + " rows");
	}

	private Product getProductObject(int productId) throws SQLException {
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
		return product;
	}

}
