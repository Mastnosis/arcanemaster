package arcanemaster.api;

import arcanemaster.Game;

public class GameLoader {
	
	/*
	 * Load the saved game specified by @param filename.
	 */
	public void load(String filename) {}
	
	/*
	 * Return the number of players in the game.
	 */
	public int numPlayers() {
		return 0;
	}
	
	/*
	 * Set the listeners for the players.
	 */
	public void setListener(int playerIndex, GameListener listener) {}
	
	/*
	 * Before calling launch, the following actions must be performed. If they
	 * are not, an exception will be thrown.
	 * 1. load()
	 * 2. setListener() for each player
	 */
	public Game launch() {
		return new Game();
	}
}
