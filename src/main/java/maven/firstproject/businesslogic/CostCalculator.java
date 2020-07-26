package maven.firstproject.businesslogic;

import maven.firstproject.businessobjects.Cost;
import maven.firstproject.businessobjects.CostType;

public class CostCalculator {
	
	// Get the total cost of a card
	public int GetConvertedCost(Cost cost)
	{
		int convertedCost = 0;
		
		for(CostType costType : cost.CostBank)
		{
			convertedCost += costType.Amount;
		}
		
		return convertedCost;
	}
	
	// Get the devotion to a CostType
	public int GetDevotion(Cost cost, CostType costTypeToCheck)
	{
		int devotion = 0;
		
		for(CostType costType : cost.CostBank)
		{
			if (costType.Name == costTypeToCheck.Name)
				devotion += costType.Amount;
		}
		
		return devotion;
	}
}
