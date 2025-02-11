package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClothesDAO {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/clothe";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	public String registerUser(Customer customer) {
		String message = "";
		try {
			Connection con = getConnection();

			String query = "insert into customer values(?,?,?,?,?,?,?,?,?)";
			
			//prepared statement for query
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, customer.getId());
			pst.setString(2, customer.getName());
			pst.setString(3, customer.getGender());
			pst.setString(4, customer.getAddress());
			pst.setString(5, customer.getPhone());
			pst.setString(6, customer.getEmail());
			pst.setString(7, customer.getImagepath());
			pst.setString(8, customer.getPassword());
			pst.setString(9, customer.getRole());
		
			int rows = pst.executeUpdate();
			if (rows <= 1) {
				message = "Successfully Added";
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		return message;
	}
	
	public boolean loginUser(String email, String password) {
		boolean isValid = false;
		Connection con;
		try {
			con = getConnection();
			String query = "select * from customer where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet row = pst.executeQuery();
			
			//returns true or false >> row.next()
			isValid = row.next();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	public String updateProduct(Customer customer) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "UPDATE customer SET name=?, gender=?,address=?,image=?, phone=?, password=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,customer.getName());
			pst.setString(2,customer.getGender());
			pst.setString(3,customer.getAddress());
			pst.setString(4,customer.getImagepath());
			pst.setString(5,customer.getPhone());
			pst.setString(6,customer.getPassword());
			pst.setString(7,customer.getEmail());

			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully Updated";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}
	

	public Customer getCustomerEmail(String email) {
		Customer cust = null;
		Connection con;
		try {
			con = getConnection();
			String query = "select * from customer where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			
			ResultSet row = pst.executeQuery();
			
			//returns true or false >> row.next()
			if (row.next()) {
				String id = row.getString(1);
				String name = row.getString(2);
				String gender = row.getString(3);
				String address = row.getString(4);
				String phone = row.getString(5);
				String emailCustomer = row.getString(6);
				String image = row.getString(7);
				String password = row.getString(8);
				String decryptedPassword = AESEncryption.decrypt(password);
				String role = row.getString(9);
				
				
				cust = new Customer(id, name, gender, address, phone, emailCustomer, decryptedPassword, image, role);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}
	
	public String addProduct(Clothe clothe) {
		String message = "";
		try {
			Connection con = getConnection();

			String query = "insert into products(id,name,photo,price,brand,stock,category,rating) values(?,?,?,?,?,?,?,?)";
			
			//prepared statement for query
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, clothe.getId());
			pst.setString(2, clothe.getName());
			pst.setString(3, clothe.getImage());
			pst.setString(4, clothe.getPrice());
			pst.setString(5, clothe.getBrand());
			pst.setString(6, clothe.getStock());
			pst.setString(7, clothe.getCategory());
			pst.setString(8, clothe.getRating());
		
			int rows = pst.executeUpdate();
			if (rows <= 1) {
				message = "Successfully Added";
			}
			else {
				message = "Unsuccessful";
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		return message;
	}
	
	public ArrayList<Clothe> fetchClothe(){
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from products";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);		
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clotheList;			
	}
	
	public Clothe getProductById(String id) {
		Clothe clothe = null;
		Connection con;
		try {
			con = getConnection();
			String query = "select * from products where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, id);
			
			ResultSet row = pst.executeQuery();
			
			//returns true or false >> row.next()
			if (row.next()) {
				String name = row.getString(2);
				String photo = row.getString(3);
				String price = row.getString(4);
				String brand = row.getString(5);
				String stock = row.getString(6);
				String category = row.getString(7);
				String rating = row.getString(8);
				
				
				clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clothe;
	}

	public String deleteProductById(String id) {
		String message = "";
		Connection con;
		try {
			con = getConnection();
			String query = "DELETE FROM products where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, id);
			
			pst.executeUpdate();
			message = "Successfully deleted";
		}
		catch (Exception e) {
			
		}
		return message;
	}

	public String updateProduct(Clothe clothe) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "UPDATE products SET name=?, price=?,stock=?,category=?, brand=?, rating=?, photo=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,clothe.getName());
			pst.setString(2,clothe.getPrice());
			pst.setString(3,clothe.getStock());
			pst.setString(4,clothe.getCategory());
			pst.setString(5,clothe.getBrand());
			pst.setString(6,clothe.getRating());
			pst.setString(7,clothe.getImage());
			pst.setString(8,clothe.getId());

			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully Updated";
			}
			else {
				message = "Unsuccessful";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}

	// fetch clothe using name 
	public ArrayList<Clothe> fetchClotheName(String search){
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from products where name like ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, search+"%");
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);		
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clotheList;			
	}
	
	// fetch clothe using name in asce order
	public ArrayList<Clothe> fetchClotheAsce(){
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from products order by name asce";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);		
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clotheList;			
	}
	
	// fetch clothe using category
	public ArrayList<Clothe> fetchClotheCategory(){
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from products order by category desc";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);		
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clotheList;			
	}

	public String updateProfile(Customer customer) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "UPDATE customer SET name=?, gender=?,address=?,phone=?, image=?, password=?, role=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,customer.getName());
			pst.setString(2,customer.getGender());
			pst.setString(3,customer.getAddress());
			pst.setString(4,customer.getPhone());
			pst.setString(5,customer.getImagepath());

			pst.setString(6,customer.getPassword());
			
			pst.setString(7,customer.getRole());
			pst.setString(8,customer.getId());

			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully Updated";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}

	//creating a cart in for database
	public String createCart(Cart cart) {
		String message = "";
		try {
			Connection con = getConnection();

			String query = "insert into cart(product,user) values(?,?)";
			
			//prepared statement for query
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, cart.getProductId());
			pst.setString(2, cart.getUser());
		
			int rows = pst.executeUpdate();
			if (rows <= 1) {
				message = "Successfully Added";
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		return message;
	}
	
	
	public ArrayList<Cart> getCartByUser(String user) {
	    ArrayList<Cart> cartList = new ArrayList<Cart>();
	    try {
	        Connection con = getConnection();

	        String query = "select c.id, p.id ProductId, p.name, p.price from cart c inner join products p on c.product = p.id where c.user = ?";

	        // prepared statement for query
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setString(1, user);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	        	String id = rs.getString("id");
	        	String productId = rs.getString("ProductId");
	            String productName = rs.getString("name");
	            String userString = rs.getString("price");
	            
	            Cart cart = new Cart(id, productId, productName, userString);
	            cartList.add(cart);
	        }

	        con.close();

	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return cartList;
	}

	public ArrayList<Clothe> sortByNameAsc() {
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM products ORDER BY name";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		return clotheList;
	}
	
	public ArrayList<Clothe> sortByPriceDesc() {
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM products ORDER BY price desc";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return clotheList;
	}
	
	public ArrayList<Clothe> sortByNameDesc() {
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM products ORDER BY name desc";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
				
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return clotheList;
	}
	
	public ArrayList<Clothe> sortByRatingDesc() {
		ArrayList<Clothe> clotheList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM products ORDER BY rating desc";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String photo = table.getString(3);
				String price = table.getString(4);
				String brand = table.getString(5);
				String stock = table.getString(6);
				String category = table.getString(7);
				String rating = table.getString(8);
					
				Clothe clothe = new Clothe(id, name, photo, price, stock, category, rating, brand);
				clotheList.add(clothe);
			}
				con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return clotheList;
	}

	public String deleteCartById(String id) {
		String message = "";
		Connection con;
		try {
			con = getConnection();
			String query = "DELETE FROM cart where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, id);
			
			pst.executeUpdate();
			message = "Successfully deleted";
		}
		catch (Exception e) {
			
		}
		return message;
	}
	
	//creating a order in for database
	public String createOrder(Order order) {
		String message = "";
		try {
			Connection con = getConnection();

			String query = "insert into order_product (product,price,quantity,user) values(?,?,?,?)";
			
			//prepared statement for query
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, order.getProduct());
			pst.setString(2, order.getPrice());
			pst.setString(3, order.getQuantity());
			pst.setString(4, order.getUser());
		
			int rows = pst.executeUpdate();
			if (rows <= 1) {
				message = "Successfully Added";
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		return message;
	}
	
	
	public ArrayList<Order> getOrders() {
	    ArrayList<Order> orderList = new ArrayList<Order>();
	    try {
	        Connection con = getConnection();

	        String query = "select * from order_product";

	        // prepared statement for query
	        PreparedStatement pst = con.prepareStatement(query);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	        	String id = rs.getString("orderid");
	        	String product = rs.getString("product");
	            String price = rs.getString("price");
	            String quantity = rs.getString("quantity");
	            String user = rs.getString("user");
	            
	            Order cart = new Order(id, product, price, quantity, user);
	            orderList.add(cart);
	        }

	        con.close();

	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return orderList;
	}
	
	
	public ArrayList<Order> getOrderByUser(String user) {
	    ArrayList<Order> orderList = new ArrayList<Order>();
	    try {
	        Connection con = getConnection();

	        String query = "SELECT c.orderId, p.name, c.price, c.quantity FROM order_product c INNER JOIN products p ON c.product = p.id WHERE c.user=?";

	        // prepared statement for query
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setString(1, user);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	        	String id = rs.getString("orderId");
	        	String name = rs.getString("name");
	            String price = rs.getString("price");
	            String quantity = rs.getString("quantity");
	            
	            Order cart = new Order(id, name, price, quantity, user);
	            orderList.add(cart);
	        }

	        con.close();

	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return orderList;
	}
	
	
}


	
