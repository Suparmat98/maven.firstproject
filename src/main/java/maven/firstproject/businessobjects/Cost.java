package maven.firstproject.businessobjects;

import java.util.ArrayList;

import maven.firstproject.data.serialization.DBField;
import maven.firstproject.data.serialization.Serializable;

@Serializable
public class Cost extends BusinessObject{
	
	@DBField(key = "tmpname")
	public String tmpname;
	
	// This array stores the types of costs and their amounts
	public ArrayList<CostType> CostBank;
}
