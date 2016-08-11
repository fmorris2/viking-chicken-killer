package viking.data.locations.impl;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.location.Location;

public class FredsFarm extends Location
{
	@Override
	public Area constructArea()
	{
		return new Area(3168, 3307, 3186, 3287);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
