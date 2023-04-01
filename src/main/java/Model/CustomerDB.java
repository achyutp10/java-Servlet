package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class CustomerDB {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/ecommerce";
		String username = "root";
		String password = "";
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public String signup(String name, String email, String password){
		String message = "";
		try {
			
			Connection con = getConnection();
			String query = "insert into customer values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,password);
			
			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully added";
			}
con.close();
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			message = e.getMessage();
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			message = e.getMessage();
			e.printStackTrace();
		}
		
		return message;
	}
	public ResultSet fetchCustomerRecord() {
		try {
			Connection con = getConnection();
			String query ="select * from customer";
			PreparedStatement st =con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			return table;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	return null;
}
	public boolean checkLogin(String id, String password) {
		boolean isValid = false;
		try {
		
		Connection con = getConnection();
		String query = "Select * from registration where id=? and password=?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,id);
		st.setString(2,password);
		
		ResultSet table = st.executeQuery();
		/*
		 * if(table.next()) { isValid = true; }
		 */
		isValid = table.next();
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isValid;
	}
}
