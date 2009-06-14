package testClasses;

import scrabbleMain.AutoPlayer;
import scrabbleMain.Board;
import scrabbleMain.Dictionary;
import scrabbleMain.Player;
import junit.framework.TestCase;

public class TestAutoPlayer extends TestCase {
	private static final String midWord = "zbcdef";
	private static Board board   = new Board(15, 15, midWord);
	private static Dictionary  d = new Dictionary(15, 15);
	private static Player      p = new Player("AutoPlayer");
	private static AutoPlayer ap = new AutoPlayer(board, d, midWord);
//	private static LettersSet ls = new LettersSet();
	
	public static void testIsCandidateByCase() {
		//test cases 4
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		
		board.insertLetter(6, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		board.insertLetter(6, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		board.insertLetter(5, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		board.insertLetter(5, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		board.insertLetter(4, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		board.insertLetter(4, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(3, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(2, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(1, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(0, 4, AutoPlayer.CASE4, AutoPlayer.ZEROS));
		
		//test case 1
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(9, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(9, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(10, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		board.insertLetter(10, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(11, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(12, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(13, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(14, 4, AutoPlayer.CASE1, AutoPlayer.ZEROS));
		
		//test case 2
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		board.insertLetter(6, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		board.insertLetter(6, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, '*');
		board.insertLetter(9, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		board.insertLetter(9, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		assertEquals(true, AutoPlayer.isCandidateByCase(12, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(13, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(14, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		assertEquals(true, AutoPlayer.isCandidateByCase(1, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(0, 4, AutoPlayer.CASE2, AutoPlayer.ZEROS));
		
		//case 3
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		board.insertLetter(8, 4, '*');
		board.insertLetter(6, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		board.insertLetter(6, 4, '*');
		board.insertLetter(5, 4, 'a');
		assertEquals(false, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		board.insertLetter(5, 4, '*');
		assertEquals(true, AutoPlayer.isCandidateByCase(7, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		assertEquals(true, AutoPlayer.isCandidateByCase(13, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(14, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		assertEquals(true, AutoPlayer.isCandidateByCase(2, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(1, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		assertEquals(false, AutoPlayer.isCandidateByCase(0, 4, AutoPlayer.CASE3, AutoPlayer.ZEROS));
		
		
	}
	
	public static void testIsCandidate() {
		assertEquals(true, AutoPlayer.isCndidate(7, 5, true));
		assertEquals(false, AutoPlayer.isCndidate(7, 5, false));
		assertEquals(true, AutoPlayer.isCndidate(6, 5, false));
	}
	
	public static void testPlaceWord() {
		/*
		p.insertLetter('c');
		p.insertLetter('t');
		p.insertLetter('s');
		p.insertLetter('o');
		p.insertLetter('g');
		p.insertLetter('s');*/
		assertEquals(true, ap.placeAutoWordAndUpdate(p));
		board.printBoard('b');
		p.printPlayerLetters();
	}
	
	

}
