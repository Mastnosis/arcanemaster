package arcanemaster.api;


/*
 * GameCreator is for creating new games. By setting the various world and game
 * parameters, and then calling launch, a new map will be generated, with the
 * specified players seeded onto it.
 */
public class GameCreator {
	private GameSettings settings = new GameSettings();

	public GameCreator() {}
	public GameCreator(GameSettings settings) {
		this.settings = settings;
	}
	
	public enum WorldType {}
	public enum WorldSize {}
	public enum WorldShape {}
	public enum Difficulty {}
	
	public void addPlayer(PlayerSettings player, GameListener listener) {}
	
	public void difficulty(Difficulty diff) {}
	public void worldType(WorldType type) {}
	public void worldSize(WorldSize size) {}
	public void worldShape(WorldShape shape) {}
	public void numPortals(int num) {}

	public GameSettings getSettings() {
		return settings;
	}
}
