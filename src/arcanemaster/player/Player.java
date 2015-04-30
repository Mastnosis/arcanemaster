package arcanemaster.player;

import java.awt.Color;
import java.util.LinkedHashSet;

import arcanemaster.city.Building;
import arcanemaster.city.City;
import arcanemaster.map.ArcaneTile;
import arcanemaster.map.Location;
import arcanemaster.unit.Race;
import arcanemaster.unit.Unit;
import arcanemaster.unit.UnitType;

/**
 * @author icarus
 * 
 * Player class wraps all communication and objects for the different players.
 *
 */
public class Player {
	
	/*
	 * below are three tile sets.  
	 * 
	 * Explored - remembers the map so far uncovered by the player.  Really only needed for reloading game
	 * 
	 * Vision includes all the tiles that the player can currently see and will be updated on any 
	 * events in this area.
	 */
	LinkedHashSet<ArcaneTile> explored = new LinkedHashSet<ArcaneTile>();  //TODO ensure player can only get updates about known information.  Might need to clone into this list
	LinkedHashSet<ArcaneTile> vision = new LinkedHashSet<ArcaneTile>();
	LinkedHashSet<ArcaneTile> territory = new LinkedHashSet<ArcaneTile>(); //TODO probably can just be generated by querying city locations
	
	LinkedHashSet<Unit> units = new LinkedHashSet<Unit>();
	LinkedHashSet<City> cities = new LinkedHashSet<City>();
	
	private static int number = 0;
	private int ID;
	
	private String playername;
	protected Color playercolor;
	protected Race playerrace;
	
	public Player(){
		this("Player", Color.BLACK);
	}
	
	public Player(String name, Color color){
		ID = number++;
		setName(name);
		playercolor = color;
	}
	
	public void setRace(Race race){
		playerrace = race;
	}
	
	public int getID(){
		return ID;
	}
	
	public void doTurn(){
		System.out.println(getName() + " is completeing turn.");
		
	}
	
	public void notify(String message){
		
	}
	
	public void doCommand(String command){
		
	}
	
	public boolean move(Unit u, ArcaneTile location){  // perhaps change return type to last tile entered
		return false;
		
	}
	
	public boolean move(Unit u, ArcaneTile[] path){  // perhaps change return type to last tile entered
		return false;
	}
	
	public boolean recruit(City c, UnitType t){
		if(c.canRecruit(t)){
			c.recruit(t);
			return true;
		}
		return false;
	}
	
	public boolean build(City c, Building b, ArcaneTile location){
		if(c.canBuild(b, location)){
			c.build(b, location);
		}
		return false;
	}

	public String getName() {
		return playername;
	}

	public void setName(String playername) {
		this.playername = playername;
	}

}