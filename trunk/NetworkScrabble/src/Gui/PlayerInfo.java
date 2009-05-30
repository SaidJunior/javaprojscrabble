package Gui;

public class PlayerInfo {

	String playerName;
	boolean isAuto;
	
	public PlayerInfo(String playerName, boolean isAuto) {
		playerName = playerName;
		isAuto     = isAuto;
	}
	
	public boolean isAuto() {
		return isAuto;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}