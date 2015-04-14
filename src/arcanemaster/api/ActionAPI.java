package arcanemaster.api;

public interface ActionAPI {

    ActionResult reclaimItem(int itemId);
    ActionResult unequipItem(int heroId, int slot);
    ActionResult equipItem(int heroId, int slot, int itemId);
    ActionResult hireHero(int heroId);
    ActionResult dismissHero(int heroId);

    ActionResult sendOffer();
    ActionResult setResearch(int spellId);
    ActionResult prepareSpell(int spellId);
    ActionResult cancelSpell();
    ActionResult castSpell(/* Need target info */);

    ActionResult destroyCity(int cityId);
    ActionResult destroyBuilding(int buildingId);

    /*
     Begin construction of a building in a specified city. Since cities cannot control territory
     off of their shard, only the row and column need to be specified.
     */
    ActionResult enqueueBuilding(int cityId, int buildingId, int row, int col);
    ActionResult enqueueUnit(int cityId, int uniint);

    ActionResult dequeueBuilding(int cityId);
    ActionResult dequeueUnit(int cityId, int queueIndex);

    /*
     Unit actions include attacking, building cities, fortifying, and anything
     else a unit can do, with the exception of moving.
     */
    ActionResult unitAction(int unitId, int actionId /* Need target information */);
    ActionResult unitMove(int unitId, int row, int col, int shard);

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
    ActionResult endTurn();

}
