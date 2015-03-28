package arcanemaster.map.grid;

import java.awt.Point;
import java.util.Set;

public class SquareGrid extends Grid {
	
	protected boolean diagonalIsAdjacent = false;

	
	@Override
	public Point[] getVertices(GridCoordinate c) {
		Point[] points = new Point[4];
		points[0] = topLeft(c);
		points[1] = topRight(c);
		points[2] = bottomLeft(c);
		points[3] = bottomRight(c);
		
		return null;
	}

	private Point bottomRight(GridCoordinate c) {
		return new Point(c.x+1*sidelength, c.y+1*sidelength);
	}

	private Point bottomLeft(GridCoordinate c) {
		return new Point(c.x*sidelength, c.y+1*sidelength);
	}

	private Point topRight(GridCoordinate c) {
		return new Point(c.x+1*sidelength, c.y*sidelength);
	}

	private Point topLeft(GridCoordinate c) {
		return new Point(c.x*sidelength, c.y*sidelength);
	}

	@Override
	public Point getCenterPoint(GridCoordinate c) {
		Point p = topLeft(c);
		int halfside = sidelength/2;
		return new Point(p.x+halfside, p.y + halfside);
	}

	@Override
	public Set<GridCoordinate> neighbors(GridCoordinate c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int range(GridCoordinate c1, GridCoordinate c2) {
		int range = 0;
		range += Math.abs(c1.x - c2.x);
		range += Math.abs(c1.y - c2.y);
		return range;
	}

}
