package arcanemaster.map.grid;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public abstract class Grid {
	
	protected int sidelength = 40; // necessary for calculating vertices
		
	/*
	 * return the set of all adjacent locations to the specified location
	 */
	public abstract Set<GridCoordinate> neighbors(GridCoordinate c);
	
	/*
	 * return the set of all locations within the given radius. Radius 0
	 * would return the source tile. Radius 1 would return source tile and
	 * all neighbors. Radius 2 would return the neighbors of the source and
	 * all of their neighbors etc.
	 */
	public Set<GridCoordinate> neighborsRadius(GridCoordinate c, int radius){
		Set<GridCoordinate> results = new HashSet<GridCoordinate>();
		if(radius < 0){
			// do nothing
		} else if (radius == 0){
			results.add(c);
		} else {		
			Set<GridCoordinate> intermediate = neighborsRadius(c, radius -1);
			for (GridCoordinate cd : intermediate) {
				results.addAll(neighbors(cd));
			}
			results.addAll(intermediate);
		}
		return results;
	}

	/*
	 * this method returns all coordinates at the specified radius. locations 
	 * within that radius are excluded.
	 */
	public Set<GridCoordinate> ring(GridCoordinate c, int radius){
//		Set<Coordinate> s = neighborsRadius(c, radius);
//		s.removeAll(neighborsRadius(c, radius-1));
		
		Set<GridCoordinate> s = new HashSet<GridCoordinate>();
		if (radius < 0){
			// do nothing
		} else if (radius == 0){
			s.add(c);
		} else {
			s.addAll(ring(c, radius -1));
		}
		return s;
	}
	
	public abstract int range(GridCoordinate c1, GridCoordinate c2);
	
	public abstract Point[] getVertices(GridCoordinate c);
	
	public abstract Point getCenterPoint(GridCoordinate c);
	
	
	
	


}
