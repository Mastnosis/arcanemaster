package arcanemaster.unit;

import java.util.LinkedList;
import java.util.List;

import arcanemaster.unit.combat.Attack;
import arcanemaster.unit.combat.Resistance;

/**
 * @author icarus
 *
 */
public abstract class Unit {
	
	public enum unitclass { melee, missile, caster, support, monster, construct, ship, fortification };
	
	int basehealth, currenthealth;
	int basemove = 3;
	int basesight = 2;
	int level = 1;  // start at 0?
	
	
	Faction faction;
	Movement movement;
	Attack attack;
	Resistance resistance;
	Upkeep upkeep;
	
	int experience = 0;
	String name, classification, description;
	List<Perk> perks = new LinkedList<Perk>();
	
	boolean fortified = false;  // change to perk?
	boolean sentried = false;	// change to perk?
	
	
	
	public Unit(){
		this(0, 0);
	}
	
	public Unit(int health, int attack){
		currenthealth = basehealth = health;
		this.attack = new Attack(attack);
		currenthealth = this.basehealth;
		currentupkeep = baseupkeep = new Upkeep(0,0,0);
	}
	
	
	
	public int attack(Unit u){
		
		double damage = 0.0;
		
		return (int) Math.ceil(damage);
	}
	
	public void levelUp(){
		
	}
	
	private Upkeep calculateUpkeep(){
		Upkeep currentupkeep = baseupkeep;
		for(Perk p: perks){
			currentupkeep.addCost(p.getUpkeep());
		}
		return currentupkeep;
	}
	
	public Upkeep getUpkeep(){
		return calculateUpkeep();  //TODO add Perk upkeep costs
	}
	
	public void fortify(){
		fortified = true;
	}
	
	public void sentry(){
		sentried = true;
	}
	
	public Faction getFaction(){
		return faction;
	}
	
	public Movement getMovement(){
		return movement;
	}
	
	public Attack getAttack(){
		return attack;
	}
	
	public Resistance getResistance(){
		return resistance;
	}
	
	
}
