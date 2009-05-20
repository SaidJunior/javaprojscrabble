package scrabbleMain;

import java.io.Serializable;

public class PlayerLetters implements Serializable{
	private char[] playerLetters;
	
	public PlayerLetters() {
		playerLetters = new char[7];
	}

	public void add(char letter, int index) {
		if (index > 6) {System.out.println("ERROR: PlayerLatters got index bigger than 6");return;}
		playerLetters[index] = letter;
	}

	public void remove(int letterIndex) {
		playerLetters[letterIndex] = '*';
	}

	public int size() {
		int index = 0;
		for (int i = 0; i < playerLetters.length; i++) {
			if (playerLetters[i] != '*') {
				++index;
			}
		}
		return index;
	}

	public char get(int i) {
		return playerLetters[i];
	}
	
//	public void compresSet() {
//		char[] newArray = new char[7];
//		int index = 0;
//		for (int i = 0; i < newArray.length; i++) {
//			newArray[i] = '*';
//		}
//		for (int i = 0; i < playerLetters.length; i++) {
//			if (playerLetters[i] != '*') {
//				newArray[index] = playerLetters[i];
//				++index;
//			}
//		}
//		playerLetters = newArray;
//	}

	public void completeLetters(GameLogic g) {
		LettersSet lettersSet = g.getLettersSet();
		int[] places = new int[3];
		int index = 0;
		for (int i = 0; i < playerLetters.length; i++) {
			if (playerLetters[i] == '*') {
				places[index] = i;
				++index;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (lettersSet.getLetterSetSize() > 0) {
				playerLetters[places[i]] = lettersSet.getLetter();
			} else {
				break;
			}
		}
		
	}
}
