package maven.firstproject.data;

import java.sql.Connection;

public class DatabaseConnection {
	
	public static class Connector {
		public static boolean IsConnected = false;
		public static Connection Connection;
		
		public static void AwaitConnected() {
			int ConnectionAttempts = 10000;
			while(!Connector.IsConnected && ConnectionAttempts != 0)
			{
				ConnectionAttempts--;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Attempts over");
		}
	}
}
