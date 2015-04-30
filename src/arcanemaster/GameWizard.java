package arcanemaster;

import java.io.Console;
import java.util.LinkedHashSet;
import java.util.Set;

import arcanemaster.map.Board;
import arcanemaster.player.Player;

public class GameWizard {
	
	public GameWizard(){
		
	}
	
	public void run(){
		createGame();
	}
	
	public void createGame(){
		Game game = new Game(createPlayers(), initializeMap(), setVictoryConditions());
		game.start();
	//	(new Thread(game)).start();
	}
	
	private Victory setVictoryConditions(){
		System.out.println("Setting Victory Conditions.");
		return new Victory();
	}
	
	private Set<Player> createPlayers(){
		
		Set<Player> plist = new LinkedHashSet<Player>();
		
		Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        
        int players = Integer.parseInt(c.readLine("Enter number of players: "));
        if (players > 0){
        	for (int i = 0; i < players; i++){
        		plist.add(new Player());
        		System.out.println("Creating player " + i);
        	}
        	return plist;
        }
        return null;
	}
	
	private Board initializeMap(){
		System.out.println("Initializing map board.");
		return new Board();
	}

}
