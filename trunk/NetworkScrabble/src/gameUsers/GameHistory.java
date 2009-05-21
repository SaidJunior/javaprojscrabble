package gameUsers;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class GameHistory {

	private String name;
	//There is no need to set the date field for GameHistory. DB will generate it.
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getRivals() {
		return rivals;
	}
	public void setRivals(ArrayList<String> rivals) {
		this.rivals = rivals;
	}
}
