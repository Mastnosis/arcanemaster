package arcanemaster.unit;

import arcanemaster.map.Tile;

public class Movement {
	
	int basemove, consumed;
	
	
	public Movement(){
		this(0);
	}
	
	public Movement(int movementspeed){
		basemove = movementspeed;
		consumed = 0;
	}
	
	public int getMovementPerTurn(){
		int perks = 0;
		return basemove + perks;
	}
	
	public int getRemainingMove(){
		return getMovementPerTurn() - consumed;
	}
	
	public void turnRefresh(){
		consumed = 0;
	}
	
	public int costToEnterHex(Tile t){
		return 1;
	}

}
