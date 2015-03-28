package arcanemaster.map.grid;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import arcanemaster.map.ArcaneTile;

/**
 * Creates a map board that holds references to all the tiles.
 * 
 * @author icarus
 *
 */
@Deprecated
public class HexMap {
	
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
	
	public HexMap(){
		this(10, 10);
	}
	
	public HexMap(int sizeX, int sizeY){
		this(sizeX, sizeY, false, false);
	}
	
	public HexMap(Size size){
		this(size.x, size.y);
	}
	
	public HexMap(int sizeX, int sizeY, boolean wrapsX, boolean wrapsY){
		width = sizeX;
		height = sizeY;
		this.wrapsX = wrapsX;
		this.wrapsY = wrapsY;
		
		tiles = new ArrayList<>(height*width);
		initTiles();
	}
	
	private void initTiles() {
		for(int i = 0; i < height*width; i++){
			for(int j = 0;j < width; j++){
				int offset = 0;
				tiles.add(offset, new Tile(i, j));
			}
		}
		
	}

	public Tile getTile(GridCoordinate c){
		return null;
	}
	
	public int range(Tile t1, Tile t2){
		return grid.range(t1.location(), t2.location());
	}
	
	
	
	
	
	public static void main(String[] args){
		
	}
	
//	public List<Tile> calculateShortestPath(Moveable unit, Coordinate start, Coordinate destination){
//	Set<Coordinate> path = new LinkedHashSet<Coordinate>();
//	Map<Coordinate, Integer> values = new HashMap<Coordinate, Integer>();
//	values.put(start, 0);
//	return new LinkedList<Tile>(path);
//}

}
