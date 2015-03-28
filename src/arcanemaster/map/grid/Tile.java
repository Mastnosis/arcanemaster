package arcanemaster.map.grid;


public class Tile {
	

	protected GridCoordinate location;
	protected Grid grid;
	
		
	public Tile(Grid g, GridCoordinate gc){
		grid = g;
		location = gc;
	}
	
	public Tile(int x, int y) {
		location = new GridCoordinate(x,y);
	}

	
	public GridCoordinate location(){
		return location;
	}
	
}
