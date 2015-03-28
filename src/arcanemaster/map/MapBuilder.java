package arcanemaster.map;

import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.HexGrid;
import arcanemaster.map.grid.Tile;

public class MapBuilder {

	public enum MapSize{ TINY(15, 12), SMALL(29,20), MEDIUM(46, 28), LARGE(65, 32), XLARGE(81, 40) ;
	private int x;
	private int y;

	private MapSize(int x, int y){
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

	public enum MapType{ ISLAND, CONTINENTAL, LANDLOCKED, LANDMASS, RANDOM};
	
//	protected MapSize size;
	protected MapType type;
	
	protected int height;
	protected int width;
	
	protected boolean wrapX;
	protected boolean wrapY;
	
	protected Grid grid;
	
	
	
	public MapBuilder(){
		//size = MapSize.TINY;
		height = MapSize.SMALL.dimensionY();
		width = MapSize.SMALL.dimensionX();
		type = MapType.RANDOM;
		wrapX = false;
		wrapY = false;
		grid = new HexGrid();
	}
	
	public MapBuilder(String filename){
		
	}
	
	public MapBuilder(MapSize size, MapType type, boolean wrapping){
		
	}
	
	public MapBuilder(int width, int height, MapType type, boolean wrapping){
		
	}
	
	public void wrapX(boolean b){
		wrapX = b;
	}
	
	public void wrapY(boolean b){
		wrapY = b;
	}
	
	public void height(int h){
		height = h;
	}
	
	public void width(int w){
		width = w;
	}
	
	public void grid(Grid g){
		grid = g;
	}
	
	public MapBoard buildMap(){
		MapBoard map = new MapBoard(grid, height, width, wrapX, wrapY);
		createMap(map.allTiles());
		return map;
	}

	private void createMap(Tile[] tiles) {
		// TODO Auto-generated method stub
		
	}

}
