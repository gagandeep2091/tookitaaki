package com.tookitaaki.db;

//STEP 1. Import required packages
import java.sql.*;

public class Conn {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/world";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			return conn;
		}
	}

	public static void main(String[] args) {
		/*Connection conn = getConnection();
		PreparedStatement stmt = null;

		try {
			String sql;
			sql = "SELECT code, name, continent FROM country where population > ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 10000);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Retrieve by column name
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);

				// Display values
				System.out.print("CODE: " + code);
				System.out.print(", NAME: " + name);
				System.out.println(", CONTINENT: " + continent);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}*/
	}

}