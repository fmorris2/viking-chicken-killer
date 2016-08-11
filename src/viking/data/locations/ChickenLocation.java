package viking.data.locations;

import viking.api.location.Location;
import viking.data.locations.impl.FredsFarm;
import viking.data.locations.impl.NorthEastLumbridge;
import viking.data.locations.impl.SouthFalador;

public enum ChickenLocation
{
	NORTH_EAST_LUMBRIDGE(new NorthEastLumbridge()),
	FREDS_FARM(new FredsFarm()),
	SOUTH_FALADOR(new SouthFalador());
	
	private Location loc;
	
	ChickenLocation(Location loc)
	{
		this.loc = loc;
	}

	//Getters and Setters
	public Location getLoc()
	{
		return loc;
	}
}
