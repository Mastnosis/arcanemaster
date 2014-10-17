package arcanemaster.map.grid;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import arcanemaster.map.Tile;
import arcanemaster.unit.Moveable;

public abstract class AbstractGrid {
	
	
	
	public abstract Set<Coordinate> neighbors(Coordinate c);
	
//	public List<Tile> calculateShortestPath(Moveable unit, Coordinate start, Coordinate destination){
//		Set<Coordinate> path = new LinkedHashSet<Coordinate>();
//		Map<Coordinate, Integer> values = new HashMap<Coordinate, Integer>();
//		values.put(start, 0);
//		return new LinkedList<Tile>(path);
//	}

}
