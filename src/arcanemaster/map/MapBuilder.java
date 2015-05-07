package arcanemaster.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.HexGrid;

public class MapBuilder<T extends AmTile> {

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
	
	List<T> tiles = new ArrayList<>();
	
	
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
	
	public MapBuilder<T> wrapX(boolean b){
		wrapX = b;
		return this;
	}
	
	public MapBuilder<T> wrapY(boolean b){
		wrapY = b;
		return this;
	}
	
	public MapBuilder<T> height(int h){
		height = h;
		return this;
	}
	
	public MapBuilder<T> width(int w){
		width = w;
		return this;
	}
	
	public MapBuilder<T> mapType(MapType t){
		type = t;
		return this;
	}
	
	public MapBuilder<T> grid(Grid g){
		grid = g;
		return this;
	}
	
	public MapBuilder<T> forrested(double percent){
		return this;
	}
	
	public MapBuilder<T> lava(double percent){
		return this;
	}
	
	public MapBoard<T> build(){
		MapBoard<T> map = new MapBoard<>(tiles, grid, height, width, wrapX, wrapY);
		createMap(map);
		return map;
	}
	
	private List<T> createTiles(){
		ArrayList<T> tiles = new ArrayList<>(height*width);
		return tiles;
	}
	
	public MapBuilder<T> setTiles(List<T> tiles){
		this.tiles = tiles;
		return this;
	}

	protected void createMap(MapBoard<T> map) {
		buildLand(map);
		createForest(map);
		placeResources(map);
		createStartLocations(map);
	}
	
	private void placeResources(MapBoard<T> map){
		
	}
	
	private void createForest(MapBoard<T> map){
		
	}
	
	private void buildLand(MapBoard<T> map){
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
	
	private void buildRandomMap(MapBoard<T> map) {
		List<T> tiles = map.allTiles();
		Random rand = new Random();
		for (T t : tiles) {
			t.getTerrain().setElevation(Terrain.Elevation.values()[rand.nextInt(Terrain.Elevation.values().length)]);
		}
	}

	private void buildLandMassMap(MapBoard<T> map) {
		List<T> tiles = map.allTiles();

		for (T t : tiles) {
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

	private void buildLandLockedMap(MapBoard<T> map) {
		buildLandMassMap(map);
		
	}

	private void buildContinentalMap(MapBoard<T> map) {
		buildIslandMap(map);
		
	}

	private void buildIslandMap(MapBoard<T> map) {
		List<T> tiles = map.allTiles();
		
		for (T t : tiles) {
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

	private void createStartLocations(MapBoard<T> map){
		 
	}

}
