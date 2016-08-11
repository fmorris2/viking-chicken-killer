package viking.mission.workers;

import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.filter.NameFilter;
import org.osbot.rs07.api.model.NPC;

import viking.api.Timing;
import viking.api.filter.VFilters;
import viking.api.interaction.impl.ClickNpc;
import viking.framework.worker.Worker;
import viking.mission.VCKMission;

public class Fight extends Worker<VCKMission>
{
	private static final Filter<NPC> NAME_FILTER = new NameFilter<>("Chicken");
	
	public Fight(VCKMission mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return inCombat();
	}

	@Override
	public void work()
	{
		script.log(this, true, "Fight");
		
		if(inCombat())
			script.log(this, true, "Is fighting");
		else //Not in combat, can attack next npc
			attack();
	}
	
	@SuppressWarnings("unchecked")
	private void attack()
	{
		NPC closest = npcs.closest(true, VFilters.and(NAME_FILTER, filters.ABLE_TO_ATTACK_NPC));
		
		if(closest != null)
		{
			script.log(this, true, "Closest npc found at " + closest.getPosition());
			
			if(new ClickNpc(this, "Attack", closest).execute())
				Timing.waitCondition(conditions.IN_COMBAT.or(conditions.stolenEntity(closest)), 100, 3500);
		}
		else //no chickens
			script.log(this, true, "No chickens found");
	}
	
	private boolean inCombat()
	{
		return combat.isFighting() || myPlayer().getInteracting() != null;
	}

}
