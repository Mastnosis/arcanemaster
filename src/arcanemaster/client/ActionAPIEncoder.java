package arcanemaster.client;

import java.util.ArrayList;

import arcanemaster.api.ActionAPI;
import arcanemaster.api.ActionResult;

/*
 * For each method on the ActionAPI, creates a plain text message and sends
 * it through a network connection.
 */
public class ActionAPIEncoder implements ActionAPI {
    private class MessageBuilder {
        private String functionName = "";
        private ArrayList<String> arguments = new ArrayList<String>();
		
        public MessageBuilder(String functionName) {
            this.functionName = functionName;
            intArg("playerId", playerId);
        }
		
        public void intArg(String name, int value) {
            arguments.add(String.format("%s %d int", name, value));
        }
		
        public String compile() {
            StringBuilder builder = new StringBuilder();
            builder.append(functionName);
            for (String s : arguments) {
                builder.append(s);
            }
            builder.append("\n");
            return builder.toString();
        }
    }

    private int playerId = -1;

    public ActionAPIEncoder(int playerId) {
        this.playerId = playerId;
        
        //TODO: setup the connection with the server.
    }
	
    public void sendMessage(String msg) {
        //TODO: actually send the message
    	System.out.println("===== Message to Server =====");
    	System.out.println(msg);
    }



    @Override
    public ActionResult reclaimItem(int itemId) {
    	MessageBuilder builder = new MessageBuilder("reclaimItem");
    	builder.intArg("itemId", itemId);
    	sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult unequipItem(int heroId, int slot) {
        MessageBuilder builder = new MessageBuilder("unequipItem");
    	builder.intArg("heroId", heroId);
    	builder.intArg("slot", slot);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult equipItem(int heroId, int slot, int itemId) {
        MessageBuilder builder = new MessageBuilder("equipItem");
    	builder.intArg("heroId", heroId);
    	builder.intArg("slot", slot);
    	builder.intArg("itemId", itemId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult hireHero(int heroId) {
        MessageBuilder builder = new MessageBuilder("hireHero");
    	builder.intArg("heroId", heroId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult dismissHero(int heroId) {
        MessageBuilder builder = new MessageBuilder("dismissHero");
    	builder.intArg("heroId", heroId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult sendOffer() {
        MessageBuilder builder = new MessageBuilder("sendOffer");
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult setResearch(int spellId) {
        MessageBuilder builder = new MessageBuilder("setResearch");
    	builder.intArg("spellId", spellId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult prepareSpell(int spellId) {
        MessageBuilder builder = new MessageBuilder("prepareSpell");
    	builder.intArg("spellId", spellId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult cancelSpell() {
        MessageBuilder builder = new MessageBuilder("cancelSpell");
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult castSpell(/* Need target info */) {
        MessageBuilder builder = new MessageBuilder("castSpell");
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult destroyCity(int cityId) {
        MessageBuilder builder = new MessageBuilder("destroyCity");
    	builder.intArg("cityId", cityId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult destroyBuilding(int buildingId) {
        MessageBuilder builder = new MessageBuilder("destroyBuilding");
    	builder.intArg("buildingId", buildingId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult enqueueBuilding(int cityId, int templateId, int row, int col) {
        MessageBuilder builder = new MessageBuilder("enqueueBuilding");
    	builder.intArg("cityId", cityId);
    	builder.intArg("templateId", templateId);
    	builder.intArg("row", row);
    	builder.intArg("col", col);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult enqueueUnit(int cityId, int templateId) {
        MessageBuilder builder = new MessageBuilder("enqueueUnit");
    	builder.intArg("cityId", cityId);
    	builder.intArg("templateId", templateId);
        sendMessage(builder.compile());
        return new ActionResult();
    }


    @Override
    public ActionResult dequeueBuilding(int cityId) {
        MessageBuilder builder = new MessageBuilder("dequeueBuilding");
    	builder.intArg("cityId", cityId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult dequeueUnit(int cityId, int queueIndex) {
        MessageBuilder builder = new MessageBuilder("dequeueUnit");
    	builder.intArg("cityId", cityId);
    	builder.intArg("queueIndex", queueIndex);
        sendMessage(builder.compile());
        return new ActionResult();
    }


    @Override
    public ActionResult unitAction(int unitId, int actionId /* Need target information */) {
        MessageBuilder builder = new MessageBuilder("unitAction");
    	builder.intArg("unitId", unitId);
    	builder.intArg("actionId", actionId);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult unitMove(int unitId, int row, int col, int shard) {
        MessageBuilder builder = new MessageBuilder("unitMove");
    	builder.intArg("unitId", unitId);
    	builder.intArg("row", row);
    	builder.intArg("col", col);
    	builder.intArg("shard", shard);
        sendMessage(builder.compile());
        return new ActionResult();
    }

    @Override
    public ActionResult endTurn() {
        MessageBuilder builder = new MessageBuilder("endTurn");
        sendMessage(builder.compile());
        return new ActionResult();
    }

}
