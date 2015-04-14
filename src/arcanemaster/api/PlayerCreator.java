package arcanemaster.api;

public class PlayerCreator {
	private PlayerSettings settings = new PlayerSettings();

	public PlayerCreator() {}
	public PlayerCreator(PlayerSettings settings) {
		this.settings = settings;
	}
	
	public PlayerSettings getSettings() {
		return settings;
	}
}
