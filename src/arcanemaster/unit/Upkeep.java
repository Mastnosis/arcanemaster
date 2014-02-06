package arcanemaster.unit;

public class Upkeep {
	
	int goldcost;
	int foodcost;
	int manacost;
	
	public Upkeep(int gold, int food, int mana){
		goldcost = gold;
		foodcost = food;
		manacost = mana;
	}
	
	public void addCost(Upkeep upkeep){
		goldcost += upkeep.getGoldUpkeep();
		foodcost += upkeep.getFoodUpkeep();
		manacost += upkeep.getManaUpkeep();
	}
	
	public void addCost(int gold, int food, int mana){
		addCost(new Upkeep(gold, food, mana));
	}
	
	public void changeBaseCost(int gold, int food, int mana){
		goldcost = gold;
		foodcost = food;
		manacost = mana;
	}
	
	public int getGoldUpkeep(){
		return goldcost;
	}
	
	public int getFoodUpkeep(){
		return foodcost;
	}
	
	public int getManaUpkeep(){
		return manacost;
	}

}
