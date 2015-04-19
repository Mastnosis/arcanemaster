package arcanemaster.map;

public enum Resource { NONE(Availability.UNAVAILABLE), IRON(Availability.COMMON), SILVER(Availability.COMMON), GOLD(Availability.UNCOMMON), 
	GEMS(Availability.RARE), ADAMANTIUM(Availability.RARE), NEVERIL(Availability.RARE), ELVEN_VILLAGE(Availability.UNCOMMON), 
	DWARF_VILLAGE(Availability.UNCOMMON), INFERNAL_RIFT(Availability.RARE), MAGIC_FIELD(Availability.UNCOMMON), HOLY_GROUND(Availability.UNCOMMON), 
	KOATL_VILLAGE(Availability.RARE), HALBERDHALL(Availability.UNCOMMON), MINOTAUR_CAVES(Availability.UNCOMMON), DONKEYS(Availability.UNCOMMON), 
	ANCIENT_RUINS(Availability.UNCOMMON), MAGIC_NODE(Availability.UNCOMMON);

	public enum Availability { UNAVAILABLE, COMMON, UNCOMMON, RARE, UNIQUE;
		// private static final int 
		}
	
	private Availability availability;
	
	private Resource(Availability a){
		availability = a;
	}
	
	public Availability availability(){
		return availability;
	}

}
