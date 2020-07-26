package maven.firstproject.data;

import java.util.ArrayList;

public class Filter {
	public String Key;
	
	public FilterOperation Operation;
	
	public String Value;
	
	public ArrayList<Filter> Subfilters;
	
	/** Filter with sub filters using And */
	public Filter(ArrayList<Filter> subfilters) {
		this(subfilters, FilterOperation.And);
	}
	
	/** Filter with sub filters */
	public Filter(ArrayList<Filter> subfilters, FilterOperation operation) {
		this.Operation = operation;
		this.Subfilters = subfilters;
	}
	
	/** Filter with no sub filters */
	public <T> Filter(String key, FilterOperation type, T value) {
		
		if (type == FilterOperation.And || type == FilterOperation.Or){
			throw new IllegalArgumentException("Basic filters can't have subfilter operations."); 
		}
		
		this.Key = key;
		this.Operation = type;
		this.Value = value.toString();
	}
	
	/** Filter with no sub filters using Equal*/
	public <T> Filter(String key, T value) {
		this(key, FilterOperation.equal, value);
	}
	
	public String toString() {
		if (HasSubfilters())
			return "";
		else
			return String.format("%s=%s", this.Key, this.Value);
	}
	
	public boolean HasSubfilters(){
		return this.Operation == FilterOperation.And || this.Operation == FilterOperation.Or;
	}
}
