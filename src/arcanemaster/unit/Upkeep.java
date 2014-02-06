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
	
	public Upkeep(Upkeep upkeep){
		goldcost = upkeep.goldCost();
		foodcost = upkeep.foodCost();
		manacost = upkeep.manaCost();
	}
	
	public void addCost(Upkeep upkeep){
		goldcost += upkeep.goldCost();
		foodcost += upkeep.foodCost();
		manacost += upkeep.manaCost();
	}
	
	public void addCost(int gold, int food, int mana){
		addCost(new Upkeep(gold, food, mana));
	}
	
	public void changeBaseCost(int gold, int food, int mana){
		goldcost = gold;
		foodcost = food;
		manacost = mana;
	}
	
	public int goldCost(){
		return goldcost;
	}
	
	public int foodCost(){
		return foodcost;
	}
	
	public int manaCost(){
		return manacost;
	}

}
