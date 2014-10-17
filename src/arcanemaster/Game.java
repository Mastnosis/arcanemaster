package arcanemaster;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import arcanemaster.map.Board;

public class Game implements Runnable{
	
	protected int numberofplayers;
	
	Set <Player> players = new LinkedHashSet<Player>();
	
	Board board;
	
	Victory victory;
	
	public Game(){
		board = new Board();
		victory = new Victory();
	}
	
	public Game(Collection<? extends Player> players, Board board, Victory victory){
		this.players.addAll(players);
		this.board = board;
		this.victory = victory;
	}
	
	public Game(int totalplayers){
		numberofplayers = totalplayers;
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
	
	public void add(Player p){
		players.add(p);
	}
	
	public void joinGame(Player player){  
		players.add(player);  //TODO check added player does not exceed the maximum number of players
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
