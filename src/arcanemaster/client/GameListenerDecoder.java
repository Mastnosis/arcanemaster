package arcanemaster.client;

import arcanemaster.api.GameListener;

public class GameListenerDecoder {
	
	private GameListener listener = null;
	
	public GameListenerDecoder(GameListener listener) {
		this.listener = listener;
	}

	public void decodeMessage(String message) {
		listener.onTurnEnded(-1);
	}
}
