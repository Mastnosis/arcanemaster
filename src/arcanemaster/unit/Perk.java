package arcanemaster.unit;

import java.util.*;

public class Perk {
	
	LinkedList<Perk> subPerks = new LinkedList<Perk>(); //perk can be built up from multiple simpler perks
	
	Unit unit;
	
	Upkeep upkeep = new Upkeep(0,0,0);
	
	public Perk(){
		this(null);
	}
	
	public Perk(Unit u){
		unit = u;
	}
	
	public void addPerk(Unit u){
		
	}
	
	public void removePerk(Unit u){
		
	}
	
	public void setUpkeep(Upkeep upkeep){
		this.upkeep = upkeep;
	}
	
	public Upkeep getUpkeep(){
		return upkeep;
	}

}
