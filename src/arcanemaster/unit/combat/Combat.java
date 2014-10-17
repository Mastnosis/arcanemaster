package arcanemaster.unit.combat;

import arcanemaster.unit.Unit;

public class Combat {
	
	
	private static int strike(Attack atk, Resistance res){
		int damage = 0;
		for(int i = 0; i < Element.values().length; i++){
			//damage += atk.getElementMod(Element.values()[i])*
		}
		return damage;
	}
	
	public static int strike(int atkpower, double element, int resistance){
		return (int) Math.floor(atkpower*element*armorMultiplier(resistance));
	}
	
	public static void ranged(Combatant attacker, Combatant defender){
		defender.wound(strike(attacker.getAttack(), defender.getResistance()));
	}
	
	public static void melee(Unit attacker, Unit defender){
		//return 0;
	}
	
	/*
	 * return a damage multiplier based on armor resistance
	 * Positive values will multiply by less than 1 and negative
	 * values will increase damage taken.
	 */
	public static double armorMultiplier(int armor){
		return Math.pow(2,-(double)armor/50);
	}

}
