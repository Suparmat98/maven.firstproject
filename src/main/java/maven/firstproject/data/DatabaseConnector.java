package maven.firstproject.data;

import java.sql.Connection;
import java.sql.DriverManager;

import maven.firstproject.data.DatabaseConnection.Connector;

public class DatabaseConnector implements Runnable {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/cardgame";
			String username = "Connector";
			String password = "Connector";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connected");
			
			return conn;
		} catch(Exception e) {
			System.out.println("Failed connection");
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public void run() {
		
		Connection conn = getConnection();
		
		if (conn != null)
		{
			Connector.Connection = conn;
			Connector.IsConnected = true;
		}
	}
}
