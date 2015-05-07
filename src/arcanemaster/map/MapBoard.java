package arcanemaster.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.HexGrid;
import arcanemaster.map.grid.Tile;

public class MapBoard<T extends Tile> {
	
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
	
	protected List<T> tiles;
	
	protected Grid grid;
	
	protected int width, height;
	protected boolean wrapsX, wrapsY;
	
//	public MapBoard(){
//		this(new HexGrid(), Size.SMALL);
//	}
//	
//	public MapBoard(Grid grid, Size size){
//		this(grid, size.dimensionY(), size.dimensionX());
//	}
//	
//	public MapBoard(Grid grid, int height, int width){
//		this(grid, height, width, false, false);
//	}
	
	public MapBoard(List<T> tiles, Grid grid, int height, int width, boolean wrapX, boolean wrapY){
		this.height = height;
		this.width = width;
		this.grid = grid;
		wrapsX = wrapX;
		wrapsY = wrapY;
		this.tiles = tiles;
	}

	protected void initTiles() {
		tiles = new ArrayList<T>(height*width);
		for(int i = 0; i < height*width; i++){
			//tiles.add(new AmTile());
		}
	}
	
	public T getTile(int x, int y){
		T t = null;
		if (0 <= x && x < width && 0 <= y && y < height){
			t = tiles.get(x + y*width);
		}
		return t;
	}
	
	public Set<T> getNeighbors(Tile t){
		if (t == null){
			return new HashSet<T>();
		}
		int index = tiles.indexOf(t);
		int x = index%width;
		int y = index/width;
		return getNeighbors(x, y);
	}
	
	public Set<T> getNeighbors(int x, int y){
		Set<T> neighbors = new HashSet<>();
		for (GridCoordinate c : grid.neighbors(new GridCoordinate(x, y))) {
			T t = getTile(c.x, c.y);
			if(t != null){
				neighbors.add(t);
			}
		}
		return neighbors;
	}

	public List<T> allTiles() {
		return tiles;
	}
	
	public GridCoordinate getCoordinate(T t){
		int offset = tiles.indexOf(t);
		return new GridCoordinate(offset%width, offset/width);
	}
	
	public int range(T source, T destination){
		return grid.range(getCoordinate(source), getCoordinate(destination));
	}

}
