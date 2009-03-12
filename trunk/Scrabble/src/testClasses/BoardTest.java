package testClasses;

import scrabbleMain.Board;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private static final int length = 20;
	private static final int width  = 20;
	private static final String testWord = "blaaaaaaa";
	
	public void testBoard()
	{
		Board testB = new Board(length, width, testWord);
		assertEquals(length, testB.getLength());
		assertEquals(width, testB.getWidth());
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				char currentCell = testB.getLetter(i, j);
				boolean hadWord = false;
				
				if ((currentCell != '*') && (testB.getLetter(i, j) != '2')) {
					if (hadWord) {
						assertEquals(0, 1);
					}
					assertEquals(0, compareWord(testB, i, j));
					j += testWord.length();
					hadWord = true;
				}
			}
		}
	}
	
	public void testInsertLetter() {
		Board testB = new Board(length, width, testWord);
		
		testB.insertLetter(1, 1, 'a');
		assertEquals('a', testB.getLetter(1, 1));
	}
	
	private int compareWord(Board board, int wordRow, int wordStartCol) {
		
		for(int i = 0; i < testWord.length(); i++) {
			if ((wordStartCol + i) >= width)
			{
				return -1;
			}
			if (board.getLetter(wordRow, wordStartCol + i) != testWord.charAt(i)) {
				return -2;
			}
		}
		return 0;
	}

}
