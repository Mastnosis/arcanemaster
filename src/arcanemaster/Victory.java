package arcanemaster;

public class Victory {
	
	boolean military, avatar, economic, holy;
	
	public Victory(){ // default all victory conditions are active
		military = true;
		avatar = true;
		economic = true;
		holy = true;
	}
	
	
	public Victory(boolean military, boolean avatar, boolean economic, boolean holy){
		this.military = military;
		this.avatar = avatar;
		this.economic = economic;
		this.holy = holy;
	}
	
	public boolean checkAll(){
		if(checkMilitaryVictory() || checkAvatarVictory() || checkEconomicVictory() || checkHolyVictory()){
			return true;
		}
		if(checkMilitaryVictory()){
			return true;
		}else if(checkAvatarVictory()){
			return true;
		}else if(checkEconomicVictory()){
			return true;
		}else if(checkHolyVictory()){
			return true;
		}
		return false;
	}
	
	private boolean checkMilitaryVictory(){
		if(military){
			// TODO return true if military conditions have been met by one player
		}
		return false;
	}
	
	private boolean checkAvatarVictory(){
		if(avatar){
			// TODO return true if a player has defeated an avatar
		}
		return false;
	}
	
	private boolean checkEconomicVictory(){
		if(economic){
			// TODO return true if a player has achieved an economic victory
		}
		return false;
	}
	
	private boolean checkHolyVictory(){
		if(holy){
			// TODO return true if a player controls a majority of holy grounds
		}
		return false;
	}

}
