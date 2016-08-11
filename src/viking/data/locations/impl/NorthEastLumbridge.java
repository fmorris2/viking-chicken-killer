package viking.data.locations.impl;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.location.Location;

public class NorthEastLumbridge extends Location
{
	@Override
	public Area constructArea()
	{
		return new Area(3236, 3287, 3225, 3301);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
