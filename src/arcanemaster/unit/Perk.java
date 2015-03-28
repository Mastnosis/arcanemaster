package arcanemaster.unit;

import java.util.*;

public class Perk {
	
	public enum Source{ BASE, LEVEL, SPELL, AURA};
	
	String name;
	
	Source source;
	
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
	
	public Source getSource(){
		return source;
	}

}
