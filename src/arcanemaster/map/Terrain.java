package arcanemaster.map;

import arcanemaster.map.Terrain.Elevation;

public class Terrain {
	
	// Features affect movement and combat
	public enum Feature { FOREST, NONE };
	
	// Elevation affects movement and combat
	public enum Elevation { DEEP, WATER, PLAINS, HILLS, MOUNTAINS, HIGH };
	
	// Climate affects resource production, movement and has possible additional effects such as damage or healing certain units
	public enum Climate { FERTILE, BARREN, DESERT, ARCTIC, SWAMP, LAVA, DEATH, CORRUPTED, FEY };
	
	// Weather is just a concept. Weather may change climate over time and affect combat and movement
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


	public void setElevation(Elevation e) {
		elevation = e;
	}
	
	public Elevation getElevation(){
		return elevation;
	}

}
