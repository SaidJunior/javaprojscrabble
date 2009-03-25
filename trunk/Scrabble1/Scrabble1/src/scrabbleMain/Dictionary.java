package scrabbleMain;

import java.util.*;
import java.io.*;

/*
 * The dictionary class
 */

public class Dictionary {
	
	private Set<String> words = new HashSet<String>(); //the set of words
	private List<String> randomWords = new ArrayList<String>(); // list of random words
	private int n;
	private int m; 
	
	public Dictionary(int n, int m){
		this.n = n;
		this.m = m;
		
		int size = Math.min(m, n) / 2;

		try{
			BufferedReader in = 
				new BufferedReader(new FileReader("resources/Words.txt"));
			String str;
			while ((str = in.readLine()) != null){
				words.add(str);
				if (str.length() <= size)
					randomWords.add(str);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getRandomWord(){
		
		Random generator = new Random();
		
		return randomWords.get(generator.nextInt(randomWords.size()));
	}
	
	/*
	 * Checks if that string is in the dictionary
	 */
	
	public boolean contains(String s){
		return words.contains(s);
	}
	
	public String getLongesrWord(String boardString, int startLetterIndex, int endLetterIndex) {
		int maxlength = 0;
		
		String longestWord = null;
		if (startLetterIndex == 0) {
			for (int i = endLetterIndex + 1; i < boardString.length(); i++) {
				if ((words.contains(boardString.substring(0, i + 1)) == true) && (maxlength < i + 1)) {
					longestWord = boardString.substring(0, i + 1);
					maxlength = i + 1;
				}
			}
		}
		else if (endLetterIndex == (boardString.length() - 1)) {
			for (int i = 0; i <= startLetterIndex - 1; i++) {
				if ((words.contains(boardString.substring(i, boardString.length())) == true) && (maxlength < boardString.length() - i)) {
					longestWord = boardString.substring(i, boardString.length());
					maxlength = boardString.length() - i;
				}
			}
		}
		else {
			for (int i = 0; i <= startLetterIndex; i++) {
				for (int j = endLetterIndex; j < boardString.length(); j++) {
					if ((words.contains(boardString.substring(i, j + 1)) == true) && (maxlength < (j - i + 1))) {
						longestWord = boardString.substring(i, j + 1);
						maxlength = j - i + 1;
					}
				}
			}
		}
		
		return longestWord;
	}	
}
