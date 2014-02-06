package arcanemaster.city;

import arcanemaster.unit.combat.Attack;

public class Fortification {
	
	Attack attack;
	int maxhealth;
	int currenthealth;
	int sightrange;
	String name;
	
	public Fortification(){
		this("Fort", 50, 3, new Attack(12, 2));
	}
	
	public Fortification(String name, int health, int sight, Attack attack){
		maxhealth = health;
		currenthealth = maxhealth;
		sightrange = sight;
		this.attack = attack;
	}

}
