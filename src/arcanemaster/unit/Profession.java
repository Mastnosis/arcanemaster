package arcanemaster.unit;

import arcanemaster.unit.combat.Attack;

public class Profession {
	
	public enum type { settler, melee, missile, caster, healer, monster, construct, ship, fortification }
	
	int hitpoints;
	int power;
	int sightrange;
	Movement movement;
	
	Upkeep upkeep;
	Attack attack;
	Race race;
	
	Perk[] perks;
	
	String description;		// "Game info"
	String lore;			// "Lore info"
	public Attack getAttack() {
		return attack;
	}
	public Movement getMovement() {
		return movement;
	}

}
