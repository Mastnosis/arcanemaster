package arcanemaster.unit;

import arcanemaster.unit.combat.Attack;

public class Minion {
	
	public enum Type { SETTLER, MELEE, MISSILE, CASTER, HEALER, MONSTER, CONSTRUCT, SHIP, FORTIFICATION }
	
	String name;
	int hitpoints;
	int power;
	int sightrange;
	Movement movement;
	
	Cost upkeep;
	Attack attack;
	Race race;
	
	Perk[] perks;
	
	String description;		// "Game info"
	String lore;			// "Lore info"
	
	public Minion(String name, int hp, int cost, int sight, Cost upkeep, Attack atk, Race race, String desc, String lore){
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

}
