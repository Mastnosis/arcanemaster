package arcanemaster.client.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arcanemaster.api.GameCreator;
import arcanemaster.api.GameSettings;
import arcanemaster.api.PlayerCreator;
import arcanemaster.api.PlayerSettings;
import arcanemaster.client.LobbyClient;
import arcanemaster.client.LocalLobbyClient;

public class ClientCLI {
	public class FakeGameCLI {}
	
	private boolean running = true;
	private String prompt = "$ ";
	
	private LobbyClient lobbyClient = null;
	private PlayerCreator playerCreator = null;
	private GameCreator gameCreator = null;
	private FakeGameCLI game = null;
	
	private PlayerSettings playerSettings= new PlayerSettings(); // Default player settings.
	private GameSettings gameSettings = new GameSettings();      // Default game settings.
	
	public void playLocal() {
		lobbyClient = new LocalLobbyClient(playerSettings, gameSettings);
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public String getPrompt() {
		return prompt;
	}
	
	public String welcomeMessage() {
		return "Welcome to Arcane Master";
	}
	
	public void quit() {
		running = false;
	}
	
	public void launchPlayerCreator() {}

	public void parseInput(String input) {
		if (game != null) {
			
		}
		else if (gameCreator != null) {
			if (input.equals("done")) {
				System.out.print("Exiting game setup.");
				gameSettings = gameCreator.getSettings();
				gameCreator = null;
			}
			else {
				System.out.println("unknown command B: " + input);
			}
		}
		else if (playerCreator != null) {
			if (input.equals("done")) {
				System.out.println("Exiting player setup.");
				playerSettings = playerCreator.getSettings();
				playerCreator = null;
			}
			else {
				System.out.println("unknown command C: " + input);
			}
		}
		else if (input.equals("setup-player")) {
			playerCreator = new PlayerCreator(playerSettings);
		}
		else if (input.equals("setup-game")) {
			gameCreator = new GameCreator(gameSettings);
		}
		else if (lobbyClient != null) {
			if (input.equals("start")) {
				System.out.println("Starting game");
				System.out.println("...we thought, but we don't know how to do that yet.");
			}
			else {
				System.out.println("unknown command D: " + input);
			}
		}
		else {
			if (input.equals("local")) {
				System.out.println("Entering local lobby.");
				playLocal();
			}
			else if (input.equals("quit") || input.equals("exit") || input.equals("done")) {
				System.out.println("Leaving Arcane Master");
				quit();
			}
			else {
				System.out.println(String.format("unknown command A: '%s'", input));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		ClientCLI cli = new ClientCLI();
		
		System.out.println(cli.welcomeMessage());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (cli.isRunning()) {
			System.out.print(cli.getPrompt());
			String input = reader.readLine();
			cli.parseInput(input);
		}
	}
}
