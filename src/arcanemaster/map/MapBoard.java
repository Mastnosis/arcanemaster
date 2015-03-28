package arcanemaster.map;

import java.util.ArrayList;
import java.util.HashSet;
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
	
	protected ArrayList<Tile> tiles;
	
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
		tiles = new ArrayList<Tile>(height*width);
		for(int i = 0; i < height*width; i++){
			tiles.add(new Tile());
		}
	}
	
	public Tile getTile(int x, int y){
		Tile t = null;
		if (0 <= x && x < width && 0 <= y && y < height){
			t = tiles.get(x + y*width);
		}
		return t;
	}
	
	public Set<Tile> getNeighbors(Tile t){
		if (t == null){
			return new HashSet<Tile>();
		}
		int index = tiles.indexOf(t);
		int x = index%width;
		int y = index/width;
		return getNeighbors(x, y);
	}
	
	public Set<Tile> getNeighbors(int x, int y){
		Set<Tile> neighbors = new HashSet<Tile>();
		for (GridCoordinate c : grid.neighbors(new GridCoordinate(x, y))) {
			neighbors.add(getTile(c.x, c.y));
		}
		return neighbors;
	}

	public Tile[] allTiles() {
		return (Tile[]) tiles.toArray();
	}
	
	public GridCoordinate getCoordinate(Tile t){
		int offset = tiles.indexOf(t);
		return new GridCoordinate(offset%width, offset/width);
	}
	
	public int range(Tile source, Tile destination){
		return grid.range(getCoordinate(source), getCoordinate(destination));
	}

}