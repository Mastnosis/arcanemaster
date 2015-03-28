package arcanemaster.unit.combat;

public class Resistance {
	
	int[] resistances = new int[Element.values().length];
	
	public Resistance(){
		
	}
	
	public int getResistance(Element e){
		return resistances[e.ordinal()];
	}
	
	public void setResistance(Element e, int r){
		resistances[e.ordinal()]=r;
	}
	
	/*
	 * Return the damage modifier from armor.  In most cases this should reduce 
	 * damage taken.
	 */
	public double getMultiplier(Element e){
		return getMultiplier(getResistance(e));
	}
	
	/*
	 * Allow calculation of armor effect without specifying damage type
	 * It would be assumed that persons using this method would be keeping
	 * track of armor values and elements.
	 */
	public static double getMultiplier(int armor){
		return Math.pow(2,-(double)armor/50);
	}
	
	
	/*
	 * just testing to verify output values are correct.  Test should be moved to 
	 */
//	public static void main(String[] args){
//		Resistance res = new Resistance();
//		for(int i = -3; i < 10; i++){
//			//res.setResistance(Element.MELEE, i*25);
//			//System.out.print(res.getResistance(Element.MELEE) + ":  ");
//			System.out.println(i*25 + ":  " + Resistance.getMultiplier(i*25));
//			//System.out.println(Math.pow(2,-i/2));
//		}
//	}
		

}
