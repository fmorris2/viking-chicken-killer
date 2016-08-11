package viking.script;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.osbot.rs07.script.ScriptManifest;

import viking.data.Data;
import viking.data.locations.ChickenLocation;
import viking.framework.mission.Mission;
import viking.framework.paint.VikingPaint;
import viking.framework.script.VikingScript;
import viking.mission.VCKMission;
import viking.paint.VikingChickenKillerPaint;

@ScriptManifest(author = "The Viking", name = "VCK", info = "Kills chickens", version = 0, logo = "")
public class VikingChickenKiller extends VikingScript
{

	@Override
	public Queue<Mission> generateMissions()
	{
		Data data = new Data();
		data.location = ChickenLocation.SOUTH_FALADOR;
		
		return new LinkedList<>(Arrays.asList(new VCKMission(this, data)));
	}

	@Override
	public VikingPaint<?> getVikingPaint()
	{
		return new VikingChickenKillerPaint(this);
	}

	@Override
	public boolean isDevBuild()
	{
		return true;
	}
}
