package arcanemaster.unit;

/**
 * Aura is any area affect ability around a unit that triggers when another unit enters within range (usually adjacent)
 * These can be buffs and debuffs and can affect the caster as well as friendly or enemy units.
 *
 * Auras will have to be registered with the tiles they affect and a check for each unit that enters or
 * leaves.
 * 
 * Aura's should only have an immediate effect (combat buff/debuff) or something that happens at one point 
 * (beginning/end) of the turn while the aura is in effect.  Aura's should not have stat (health, speed) 
 * modifiers or duration effects.
 * 
 * As an example an aura could modify the cost of movement while in the aura (provide pathfinding or 
 * increased movement cost of terrain) but should not affect a stat like total movement points or health as this
 * changes behavior even once the aura is removed creating an assortment of undesirable side effects.
 */
public class Aura {  
	
	public enum Target{ ENEMY, FRIENDLY, ALL, SELF} // TODO probably should me moved to more generic Targeting class
	
	boolean stackable = false;
	
	Target affected = Target.SELF;
	
	int radius = 1;
	
	/*
	 * while having an Aura is itself a perk, the effect of the aura on surrounding units is also a perk
	 * to be applied to units in its area of effect.
	 */
	Perk effect;
	
	public Aura(){
		
	}
	
	public Aura(int radius, Perk effect, Target affected){
		this.radius = radius;
		this.effect = effect;
		this.affected = affected;
	}
	
	

}
