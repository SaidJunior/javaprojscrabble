package gameUsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

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
	
	public String toString()
	{
	Iterator<String> iter = rivals.iterator();
	String r = "";
	while (iter.hasNext())
	{
		r +=iter.next() + ", ";
	}
	
	return "Name: " + getName() + ", date: " + getDate() + ", score: " + getCurrentScrore() +
	", rivals: " + r; 
	}
}
