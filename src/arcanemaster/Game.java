package arcanemaster;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import arcanemaster.map.Board;
import arcanemaster.player.Player;

public class Game {

	protected int numberofplayers;

	LinkedHashSet <Player> players = new LinkedHashSet<Player>();

	Board board;

	Victory victory;

	public Game(){
		board = new Board();
		victory = new Victory();
		players.add(new Player("player1", Color.BLUE));
		players.add(new Player("player2", Color.RED));
	}

	public Game(Collection<? extends Player> players, Board board, Victory victory){
		this.players.addAll(players);
		this.board = board;
		this.victory = victory;
	}

	//	public Game(int totalplayers){
	//		this();
	//		numberofplayers = totalplayers;
	//	}

	public void gameloop(){
		while(true){
			for(Player p: players){
				p.doTurn();
				victory.checkAll();
				System.out.println(p.getName() + " is done their turn.");
			}
		}

	}

	public void initGame(){
		System.out.println("Initializing play.");
		for(Player p: players){
			setStartPoint(p);
		}

	}

	private void setStartPoint(Player p) {
		// TODO Auto-generated method stub

	}

	public void start(){

	}
	
	public void end(){
		
	}

	public void add(Player p){  // is this a good idea? can it be done after game has started?
		players.add(p);
	}

	public void joinGame(Player player){  
		players.add(player);  //TODO check added player does not exceed the maximum number of players
	}



}
