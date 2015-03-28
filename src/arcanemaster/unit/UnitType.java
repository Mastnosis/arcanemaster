package arcanemaster.unit;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import arcanemaster.unit.combat.Attack;

@Root
public class UnitType {
	
	public enum Class { SETTLER, MELEE, MISSILE, CASTER, HEALER, MONSTER, CONSTRUCT, SHIP, FORTIFICATION }
	
	@Attribute
	String name;
	@Attribute
	int hitpoints;
	
	@Attribute(name="sight")
	int sightrange;
	
	@Element
	Movement movement;
	
	@Element
	Cost upkeep;
	
	@Element
	Cost build;
	
	@Attribute
	int turns;
	
	@Element
	Attack attack;
	
	@Attribute
	Race race;
	
	Perk[] perks;
		
	String description;		// "Game info"
	String lore;			// "Lore info"
	
	public UnitType(String name, int hp, int cost, int sight, Cost upkeep, Attack atk, Race race, String desc, String lore){
		this.name = name;
		hitpoints = hp;
		sightrange = sight;
		this.upkeep = upkeep;
		attack = atk;
		this.race = race;
		description = desc;
		this.lore = lore;
	}
	
	public Attack getAttack() {
		return attack;
	}
	public Movement getMovement() {
		return movement;
	}
	
	public Cost getBuildCost(){
		return build;
	}
	
	public int getBuildTime(){
		return turns;
	}

}
