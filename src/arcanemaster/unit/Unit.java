package arcanemaster.unit;

import java.util.LinkedList;
import java.util.List;

import arcanemaster.map.Tile;
import arcanemaster.unit.combat.Attack;
import arcanemaster.unit.combat.CombatMod;
import arcanemaster.unit.combat.Combatant;
import arcanemaster.unit.combat.Resistance;


public class Unit implements Combatant, Moveable{
	
	int level = 1;  
	int experience = 0;
	int wounds = 0;
	
	Faction faction;
	Minion minion;
		
	
	List<Perk> perks = new LinkedList<Perk>();
	
	boolean fortified = false;  // TODO change to perk
	boolean sentried = false;	
	
	
	
	public Unit(Minion type, Faction faction){
		minion = type;
		this.faction = faction;
	}
	
	
	
	public int attack(Unit u){
		
		double damage = 0.0;
		//this.gainExp(u);
		//u.gainExp(this);
		
		return (int) Math.ceil(damage);
	}
	
	public void gainExp(int xp){
		
	}
	
	private Cost calculateUpkeep(){
		Cost currentupkeep = new Cost(minion.upkeep);
		for(Perk p: perks){
			currentupkeep.addCost(p.getUpkeep());
		}
		return currentupkeep;
	}
	
	private Attack calculateAttack(){
		return minion.getAttack();	// TODO modify by perks
	}
	
	private Resistance calculateResistance(){
		Resistance res = new Resistance();	// TODO modify res by perks
		return res;
	}
	
	public Cost upkeep(){
		return calculateUpkeep(); 
	}
	
	public Attack attack(){
		return calculateAttack();
	}
	
	public void fortify(){
					// TODO add perk with time limit of 1
	}
	
	public void sentry(){
		sentried = true;
	}
	
	public Faction faction(){
		return faction;
	}
	
	public Movement movement(){
		return minion.getMovement();	// TODO modify profession movement by perks
	}
	
	public Attack getAttack(){
		return minion.getAttack();		// TODO modify profession attack by perks
	}
	
	public Resistance getResistance(){
		return calculateResistance();
	}



	@Override
	public double costToEnter(Tile t, int previousCost) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double costToEnter(Tile t) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double costToTravel(List<Tile> trail) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double timeToTravel(List<Tile> trail) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getCurrentHealth(){
		return minion.hitpoints - wounds; 
	}
	
	public CombatMod getCombatModifier(){
		return null; //TODO return the combat modifiers for this unit
	}



	public void wound(int damage) {
		wounds += damage;
		if (getCurrentHealth() < 1){
			this.dies();
		}
	}
	
	private void dies(){
		
	}
	

	
}
