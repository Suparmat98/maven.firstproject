package maven.firstproject.data;

import maven.firstproject.data.DatabaseConnection.Connector;

public class DatabaseUpdater implements Runnable{

	private static final String[] SQLFileNames = {
		"UpdateCardTable",
		"UpdateCostTable"
	};
	
	@Override
	public void run() {
		Connector.AwaitConnected();
		
		ResourceFileReader reader = new ResourceFileReader();
		for(String fileName : SQLFileNames)
			RunSQLFile(reader, fileName);
	}
	
	public void RunSQLFile(ResourceFileReader reader, String fileName)
	{
		String sql = reader.GetSQLFileContent(fileName);
		
		Runnable executer = new SQLExecuter(sql);
		new Thread(executer).start();
	}
}
