package arcanemaster.client.cli;

import arcanemaster.api.ActionAPI;
import arcanemaster.api.GameListener;


public class GameClientCLI implements GameListener {

	public class GameDataFake {}
	
	private GameDataFake game = null;
	private ActionAPI api = null;

	public GameClientCLI(ActionAPI api) {
		this.api = api;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// User input methods
	
	public void parseInput(String input) {
		
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// GameListener methods

	public void onInitializeGame(String data) {
		
	}

    public void onCombat() {

    }

    public void onItemReclaimed(int playerId, int itemId) {

    }

    public void onItemUnequipped(int playerId, int heroId, int slot) {

    }

    public void onItemEquipped(int playerId, int heroId, int slot, int itemId) {

    }

    public void onHeroHired(int playerId, int heroId) {

    }

    public void onHeroDismissed(int playerId, int heroId) {

    }

    public void onOfferSent(int fromPlayerId, int toPlayerId /* content */) {

    }

    public void onResearchSet(int playerId, int spellId) {

    }

    public void onSpellPrepared(int playerId, int spellId) {

    }

    public void onSpellCancelled(int playerId) {

    }

    public void onSpellCast(int playerId, int spellId /* target info */) {

    }

    public void onCityDestroyed(int playerId, int cityId) {

    }

    public void onBuildingDestroyed(int playerId, int buildingId) {

    }

    public void onBuildingEnqueued(int playerId, int cityId, int buildingId, int row, int col) {

    }

    public void onUnitEnqueued(int playerId, int cityId, int uniint) {

    }

    public void onBuildingDequeued(int playerId, int cityId) {

    }

    public void onUnitDequeued(int playerId, int cityId, int queueIndex) {

    }

    public void onUnitAction(int playerId, int unitId, int actionId /* target info */) {

    }

    public void onUnitMoved(int playerId, int unitId, int row, int col, int shard) {

    }

    public void onTurnEnded(int playerId) {

    }
}
