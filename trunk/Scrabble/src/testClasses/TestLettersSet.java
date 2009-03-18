package testClasses;

import scrabbleMain.LettersSet;
import junit.framework.TestCase;

public class TestLettersSet extends TestCase {
	public void testLetterSetConstructor() {
		LettersSet testLetterSet = new LettersSet();
		assertEquals(98, testLetterSet.getLetterSetSize());
	}
}
