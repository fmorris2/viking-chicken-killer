package viking.mission;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;
import viking.mission.workers.Bank;
import viking.mission.workers.Fight;
import viking.mission.workers.GoToLocation;

public class VCKWorkerManager extends WorkerManager<VCKMission>
{
	private GoToLocation goToLoc;
	private Bank bank;
	private Fight fight;
	
	public VCKWorkerManager(VCKMission mission)
	{
		super(mission);
		goToLoc = new GoToLocation(mission);
		bank = new Bank(mission);
		fight = new Fight(mission);
	}

	@Override
	public Worker<VCKMission> decide()
	{
		mission.getScript().assertion(mission.data.location != null, "Location is null"); //Location cannot be null, otherwise we can't run the script
		
		final boolean IN_LOC = mission.data.location.getLoc().isIn(mission.getScript().myPlayer());
		
		if(IN_LOC)
		{
			mission.getScript().log(this, true, "In location...");
			
			if(inventory.isFull())
				return bank;
			else
				return fight;
		}
		else
		{
			mission.getScript().log(this, true, "Not in location...");
			
			if(!inventory.isEmptyExcept(mission.data.toLoot))
			{	
				mission.getScript().log(this, false, "Erroneous items in inventory, going to bank to deposit them");
				return bank;
			}
			
			return goToLoc;
		}
	}
	
}
