package arcanemaster.unit;

public class Cost { 			// TODO change to ResourceCost (allows for Upkeep and Recruitment cost)
	
	public enum Resource { GOLD, FOOD, MANA }  // possibly rework class to work with arbitrary list of resources
	
	int goldcost;
	int foodcost;
	int manacost;
	
	public Cost(){
		this(0,0,0);
	}
	
	public Cost(int gold, int food, int mana){
		goldcost = gold;
		foodcost = food;
		manacost = mana;
	}
	
	public Cost(Cost cost){
		goldcost = cost.gold();
		foodcost = cost.food();
		manacost = cost.mana();
	}
	
	public void addCost(Cost cost){
		goldcost += cost.gold();
		foodcost += cost.food();
		manacost += cost.mana();
	}
	
	public void addCost(int gold, int food, int mana){
		addCost(new Cost(gold, food, mana));
	}
	
	public void setBaseCost(int gold, int food, int mana){
		goldcost = gold;
		foodcost = food;
		manacost = mana;
	}
	
	public int gold(){
		return goldcost;
	}
	
	public int food(){
		return foodcost;
	}
	
	public int mana(){
		return manacost;
	}

}
