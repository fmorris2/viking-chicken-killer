package viking.mission.workers;

import viking.framework.worker.Worker;
import viking.mission.VCKMission;

public class GoToLocation extends Worker<VCKMission>
{
	public GoToLocation(VCKMission mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return !mission.data.location.getLoc().isIn(myPlayer());
	}

	@Override
	public void work()
	{
		script.log(this, true, "Web-walking to location");
		walkUtils.walkToArea(mission.data.location.getLoc().getArea());
	}
	
}
