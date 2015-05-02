package arcanemaster.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.HexGrid;
import arcanemaster.map.grid.Tile;

public class MapBoard {
	
	public enum Size { 
		//TODO move to config file
		SMALL(29, 20), MEDIUM(46, 28), LARGE(65, 32), XLARGE(81, 40);
		private int x;
		private int y;
		
		private Size(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int dimensionX(){
			return x;
		}
		
		public int dimensionY(){
			return y;
		}
	}
	
	protected ArrayList<AmTile> tiles;
	
	protected Grid grid;
	
	protected int width, height;
	protected boolean wrapsX, wrapsY;
	
	public MapBoard(){
		this(new HexGrid(), Size.SMALL);
	}
	
	public MapBoard(Grid grid, Size size){
		this(grid, size.dimensionY(), size.dimensionX());
	}
	
	public MapBoard(Grid grid, int height, int width){
		this(grid, height, width, false, false);
	}
	
	public MapBoard(Grid grid, int height, int width, boolean wrapX, boolean wrapY){
		this.height = height;
		this.width = width;
		this.grid = grid;
		wrapsX = wrapX;
		wrapsY = wrapY;
		initTiles();
	}

	protected void initTiles() {
		tiles = new ArrayList<AmTile>(height*width);
		for(int i = 0; i < height*width; i++){
			tiles.add(new AmTile());
		}
	}
	
	public AmTile getTile(int x, int y){
		AmTile t = null;
		if (0 <= x && x < width && 0 <= y && y < height){
			t = tiles.get(x + y*width);
		}
		return t;
	}
	
	public Set<AmTile> getNeighbors(Tile t){
		if (t == null){
			return new HashSet<AmTile>();
		}
		int index = tiles.indexOf(t);
		int x = index%width;
		int y = index/width;
		return getNeighbors(x, y);
	}
	
	public Set<AmTile> getNeighbors(int x, int y){
		Set<AmTile> neighbors = new HashSet<>();
		for (GridCoordinate c : grid.neighbors(new GridCoordinate(x, y))) {
			AmTile t = getTile(c.x, c.y);
			if(t != null){
				neighbors.add(t);
			}
		}
		return neighbors;
	}

	public ArrayList<AmTile> allTiles() {
		return tiles;
	}
	
	public GridCoordinate getCoordinate(Tile t){
		int offset = tiles.indexOf(t);
		return new GridCoordinate(offset%width, offset/width);
	}
	
	public int range(Tile source, Tile destination){
		return grid.range(getCoordinate(source), getCoordinate(destination));
	}

}
