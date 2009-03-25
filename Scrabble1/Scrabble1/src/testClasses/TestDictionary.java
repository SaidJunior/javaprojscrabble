package testClasses;

import scrabbleMain.Dictionary;
import junit.framework.TestCase;

public class TestDictionary extends TestCase {
	public void testContains() {
		Dictionary testDictionary = new Dictionary(15, 15);
		assertEquals(true, testDictionary.contains("dog"));
		assertEquals(false, testDictionary.contains("sfhgdsfhd"));
	}
	
	public void testGetLongestWord() {
		Dictionary testDictionary = new Dictionary(15, 15);
		
		assertEquals(null, testDictionary.getLongesrWord("abcdogkt", 6, 6));
		assertEquals("nose", testDictionary.getLongesrWord("sunose", 2, 2));
		assertEquals("sun", testDictionary.getLongesrWord("sunose", 0, 1));
		assertEquals("nose", testDictionary.getLongesrWord("sunose", 3, 5));
		assertEquals("chairman", testDictionary.getLongesrWord("asdchairmandsg", 4, 7));
	}

}
