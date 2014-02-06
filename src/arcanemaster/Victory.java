package arcanemaster;

public class Victory {
	
	boolean military = true;
	
	public Victory(){
		
	}
	
	public boolean checkForVictory(){
		if(checkForMilitaryVictory()){
			return true;
		}else if(checkForAvatarVictory()){
			return true;
		}else if(checkForEconomicVictory()){
			return true;
		}
		return false;
	}
	
	private boolean checkForMilitaryVictory(){
		return false;
	}
	
	private boolean checkForAvatarVictory(){
		return false;
	}
	
	private boolean checkForEconomicVictory(){
		return false;
	}

}
