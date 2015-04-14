package arcanemaster.client;

import arcanemaster.api.GameSettings;
import arcanemaster.api.PlayerSettings;

public interface LobbyClient {
	public class GameList {}
	public class PlayerList {}
	
	GameList listGames();
	
	void create();
	void join(int gameId);
	PlayerList listPlayers(int gameId);
	GameSettings requestSettings(int gameId);

	PlayerSettings launchPlayerCreator();
	void setPlayerSetting(PlayerSettings settings);
	
	void setReady();
	void startGame();
	void sendMessage(String msg);

}
