package maven.firstproject.businessobjects;

import java.util.ArrayList;

public class Condition {
	
	// The higher this number the more likely it is that this condition will get overruled
	// -1 means no priority, so it will always get last priority
	public int Priority = -1;
	
	public ConditionType Type;
	
	// When the Type is either Or or And this will have sub conditions
	public ArrayList<Condition> SubConditions;
}
