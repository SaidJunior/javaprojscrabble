package scrabbleMain;

import java.util.*;
import java.io.*;

/*
 * The dictionary class
 */

public class Dictionary {
	
	private Set<String> words = new HashSet<String>(); //the set of words
	private List<String> randomWords = new ArrayList<String>(); // list of random words
	private int n, m; //the size of the board
	
	public Dictionary(int n, int m){
		this.n = n;
		this.m = m;
		
		int size = Math.min(m, n) / 2;

		try{
			BufferedReader in = 
				new BufferedReader(new FileReader("src/resources/Words.txt"));
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
	public static void main(String []args){
		Dictionary d = new Dictionary(10, 10);
		System.out.println(d.contains("abbreviation"));
		System.out.println(d.contains("ar"));
		System.out.println(d.getRandomWord());
		
	}
}
