package arcanemaster;

import arcanemaster.unit.Race;

/**
 * @author icarus
 *
 * Wizard class represents the players persona. Things like picture, name
 * and starting wizard perks are represented in this class.
 */
public class Wizard {
	
	String name = "Player";  // this might be associated with Player instead
	Race startingrace;
	String picture;
	
	public Wizard(String name, Race race, String picture){
		this.name = name;
		startingrace = race;
		this.picture = picture;
	}

}
