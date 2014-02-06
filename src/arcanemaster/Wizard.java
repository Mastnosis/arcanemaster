package arcanemaster;

import arcanemaster.unit.Race;

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
