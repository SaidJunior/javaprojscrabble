package testClasses;

import scrabbleMain.Player;
import junit.framework.TestCase;

public class TestPlayer extends TestCase {
	public void testNameAndScore() {
		Player testPlayer = new Player("Ohad");
		testPlayer.setScore(60);
		assertEquals("Ohad", testPlayer.getName());
		assertEquals(60, testPlayer.getScore());
	}
	
	public void testInsertAndRemoveLetter() {
		Player testPlayer = new Player("Ohad");
		for (int i = 0; i < 7; i++) {
			//testPlayer.insertLetter('b');
		}
		assertEquals(7, testPlayer.getNumberOfLetters());
		for (int i = 0; i < 7; i++) {
			testPlayer.removeLetter(0);
		}
		//testPlayer.insertLetter('a');
		assertEquals(1, testPlayer.getNumberOfLetters());
		assertEquals('a', testPlayer.getLetter(0));
	}
}
