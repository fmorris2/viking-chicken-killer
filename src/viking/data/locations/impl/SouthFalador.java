package viking.data.locations.impl;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.location.Location;

public class SouthFalador extends Location
{
	@Override
	public Area constructArea()
	{
		return new Area(3014, 3298, 3020, 3282);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
