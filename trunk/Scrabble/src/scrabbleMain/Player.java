package scrabbleMain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable{
	private final String name;
	private int score = 0;
	private List<Character> playerLetters = new ArrayList<Character>(7);
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int delta) {
		score += delta;
	}
	
	public void insertLetter(char letter) {
		playerLetters.add(letter);
	}
	
	public void removeLetter(int letterIndex) {
		playerLetters.remove(letterIndex);
	}
	
	public void printPlayerLetters() {
		for (int i = 0; i < playerLetters.size(); i++) {
			System.out.print(playerLetters.get(i) + "   ");
		}
		System.out.println();
		for (int i = 0; i < playerLetters.size(); i++) {
			System.out.print(i + "   ");
		}
	}
	
	public int getNumberOfLetters() {
		return playerLetters.size();
	}
	
	/**
	 * @pre (i >= 0) && (i<= getNumbersOfLetters)
	 * @param i
	 * @return
	 */
	public char getLetter(int i) {
		return playerLetters.get(i);	
	}

}
