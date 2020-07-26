package maven.firstproject.data.serialization;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import maven.firstproject.businessobjects.BusinessObject;
import maven.firstproject.businessobjects.IBusinessObject;
import maven.firstproject.data.Filter;
import maven.firstproject.data.KeyValuePair;

public class ObjectToSQLConverter {
	public String ConvertToSQL(BusinessObject bo) {
		CheckIfSerializable(bo);
		
		String sql = null;
		try {
			if (bo.id == 0)
				sql = BuildInsertSQL(bo);
			else
				sql = BuildUpdateSQL(bo);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return sql;
	}

	public void CheckIfSerializable(Object object) {
		if (Objects.isNull(object)) {
			throw new SerializationException("Can't serialize a null object");
		}

		Class<?> clazz = object.getClass();
		
		if (!clazz.isAnnotationPresent(Serializable.class)) {
			throw new SerializationException(
					"The class " + clazz.getSimpleName() + " is not annotated with Serializable");
		}
	}

	private ArrayList<KeyValuePair> getElements(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		
		ArrayList<KeyValuePair> elements = new ArrayList<KeyValuePair>();
		
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(DBField.class)) {
				elements.add(new KeyValuePair(getKey(field), field.get(object)));
			}
		}
		
		return elements;
	}

	public String getKey(Field field) {
		String value = field.getAnnotation(DBField.class).key();
		return value.isEmpty() ? field.getName() : value;
	}
	
	public String BuildSelectSQL(Class<? extends IBusinessObject> boClass, Filter filter) {
		String boClassName = boClass.getSimpleName();
		
		ArrayList<String> fields = new ArrayList<String>();
		ArrayList<String> joins = new ArrayList<String>();
		
		for(Field field : boClass.getFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(DBField.class)) {
				fields.add(boClassName + "." + getKey(field));
			}
			else if (field.isAnnotationPresent(DBLink.class)) {
				String key = getKey(field);
				String thisID = String.format("%s.%s", boClassName, key);
				String otherID = String.format("%s.id", key);
				joins.add(String.format("INNER JOIN %s ON %s = %s", key, thisID, otherID));
			}
		}
		
		String fieldsString = String.join(",", fields);
		String joinsString = String.join(" ", joins);
		String sql = String.format("SELECT %s FROM `%s` WHERE %s %s;", fieldsString, boClassName, filter, joinsString);
		
		return sql;
	}

	public String BuildInsertSQL(IBusinessObject bo) throws IllegalArgumentException, IllegalAccessException  {
		String className = bo.getClass().getSimpleName();
		
		ArrayList<KeyValuePair> elements = getElements(bo);
		
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		for(KeyValuePair kvp : elements)
		{
			keys.add(String.format("`%s`", kvp.Key));
			values.add(String.format("'%s'", kvp.Value));
		}
		
		String sql = String.format("INSERT INTO `%s` (%s) VALUES (%s);", className, String.join(",", keys), String.join(",", values));
		
		return sql;
	}
	
	public String BuildUpdateSQL(BusinessObject bo) throws IllegalArgumentException, IllegalAccessException  {
		String className = bo.getClass().getSimpleName();
		
		ArrayList<KeyValuePair> elements = getElements(bo);
		
		ArrayList<String> values = new ArrayList<String>();
		
		for(KeyValuePair kvp : elements)
		{		
			values.add(String.format("%s = '%s'", kvp.Key, kvp.Value));
		}
		
		String matches = String.join(",", values);
		
		String sql = String.format("UPDATE `%s` SET %s WHERE id = %s;", className, matches, bo.id);
		
		return sql;
	}
}
