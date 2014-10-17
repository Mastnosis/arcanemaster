package arcanemaster.unit;

import java.util.HashMap;
import java.util.Map;

public class PerkTable {
	
	Map <String, Perk> perks = new HashMap<String, Perk>();
	
	public void addPerk(Perk p){  // TODO throw exception if item exists
		perks.put(p.getName(), p);
	}
	
	public Perk get(String perkname){
		return perks.get(perkname);
	}

}
