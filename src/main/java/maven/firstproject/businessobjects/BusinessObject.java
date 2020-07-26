package maven.firstproject.businessobjects;

import maven.firstproject.data.SQLExecuter;
import maven.firstproject.data.serialization.DBField;
import maven.firstproject.data.serialization.ObjectToSQLConverter;

public class BusinessObject implements IBusinessObject {
	
	// Every Business Object should have an id
	@DBField(key = "id")
	public int id = 0;
	
	public void Save() {	
		String sql = new ObjectToSQLConverter().ConvertToSQL(this);
		
		Runnable executer = new SQLExecuter(sql);
		new Thread(executer).start();
	}
}
