package maven.firstproject.businessobjects;

import java.util.UUID;

public class Player {
	public UUID ID;
	
	public String Name = "Anonymous";
	
	public int LifeTotal = 20;
	
	// The active currency of the player used to pay for casting cards
	// Active cost pool is reset when the turn is over
	public Cost ActiveCostPool;
	
	// The max cost a player can use at a given time minus the active cost pool
	public Cost PotentialCostPool;
}