package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/struts_demo", "postgres", "241299");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print(new DatabaseConnection().getConnection());
	}

}
