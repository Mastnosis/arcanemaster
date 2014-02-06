package arcanemaster.unit.combat;

public class Attack {
	
	public enum elements { MELEE, MISSILE, LIFE, DEATH, SPIRIT, ELEMENTAL };
	
	
	int basedamage = 0;
	int range = 1;
	
	
	
	public Attack(){
		
	}
	
	public Attack(int dmg){
		basedamage = dmg;
		range = 1;
	}
	
	public Attack(int dmg, int range){
		basedamage = dmg;
		this.range = range;
	}

}
