/**
 * 
 */
package scrabbleMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LettersSet implements Serializable{
	private List <Character> letters = new ArrayList<Character>();
	private int number = 0;
	
	public LettersSet() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(Game.getPath()+"resources/letterDestribution.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				number = Integer.parseInt(str.substring(1));
				for (int i = 0; i < number; i++) {
				letters.add(str.charAt(0));
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public char getLetter() {
		Random generator = new Random();
		return letters.remove(generator.nextInt(letters.size()));
	}
	
	public int getLetterSetSize() {
		return letters.size();
	}

}