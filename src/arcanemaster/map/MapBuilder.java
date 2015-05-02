package arcanemaster.map;

import java.util.ArrayList;
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

	public enum MapType{ ISLAND, 		// predominately water map interspersed with islands
						CONTINENTAL, 	// large land masses separated by water
						LANDLOCKED, 	// predominately land map with some large bodies of water
						LANDMASS, 		// dominated by land with only small bodies of water
						RANDOM			// completely random terrain height
	};
	
//	protected MapSize size;
	protected MapType type;
	
	protected int height;
	protected int width;
	
	protected boolean wrapX;
	protected boolean wrapY;
	
	protected Grid grid;
	// protected MapBoard map;
	
	Random rand = new Random();
	
	
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
	
	public MapBuilder mapType(MapType t){
		type = t;
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
		switch(type){
		case ISLAND:
			buildIslandMap(map);
			break;
		case CONTINENTAL:
			buildContinentalMap(map);
			break;
		case LANDLOCKED:
			buildLandLockedMap(map);
			break;
		case LANDMASS:
			buildLandMassMap(map);
			break;
		case RANDOM:
			buildRandomMap(map);
			break;
		}
	}
	
	private void buildRandomMap(MapBoard map) {
		ArrayList<AmTile> tiles = map.allTiles();
		Random rand = new Random();
		for (AmTile t : tiles) {
			t.getTerrain().setElevation(Terrain.Elevation.values()[rand.nextInt(Terrain.Elevation.values().length)]);
		}
	}

	private void buildLandMassMap(MapBoard map) {
		ArrayList<AmTile> tiles = map.allTiles();

		for (AmTile t : tiles) {
			t.getTerrain().setElevation(Terrain.Elevation.WATER);
		}
		int cap = tiles.size()/5;
		for (int i = 0; i < cap; i++){
			int index = rand.nextInt(tiles.size());
			tiles.get(index).getTerrain().raise();
			for (AmTile t : map.getNeighbors(tiles.get(index))) {
				t.getTerrain().raise();
			}
		}

	}

	private void buildLandLockedMap(MapBoard map) {
		buildLandMassMap(map);
		
	}

	private void buildContinentalMap(MapBoard map) {
		buildIslandMap(map);
		
	}

	private void buildIslandMap(MapBoard map) {
		ArrayList<AmTile> tiles = map.allTiles();
		
		for (AmTile t : tiles) {
			t.getTerrain().setElevation(Terrain.Elevation.DEEP);
		}
		int cap = tiles.size()/4;
		for (int i = 0; i < cap; i++){
			int index = rand.nextInt(tiles.size());
			tiles.get(index).getTerrain().raise();
			map.getNeighbors(tiles.get(index)).stream().forEach(t -> t.getTerrain().raise());
//			for (AmTile t : map.getNeighbors(tiles[index])) {
//				t.getTerrain().raise();
//			}
		}
		
	}

	private void createStartLocations(MapBoard map){
		 
	}

}
