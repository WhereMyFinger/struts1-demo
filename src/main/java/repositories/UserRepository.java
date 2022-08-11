package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import entities.User;

public class UserRepository {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public UserRepository(){
		try {
			this.connection = DatabaseConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers() throws SQLException, Exception {
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM db_user";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}
	
	public int addUser(User user) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO db_user (name, age, email, password) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public boolean checkLogin(User user) throws Exception {
		boolean isValid = false;
		try {
			String sql = "SELECT * FROM db_user where email = ? and password = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				isValid = true;
			}
			else {
				isValid = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
