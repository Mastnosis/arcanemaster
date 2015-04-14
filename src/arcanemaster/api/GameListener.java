package arcanemaster.api;

public interface GameListener {

    ////////////////////////////////////////////////////////////////////////////////
    // Non-API related callbacks.

    void onCombat();


    ////////////////////////////////////////////////////////////////////////////////
    // Direct API callbacks

    void onItemReclaimed(int playerId, int itemId);
    void onItemUnequipped(int playerId, int heroId, int slot);
    void onItemEquipped(int playerId, int heroId, int slot, int itemId);
    void onHeroHired(int playerId, int heroId);
    void onHeroDismissed(int playerId, int heroId);

    void onOfferSent();
    void onResearchSet(int playerId, int spellId);
    void onSpellPrepared(int playerId, int spellId);
    void onSpellCancelled(int playerId);
    void onSpellCast(int playerId /* Need target info */);

    void onCityDestroyed(int playerId, int cityId);
    void onBuildingDestroyed(int playerId, int buildingId);

    /*
     Begin construction of a building in a specified city. Since cities cannot control territory
     off of their shard, only the row and column need to be specified.
     */
    void onBuildingEnqueued(int playerId, int cityId, int buildingId, int row, int col);
    void onUnitEnqueued(int playerId, int cityId, int uniint);

    void onBuildingDequeued(int playerId, int cityId);
    void onUnitDequeued(int playerId, int cityId, int queueIndex);

    /*
     Unit actions include attacking, building cities, fortifying, and anything
     else a unit can do, with the exception of moving.
     */
    void onUnitAction(int playerId, int unitId, int actionId /* Need target information */);
    void onUnitMoved(int playerId, int unitId, int row, int col, int shard);

    /*
     When a player ends his/her turn, the following things occur, in this order.
     For the player whose turn is ending:
     - All units that have not moved fortify for their action.
     - Check for victory conditions.
     - Recalculate visibility (for all players).

     For the player whose turn is beginning:
     - Units gain health from regeneration/passive rest.
     - All upkeep/income is applied.
     - Building construction advances.
     - Unit construction advances.
     - Spell research advances.
     - Spell casting advances.
     - City population is updated.
     */
    void onTurnEnded(int playerId);
}
