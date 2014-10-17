package arcanemaster.unit.combat;

public interface Combatant {
	
	public Attack getAttack();
	public Resistance getResistance();
	public void wound(int damage);

}
