package arcanemaster.map;

import java.util.Random;

import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.HexGrid;

public class MapBuilder {

	public enum MapSize{ TINY(15, 12), SMALL(29,20), MEDIUM(47, 28), LARGE(65, 32), XLARGE(81, 40) ;
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
	// protected MapBoard map;
	
	
	public MapBuilder(){
		height = MapSize.SMALL.dimensionY();
		width = MapSize.SMALL.dimensionX();
		type = MapType.RANDOM;
		wrapX = false;
		wrapY = false;
		grid = new HexGrid();
	}
	
	/*public MapBuilder(String filename){
		
	}
	
	public MapBuilder(MapSize size, MapType type, boolean wrapping){
		
	}
	
	public MapBuilder(int width, int height, MapType type, boolean wrapping){
		
	}*/
	
	public MapBuilder wrapX(boolean b){
		wrapX = b;
		return this;
	}
	
	public MapBuilder wrapY(boolean b){
		wrapY = b;
		return this;
	}
	
	public MapBuilder height(int h){
		height = h;
		return this;
	}
	
	public MapBuilder width(int w){
		width = w;
		return this;
	}
	
	public MapBuilder grid(Grid g){
		grid = g;
		return this;
	}
	
	public MapBuilder forrested(double percent){
		return this;
	}
	
	public MapBuilder lava(double percent){
		return this;
	}
	
	public MapBoard build(){
		MapBoard map = new MapBoard(grid, height, width, wrapX, wrapY);
		createMap(map);
		return map;
	}

	protected void createMap(MapBoard map) {
		buildLand(map);
		createForest(map);
		placeResources(map);
		createStartLocations(map);
	}
	
	private void placeResources(MapBoard map){
		
	}
	
	private void createForest(MapBoard map){
		
	}
	
	private void buildLand(MapBoard map){
		ArcaneTile[] tiles = map.allTiles();
		Random rand = new Random();
		for (ArcaneTile t : tiles) {
			t.getTerrain().setElevation(Terrain.Elevation.values()[rand.nextInt(Terrain.Elevation.values().length)]);
		}
	}
	
	private void createStartLocations(MapBoard map){
		 
	}

}
