package arcanemaster.map.grid;

import java.awt.Point;
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
 *  coordinates based on pointed orientation not flat orientation as above
 *  
 *   /\  /\  /\  /\  /\  /\   Y
 *  /  \/  \/  \/  \/  \/  \
 *  |   |   |   |   |   |   | 
 *  |X0 | 1 | 2 |   |   |   | 0
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
 * This is the implementation of a grid using hexes as opposed to for example
 * squares or triangles. Except for along the edges of the map each hex 
 * should have 6 neighbors.
 *
 */

public class HexGrid extends Grid{
	
	static int size = 60;  // length in pixels of a side
	
	static int h = (int) (Math.sin(Math.toRadians(60))*size);

	public HexGrid(){

	}
	
	public HexGrid(int sidelength){
		size = sidelength;
	}

	@Override
	public Set<GridCoordinate> neighbors(GridCoordinate c) {
		Set<GridCoordinate> neighbors = new HashSet<>();
		neighbors.add(new GridCoordinate(c.x-1, c.y));
		neighbors.add(new GridCoordinate(c.x+1, c.y));
		neighbors.add(new GridCoordinate(c.x, c.y-1));
		neighbors.add(new GridCoordinate(c.x, c.y+1));
		if (c.y%2 == 0){ //y is even
			neighbors.add(new GridCoordinate(c.x-1, c.y-1));
			neighbors.add(new GridCoordinate(c.x-1, c.y+1));
		}else{
			neighbors.add(new GridCoordinate(c.x+1, c.y-1));
			neighbors.add(new GridCoordinate(c.x+1, c.y+1));
		}
		return neighbors;
	}

	@Override
	public Point[] getVertices(GridCoordinate c) {
		Point[] points = new Point[6];
		points[0] = topPoint(c);
		points[1] = upperLeftPoint(c);
		points[2] = lowerLeftPoint(c);
		points[3] = bottomPoint(c);
		points[4] = lowerRightPoint(c);
		points[5] = upperRightPoint(c);
		return points;
	}
	
	public static Point[] getVertices(int x, int y) {
		GridCoordinate c = new GridCoordinate(x,y);
		Point[] points = new Point[6];
		points[0] = topPoint(c);
		points[1] = upperLeftPoint(c);
		points[2] = lowerLeftPoint(c);
		points[3] = bottomPoint(c);
		points[4] = lowerRightPoint(c);
		points[5] = upperRightPoint(c);
		return points;
	}

	private static Point upperRightPoint(GridCoordinate c) {
		int x, y;
		x = ((2*c.x + 2)*h)+c.y%2*h;
		y = (int) ((1.5*size*c.y)+size/2);
		return new Point(x-1,y+1);
	}

	private static Point lowerRightPoint(GridCoordinate c) {
		int x, y;
		x = ((2*c.x + 2)*h)+c.y%2*h;
		y = (int) ((1.5*size*c.y)+size/2 + size);
		return new Point(x-1,y-1);
	}

	private static Point bottomPoint(GridCoordinate c) { // done
		int x, y;
		x = ((2*c.x +1)*h)+c.y%2*h;
		y = (int) ((1.5*size*c.y)+2*size);
		return new Point(x,y-1);
	}

	private static Point lowerLeftPoint(GridCoordinate c) {
		int x, y;
		x = ((2*c.x)*h)+c.y%2*h;
		y = (int) ((1.5*size*c.y)+size/2 + size);
		return new Point(x+1,y-1);
	}

	private static Point upperLeftPoint(GridCoordinate c) {
		int x, y;
		x = ((2*c.x)*h)+c.y%2*h;
		y = (int) ((1.5*size*c.y)+size/2);
		return new Point(x+1,y+1);
	}

	private static Point topPoint(GridCoordinate c) { // done
		int x, y;
		x = ((2*c.x + 1)*h)+c.y%2*h;
		y = (int) (1.5*size*c.y);
		return new Point(x,y+1);
	}

	@Override
	public Point getCenterPoint(GridCoordinate c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int range(GridCoordinate c1, GridCoordinate c2) {
		
		int x = Math.abs(c1.x - c2.x);
		int y = Math.abs(c1.y - c2.y);
		return Math.max(x, y);
	}

	

}
