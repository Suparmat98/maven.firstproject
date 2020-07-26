package maven.firstproject.businessobjects;

import java.util.ArrayList;

import maven.firstproject.data.serialization.DBField;
import maven.firstproject.data.serialization.DBLink;
import maven.firstproject.data.serialization.Serializable;

@Serializable
public class Card extends BusinessObject {
	
	// The name of the card as seen on the header
	@DBField(key = "name")
	public String Name;
	
	// The description of the card in flat text
	@DBField(key = "description")
	public String Description;
	
	// The cost to pay when casting this card
	@DBLink(key = "cost")
	public Cost Cost;
	
	@DBField(key = "attack")
	public int Attack;
	
	@DBField(key = "defense")
	public int Defense;
	
	// The type of card
	public ArrayList<String> Types;
	
	// The types of a creature, empty for instants and sorceries
	public ArrayList<String> Tribes;
	
	// A list of actions this card can provoke
	public ArrayList<Ability> Abilities;
	
	// A list of conditions that must be met when casting this card
	public ArrayList<Condition> Conditions;
}
