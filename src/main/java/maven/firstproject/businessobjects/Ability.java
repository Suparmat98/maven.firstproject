package maven.firstproject.businessobjects;

import java.util.ArrayList;

public class Ability {
	
	// The name of this ability as seen on a card
	public String Name;
	
	// When activating the ability, the conditions must all be validated and be valid
	public ArrayList<Condition> Conditions;
}
