package viking.mission.workers;

import viking.framework.worker.Worker;
import viking.mission.VCKMission;

public class Bank extends Worker<VCKMission>
{
	public Bank(VCKMission mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@Override
	public void work()
	{
		script.log(this, true, "Banking");
		
		if(walkUtils.walkToArea(bankUtils.getClosest()))
		{
			script.log(this, true, "In bank");
			if(bankUtils.open())
			{
				script.log(this, true, "Bank open");
				bank.depositAll();
			}
		}
	}

}
