package arcanemaster.unit.combat;

public class CombatMod {
	
	double mattacker = 1.0;
	double mdefender = 1.0;
	
	String name = "Default";
	
	public CombatMod(String mod_name, double attacker, double defender){
		name = mod_name;
		mattacker = attacker;
		mdefender = defender;
	}
	
	
	public double getAttackerMod(){
		return mattacker;
	}
	
	public double getDefenderMod(){
		return mdefender;
	}
	
	public String getModifierName(){
		return name;
	}

}
