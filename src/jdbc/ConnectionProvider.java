package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	// JDBC driver name and database URL
	private static final String PROPERTIES = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false"; // MySQL Connector J 8.0
	private static final String DB_SCHEMAS = "Your DB schemas";
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // deprecated "com.mysql.jdbc.Driver";  // try "com.mysql.cj.jdbc.Driver"
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/" + DB_SCHEMAS + PROPERTIES;

	//  Database credentials
	private static final String USER = "Your user name";
	private static final String PASS = "Your password";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER); //STEP 2: Register JDBC driver
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} 
		return DriverManager.getConnection(DB_URL,USER,PASS); //STEP 3: Open a connection
	}
}
