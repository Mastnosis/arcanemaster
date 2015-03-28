package arcanemaster.map;

public class Terrain {
	
	public enum Feature { FOREST, SWAMP, NONE };
	
	public enum Elevation { DEEP, WATER, PLAINS, HILLS, MOUNTAINS, HIGH };
	
	public enum Climate { FERTILE, BARREN, DESERT, ARCTIC, LAVA, DEATH, CORRUPTED, FEY };
	
	public enum Weather { CLEAR, HUMID, DRY, RAIN, MONSOON, HOT, COLD, SNOWING, HAIL, BLIZZARD, CALM, WINDY, TYPHOON };
	
	
	protected Feature covering;
	protected Elevation elevation;
	protected Climate climate;
	
	protected boolean canBuild;
	
	public Terrain(){
		this(Feature.NONE, Elevation.PLAINS, Climate.FERTILE);
	}
	
	
	public Terrain(Feature feature, Elevation elevation, Climate climate) {
		this.covering = feature;
		this.elevation = elevation;
		this.climate = climate;
	}


	/*
	 * Lower the elevation
	 */
	public void lower(){
		int height = elevation.ordinal();
		height--;
		if (height < 0){
			height = 0;
		}
		elevation = Elevation.values()[height];
	}
	
	/*
	 * Raise the elevation
	 */
	public void raise(){
		int height = elevation.ordinal();
		height++;
		if (height >= Elevation.values().length){
			height = Elevation.values().length -1;
		}
		elevation = Elevation.values()[height];
	}
	
	public void changeClimate(Climate climate){
		this.climate = climate;
	}
	
	public boolean canBuild(){
		return canBuild;
	}

}
