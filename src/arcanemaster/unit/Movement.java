package arcanemaster.unit;

import arcanemaster.map.ArcaneTile;

public class Movement {
	
	int basemove, consumed;
	
	
	public Movement(){
		this(3);
	}
	
	public Movement(int movementspeed){
		basemove = movementspeed;
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
	
	public int costToEnterHex(ArcaneTile t){
		return 1;
	}

}
