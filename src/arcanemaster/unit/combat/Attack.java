package arcanemaster.unit.combat;

public class Attack {
	
	// public enum elements { MELEE, MISSILE, LIFE, DEATH, SPIRIT, ELEMENTAL };
	
	
	int basedamage = 0;
	int range = 1;
	
	double[] modifiers;
	
	public Attack(){
		modifiers = new double[Element.values().length];
		for(int i = 0; i < modifiers.length; i++){
			modifiers[i] = 0.0;
		}
	}
	
	public Attack(int dmg){
		this();
		basedamage = dmg;
	}
	
	public Attack(int dmg, int range){
		this();
		basedamage = dmg;
		this.range = range;
	}
	
	public double getElementMod(Element element){
		return modifiers[element.ordinal()];
	}
	
	public void setElementMod(Element e, double d){
		modifiers[e.ordinal()] = d;
	}
	
	public void addElementMod(Element e, double d){
		modifiers[e.ordinal()] += d;
	}

}
