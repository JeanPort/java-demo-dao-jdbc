package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			 
				} catch (SQLException e) {
					throw new DbExeption(e.getMessage());
				}
		}
		return conn;
	}
	
	public static void closeConnetion() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try (FileInputStream fS = new FileInputStream("db.properties")) {
			
			Properties props = new Properties();
			props.load(fS);
			return props;
		} catch (IOException e) {
			throw new DbExeption(e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
	}
	
	public static void closeStatment(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbExeption(e.getMessage());
				
			}
		}
	}

}
