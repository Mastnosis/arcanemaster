package arcanemaster.unit;

import java.util.*;

public class Perk {
	
	public enum source{ BASE, LEVEL, SPELL};
	
	String name;
	
	LinkedList<Trait> traits = new LinkedList<Trait>();
	
	Cost upkeep = new Cost(0,0,0);
	
	public Perk(){
		
	}
	
	public void setUpkeep(Cost upkeep){
		this.upkeep = upkeep;
	}
	
	public Cost getUpkeep(){
		return upkeep;
	}
	
	public String getName(){
		return name;
	}

}
