package viking.mission;

import viking.data.Data;
import viking.framework.goal.GoalList;
import viking.framework.mission.Mission;
import viking.framework.script.VikingScript;

public class VCKMission extends Mission
{
	private static final int SLEEP_TIME = 300; //sleep time per main loop cycle
	
	private VCKWorkerManager manager;
	public Data data;
	
	public VCKMission(VikingScript script, Data data)
	{
		super(script);
		this.data = data;
		manager = new VCKWorkerManager(this);
	}

	@Override
	public boolean canEnd()
	{
		return false;
	}

	@Override
	public String getMissionName()
	{
		return "Viking Chicken Killer";
	}

	@Override
	public String getCurrentTaskName()
	{
		return null;
	}

	@Override
	public String getEndMessage()
	{
		return "Viking Chicken Killer with goals " + goals + " has ended";
	}

	@Override
	public GoalList getGoals()
	{
		return null;
	}

	@Override
	public String[] getMissionPaint()
	{
		return null;
	}

	@Override
	public int execute()
	{	
		manager.work();
		return SLEEP_TIME;
	}

	@Override
	public void resetPaint()
	{
	}

}
