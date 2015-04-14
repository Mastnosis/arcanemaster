package arcanemaster.client;

import arcanemaster.api.GameSettings;
import arcanemaster.api.PlayerSettings;
import arcanemaster.client.LobbyClient.GameList;
import arcanemaster.client.LobbyClient.PlayerList;


public class LocalLobbyClient implements LobbyClient {
	private PlayerSettings playerSettings = null;
	private GameSettings gameSettings = null;
	
	public LocalLobbyClient(PlayerSettings playerSettings, GameSettings gameSettings) {
		this.playerSettings = playerSettings;
		this.gameSettings = gameSettings;
	}
	
	/*
	 * @return A list of the local saved games.
	 * @see arcanemaster.client.LobbyClient#listGames()
	 */
	public GameList listGames() {
		return new GameList();
	}
	
	public void create() {
		
	}
	
	/*
	 * Select an existing saved game, and display its data.
	 * @see arcanemaster.client.LobbyClient#join(int)
	 */
	public void join(int gameId) {
		// Get the game settings.
		// Display the game settings.
		// Get the player list.
		// Get the player settings.
		// Display the player settings.
	}
	
	public PlayerList listPlayers(int gameId) {
		return new PlayerList();
	}
	
	public GameSettings requestSettings(int gameId) {
		return new GameSettings();
	}

	public PlayerSettings launchPlayerCreator() {
		return new PlayerSettings();
	}
	
	public void setPlayerSetting(PlayerSettings settings) {
		
	}
	
	/*
	 * Setting the player as ready has no effect in a local lobby.
	 * @see arcanemaster.client.LobbyClient#setReady()
	 */
	public void setReady() {
		// Do nothing.
	}
	
	public void startGame() {
		setReady();
		// start the game.
	}
	
	public void sendMessage(String msg) {
		
	}
};
