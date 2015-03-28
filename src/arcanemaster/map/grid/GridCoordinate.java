package arcanemaster.map.grid;

import java.awt.Point;

@SuppressWarnings("serial")
public class GridCoordinate extends Point {

	public GridCoordinate(int x, int y){
		super(x,y);
	}
	
	public GridCoordinate(){
		this(0,0);
	}

}
