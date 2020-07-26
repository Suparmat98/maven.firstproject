package maven.firstproject.data;

public class KeyValuePair {
	public String Key;
	public Object Value;
	public Class<?> Type; 
	
	public <T> KeyValuePair(String key, T value)
	{
		this.Key = key;
		this.Value = value;
		this.Type = value.getClass();
	}
}