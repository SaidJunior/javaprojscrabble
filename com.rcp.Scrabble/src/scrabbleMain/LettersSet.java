/**
 * 
 */
package scrabbleMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import resources.resConfig;

public class LettersSet implements Serializable{
	private List <Character> letters = new ArrayList<Character>();
	private int number = 0;
	private Random generator = new Random();
	
	public LettersSet() {
		
		InputStream input = resConfig.getImageStream("letterDestribution.txt");
		
		try {
			BufferedReader in = 
				new BufferedReader(new InputStreamReader(input));			
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
	
	//@Pre letters.size() > 0
	public char getLetter() {
		
		char c = letters.remove(generator.nextInt(letters.size()));
		System.out.println(c);
		return c;
	}
	
	public int getLetterSetSize() {
		return letters.size();
	}

}