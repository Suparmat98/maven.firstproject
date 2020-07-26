package maven.firstproject.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import maven.firstproject.data.DatabaseConnection.Connector;

public class SQLExecuter implements Runnable {

	private String sql;
	
	public SQLExecuter(String sql)
	{
		this.sql = sql;
	}
	
	@Override
	public void run() {
		try {
			PreparedStatement sqlStatement = Connector.Connection.prepareStatement(this.sql);
			sqlStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
