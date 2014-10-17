package arcanemaster.unit;

import java.util.List;

import arcanemaster.map.Tile;

public class Hero extends Unit {
	
	public Hero(Minion myclass, Faction faction) {
		super(myclass, faction);
		// TODO Auto-generated constructor stub
	}

	Artifact[] equipment = new Artifact[3];

	@Override
	public double costToEnter(Tile t, int previousCost) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costToEnter(Tile t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costToTravel(List<Tile> trail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double timeToTravel(List<Tile> trail) {
		// TODO Auto-generated method stub
		return 0;
	}


}
