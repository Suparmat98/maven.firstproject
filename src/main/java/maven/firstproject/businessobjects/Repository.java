package maven.firstproject.businessobjects;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import maven.firstproject.data.DatabaseConnection.Connector;
import maven.firstproject.data.Filter;
import maven.firstproject.data.serialization.DBField;
import maven.firstproject.data.serialization.ObjectToSQLConverter;

public class Repository<T extends IBusinessObject> {  
	
	private ObjectToSQLConverter converter = new ObjectToSQLConverter();
	
	private ResultSet getResultSet(String sql) {
		PreparedStatement sqlStatement = null;
		try {
			sqlStatement = Connector.Connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet result = null;
		try {
			result = sqlStatement.executeQuery(sql);
			if(!result.next())
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private T castDataToInstance(T newBO, ResultSet result) {
		for(Field field : newBO.getClass().getFields())
		{
			field.setAccessible(true);
			
			if (field.isAnnotationPresent(DBField.class)){
				String fieldName = converter.getKey(field);
				Object value = null;
				try {
					value = result.getObject(fieldName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					field.set(newBO, value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return newBO;
	}
	
	/** Fill a new instance with data from the database, searched by filter */
	public T Get(T newBO, Filter filter) {
		Connector.AwaitConnected();
		String sql = converter.BuildSelectSQL(newBO.getClass(), filter);
		ResultSet result = getResultSet(sql);
		newBO = castDataToInstance(newBO, result);
		return newBO;
	}
	
	/** Fill a new instance with data from the database */
	public T Get(T newBO, int id){
		return Get(newBO, new Filter("id", id));
	}
}
