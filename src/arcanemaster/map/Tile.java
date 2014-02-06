package arcanemaster.map;

import java.util.Set;

import arcanemaster.city.Building;
import arcanemaster.city.Structure;
import arcanemaster.unit.Movement;
import arcanemaster.unit.Unit;

public class Tile {
	
	Terrain terrain;
	Resource resource;
	Structure structure;
	Unit unit;
	
	
	public Tile(){
		this(new Terrain());
	}
	
	public Tile(Terrain terrain){
		this(terrain, null);
	}
	
	public Tile(Terrain terrain, Resource resource){
		
	}
	
	public Set<Tile> getNeighbors(){
		return null;
	}
	
	public int costToEnter(Unit u){
		return 1;  //TODO calculate cost for unit to enter tile based on terrain, buildings, units and perks
	}
	
	public int costToEnter(Movement move){
		return 1;
	}
	
	public boolean canEnter(){
		if(isOccupied()){
			return false;
		}
		return true;
	}
	
	public boolean canPassThrough(Unit u){
		if(unit.faction().isFriend(u)){
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(){
		if (null == unit){
			return false;
		}
		return true;
	}
	
	public boolean canBuild(Building b){
		return false;
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public void enter(Unit u){
		
	}
	
	public void onEnter(Unit u){
		
	}
	
	public void onExit(Unit u){
		
	}

}
