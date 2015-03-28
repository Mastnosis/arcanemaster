package arcanemaster.map.grid;


public class Tile {
	

	protected GridCoordinate location;
	protected Grid grid;
	
	
	public Tile(){
		
	}
	
	@Deprecated
	public Tile(Grid g, GridCoordinate gc){
		grid = g;
		location = gc;
	}
	
	@Deprecated
	public Tile(int x, int y) {
		location = new GridCoordinate(x,y);
	}

	@Deprecated
	public GridCoordinate location(){
		return location;
	}
	
}
