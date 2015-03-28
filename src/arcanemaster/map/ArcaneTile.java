package arcanemaster.map;

import java.util.HashSet;
import java.util.Set;

import arcanemaster.city.Building;
import arcanemaster.city.Structure;
import arcanemaster.map.grid.Tile;
import arcanemaster.unit.Aura;
import arcanemaster.unit.Movement;
import arcanemaster.unit.Unit;

public class ArcaneTile extends Tile{
	
	Terrain terrain;
	Resource resource;
	Structure structure;
	Unit unit;
	
	Set<Aura> auri = new HashSet<Aura>();
	
	
	public ArcaneTile(){
		this(new Terrain());
	}
	
	public ArcaneTile(Terrain terrain){
		this(terrain, Resource.NONE);
	}
	
	public ArcaneTile(Terrain terrain, Resource resource){
		this.terrain = terrain;
		this.resource = resource;
		structure = null;
		unit = null;
	}
	
	public Set<ArcaneTile> getNeighbors(){
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
	
	public void registerAura(Aura aura){
		auri.add(aura);
	}
	
	public void removeAura(Aura aura){
		auri.remove(aura);
	}

}
