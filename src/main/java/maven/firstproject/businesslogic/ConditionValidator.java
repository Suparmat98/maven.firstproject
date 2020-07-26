package maven.firstproject.businesslogic;

import maven.firstproject.businessobjects.Condition;

public class ConditionValidator implements Runnable {

	public boolean IsValid = false;
	public ValidatorState State = ValidatorState.Idle;
	public Condition ConditionToCheck;
	
	@Override
	public void run() {
		if (!ValidateCanRun() && !ValidateConditionGiven())
			return;
		this.State = ValidatorState.Running;
		ValidateCondition();
	}
	
	private boolean ValidateCanRun()
	{
		return this.State == ValidatorState.Idle;
	}
	
	private boolean ValidateConditionGiven()
	{
		return this.ConditionToCheck != null;
	}
	
	private boolean ValidateCondition()
	{
		return true;
	}
}
