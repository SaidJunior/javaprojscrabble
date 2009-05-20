package gameUsers;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class GameHistory {

	private String date;
	private int currentScrore;
	//will hold component's names
	private ArrayList<String> rivals = new ArrayList<String>();
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
		
	}
	public int getCurrentScrore() {
		return currentScrore;
	}
	public void setCurrentScrore(int currentScrore) {
		this.currentScrore = currentScrore;
	}
	public ArrayList<String> getComponents() {
		return rivals;
	}
	public void setComponents(ArrayList<String> components) {
		this.rivals = components;
	}
}
