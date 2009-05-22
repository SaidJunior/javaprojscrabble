package gameUsers;

import java.util.ArrayList;
import java.util.Iterator;

public class User {

	//name field will be unique.
	private String name;
	private String password;
	private String email;
	private int numOfVictories;
	private int bestResult;
	private ArrayList<GameHistory> history;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumOfVictories() {
		return numOfVictories;
	}
	public void setNumOfVictories(int numOfVictories) {
		this.numOfVictories = numOfVictories;
	}
	public int getBestResult() {
		return bestResult;
	}
	public void setBestResult(int bestResult) {
		this.bestResult = bestResult;
	}
	public ArrayList<GameHistory> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<GameHistory> history) {
		this.history = history;
	}
	
	public String toStringGames()
	{
		if (history == null)
			return null;
		Iterator<GameHistory> iter = history.iterator();
		String res = "";
		while (iter.hasNext())
		{
			res += iter.next().toString() + "\n";
		}
		return res;
	}
	
	public String toString()
	{
		return "User name: " + getName() + ", password: " + getPassword() + ", email: " +
		getEmail() + ", best-score: " + getBestResult() + ", victories: " + getNumOfVictories() +
		"\nGames: " + toStringGames();
	}
	
}
