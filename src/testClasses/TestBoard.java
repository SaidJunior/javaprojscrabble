package testClasses;

import scrabbleMain.Board;
import junit.framework.TestCase;

public class TestBoard extends TestCase {
	private static final int length = 15;
	private static final int width  = 15;
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
	
	public void testIsFree() {
		Board testB = new Board(length, width, testWord);
		testB.insertLetter(1, 1, 'a');
		assertEquals(false, testB.isCellFree(1, 1));
		assertEquals(true, testB.isCellFree(1, 2));
	}
	
	public void testRemoveLetter() {
		Board testB = new Board(length, width, testWord);
		testB.insertLetter(1, 1, 'a');
		testB.removeLetter(1, 1);
		assertEquals(true, testB.isCellFree(1, 1));
	}
	
	public void testHasNeigbours() {
		Board testB = new Board(length, width, testWord);
		testB.insertLetter(1, 1, 'a');
		testB.insertLetter(2, 1, 'b');
		assertEquals(true, testB.hasNeigbours(1, 1));
		assertEquals(true, testB.hasNeigbours(2, 1));
		assertEquals(false, testB.hasNeigbours(5, 5));
	}
	
	public void testGetWord() {
		Board testB = new Board(length, width, testWord);
		assertEquals(testWord, testB.getWord(7, 3, 7, 3 + testWord.length() - 1));
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
