package arcanemaster.map.grid;

import java.util.HashSet;
import java.util.Set;

/**
 * 	 _   _   _
 *	/ \_/ \_/ \
 *  \_/ \_/ \_/
 *  / \_/ \_/ \
 *  \_/ \_/ \_/
 *  / \_/ \_/ \
 *  
 *  coordinates based on pointed orientation
 *  
 *   /\  /\  /\  /\  /\  /\   Y
 *  /  \/  \/  \/  \/  \/  \
 *  |   |   |   |   |   |   | 
 *  | X | 1 | 2 |   |   |   | 0
 *  \  /\  /\  /\  /\  /\  /
 *   \/  \/  \/  \/  \/  \/
 *    |   |   |   |   |   |
 *    | 0 | 1 | 2 |   |   |   1
 *   /\  /\  /\  /\  /\  /\
 *  /  \/  \/  \/  \/  \/  \
 *  |   |   |   |   |   |   |
 *  | 0 | 1 | 2 |   |   |   | 2
 *  \  /\  /\  /\  /\  /\  /
 *   \/  \/  \/  \/  \/  \/ 
 *  
 * @author icarus
 *
 */

public class HexGrid extends AbstractGrid{

	@Override
	public Set<Coordinate> neighbors(Coordinate c) {
		Set<Coordinate> neighbors = new HashSet<Coordinate>(6);
		neighbors.add(new Coordinate(c.x -1, c.y));
		neighbors.add(new Coordinate(c.x +1, c.y));
		neighbors.add(new Coordinate(c.x, c.y-1));
		neighbors.add(new Coordinate(c.x, c.y+1));
		if (c.y%2 == 0){ //y is even
			neighbors.add(new Coordinate(c.x-1, c.y-1));
			neighbors.add(new Coordinate(c.x-1, c.y+1));
		}else{
			neighbors.add(new Coordinate(c.x+1, c.y-1));
			neighbors.add(new Coordinate(c.x+1, c.y+1));
		}
		return neighbors;
	}

}
