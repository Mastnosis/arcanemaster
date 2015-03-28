package arcanemaster.map;

import java.util.List;

public interface Moveable {
	
	/*
	 * previous cost is sometimes necessary when calculating multi-turn movement.
	 * Some movement models allow for units to enter terrain that exceeds a units
	 * movement allowance provided it is the only tile entered for the turn.
	 * 
	 * We pass a Tile rather than a terrain type because certain movement is 
	 * dependent on whether a space is occupied or not and by whom.  A tile object
	 * should have a reference to both terrain and any units/buildings occupying the 
	 * desired location.
	 */
	public double costToEnter(Terrain t, int previousCost);	// TODO whoops, changed this to terrain to limit coupling, may need to reconsider
	
	public double costToEnter(Terrain t);   // previous cost assumed to be zero
	
	/*
	 * Given a list of tiles in the order traversed, provide the total cost in movement.
	 */
	public double costToTravel(List<ArcaneTile> trail);
	
	
	/*
	 * Given a list of tiles in the order traversed, provide the amount of turns required to 
	 * arrive at the destination location.
	 */
	public double timeToTravel(List<ArcaneTile> trail);
}
