package arcanemaster;

import java.util.LinkedHashSet;

public class Game {
	
	protected int numberofplayers;
	
	LinkedHashSet <Player> players;
	
	public Game(){
		
	}
	
	public Game(int totalplayers){
		numberofplayers = totalplayers;
		players = new LinkedHashSet<Player>(numberofplayers);
	}
	
	public void gameloop(){
		for(Player p: players){
			p.doTurn();
		}
		
	}
	
	public void initGame(){
		
	}
	
	public void startGame(){
		
	}
	
	public void joinGame(Player player){  
		players.add(player);  //TODO check added player does not exceed the maximum number of players
	}

}
