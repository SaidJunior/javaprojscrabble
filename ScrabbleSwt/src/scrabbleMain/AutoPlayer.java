package scrabbleMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AutoPlayer implements Serializable {
	private static List<LetterCellCords>  horizonal = new ArrayList<LetterCellCords>();
	private static List<LetterCellCords>  vertical  = new ArrayList<LetterCellCords>();
	public static final int[] CASE1 = { 1,  2,  3};
	public static final int[] CASE2 = {-1,  1,  2};
	public static final int[] CASE3 = {-2, -1,  1};
	public static final int[] CASE4 = {-3, -2, -1};
	public static final int[] ZEROS = {0, 0, 0};
	
	private static Board      board  = null;
	private static Dictionary dic    = null;
	private static int[]      lettersIndeces = new int[3];
	private static boolean    checkVertfirst = true; //this for          
	
	public AutoPlayer(Board b, Dictionary d, String randWord) {
		board  = b;
		dic    = d;
		//initialize the vertical list according to random word
		for (int i = 0; i < randWord.length(); i++) {
			vertical.add(new LetterCellCords(GameLogic.ROWS / 2, (randWord.length() / 2) + i));
		}
	}
	
	public void addLetterHorizonal(int i, int j) {
		horizonal.add(new LetterCellCords(i, j));
	}
	
	public void addLetterVertical(int i, int j) {
		vertical.add(new LetterCellCords(i, j));
	}
	
	
	public String placeAutoWordAndUpdateAdvanced(Player player) {
		String str1=null, str2=null;
		Random gen = new Random();
		int randLetter = gen.nextInt(7);
		int randRow = gen.nextInt(board.getLength()-8)+4;
		int randCol = gen.nextInt(board.getWidth ()-8)+4;
		
		//System.out.println(randLetter +": "+ player.getLetter(randLetter) + " " + randRow + " " + randCol + "\n");
		if(board.isCellFree(randRow, randCol) && board.hasNeigbours(randRow, randCol)){
			board.insertLetter(randRow, randCol, player.getLetter(randLetter));		
			
			int startRow=randRow; 
			int startCol=randCol;
			int endRow=randRow; 
			int endCol=randCol; 
			for (int i = randCol; i < board.getWidth(); i++) {
				if(!board.isCellFree(randRow, i)){
					endCol = i;
				}
				else{
					break;
				}
			}
			for (int i = randCol; i >=0; i--) {
				if(!board.isCellFree(randRow, i)){
					startCol = i;
				}
				else{
					break;
				}
			}
			str1=dic.getLongesrWord(board.getWord(randRow, startCol , randRow, endCol), randCol-startCol, randCol-startCol);
			//System.out.println(board.getWord(randRow, startCol , randRow, endCol)+ " " + (randCol-startCol) + "\n");
			for (int i = randRow; i < board.getLength(); i++) {
				if(!board.isCellFree(i, randCol)){
					endRow = i;
				}
				else{
					break;
				}
			}
			for (int i = randRow; i >=0; i--) {
				if(!board.isCellFree(i, randCol)){
					startRow = i;
				}
				else{
					break;
				}
			}
			str2=dic.getLongesrWord(board.getWord(startRow, randCol , endRow, randCol), randRow-startRow, randRow-startRow);
			//System.out.println(board.getWord(startRow, randCol , endRow, randCol)+ " " + (randRow-startRow) +"\n");
			if((str1==null)&&(str2==null)){
				board.removeLetter(randRow, randCol);
			}
			else{
				player.removeLetter(randLetter);
				if(str1 != null){
					if(str2 !=null){
						return ((str1.length() > str2.length()) ? str1 : str2);
					}
					else{
						return str1;	
					}
				}
				else{
					return str2;
				}
			}
		}
		return null;
	}
	
	public String placeAutoWordAndUpdate(Player player) {
		String ret = placeAutoWordBasic(player);
		checkVertfirst = (checkVertfirst == true) ? false : true;
		if (ret != null) {
			Arrays.sort(lettersIndeces);
			for (int j = 2; j >= 0; j--) {
				player.removeLetter(lettersIndeces[j]);
//				System.out.println(lettersIndeces[j]);
			}
			return ret;
		}
		return null;
	}
	private String placeAutoWordBasic(Player player) {
		
		for (int i = 0; i < 35; ++i) {
			//create a random string from three of the player letters
			Random generator = new Random();
			StringBuffer threeLetterWord = new StringBuffer(3);
			int first = generator.nextInt(player.getNumberOfLetters() - 1);
			threeLetterWord.append(player.getLetter(first));
			lettersIndeces[0] = first;
			int second;
			do {
				second = generator.nextInt(player.getNumberOfLetters() - 1);
			} while (second == first);
			threeLetterWord.append(player.getLetter(second));
			lettersIndeces[1] = second;
			int third;
			do {
				third = generator.nextInt(player.getNumberOfLetters() - 1);
			} while ((third == first) || (third == second));
			threeLetterWord.append(player.getLetter(third));
			lettersIndeces[2] = third;
//			System.out.println("FLAG AutoPlayer " + i + " " + threeLetterWord);
			
			String vertRet = null;
			String horzRet = null;
			if (checkVertfirst == true) {
				if ((vertRet = checkVerticalCases(threeLetterWord)) != null) {
					return vertRet;
				}
				if ((horzRet = checkHorizonalCases(threeLetterWord)) != null) {
					return horzRet;
				}
			}
			else {
				if ((horzRet = checkHorizonalCases(threeLetterWord)) != null) {
					return horzRet;
				}
				if ((vertRet = checkVerticalCases(threeLetterWord)) != null) {
					return vertRet;
				}
			}
		}
		return null;
	}

	private String checkHorizonalCases(StringBuffer threeLetterWord) {
		int isValid; //if isValid == 4 then the current candidate is no longer candidate
		for (int j = 0; j < horizonal.size(); ++j) {
			isValid = 0;
			
			// case #***
			if ((horizonal.get(j).col <= 11) &&
				(isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE1) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(0, board.getLetter(horizonal.get(j).row, horizonal.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(horizonal.get(j).row, 
											   horizonal.get(j).col + CASE1[k], 
									           threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the vertical list
							if (isCndidate(horizonal.get(j).row, horizonal.get(j).col + CASE1[k], true) == true) {
								vertical.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + CASE1[k]));
							}
						}
						//last placed letter could also be a candidate for case1
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col + 3, ZEROS, CASE1) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + 3));
						}
						//check if first letter is no more a candidate, it is possible only if it is candidate to case4
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE4) != true) {
							horizonal.remove(j); //remove this letter from the optional letters
						}
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else {
				++isValid;
			}
			//case *#**
			if ((horizonal.get(j).col <= 12) && (horizonal.get(j).col >= 1) &&
				(isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE2) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(1, board.getLetter(horizonal.get(j).row, horizonal.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(horizonal.get(j).row, 
										       horizonal.get(j).col + CASE2[k], 
											   threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the vertical list
							if (isCndidate(horizonal.get(j).row, horizonal.get(j).col + CASE2[k], true) == true) {
								vertical.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + CASE2[k]));
							}
						}
						//check if the first letter is vertically candidates for case 4
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col - 1, ZEROS, CASE4) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col - 1));
						}
						//check if the last letter is vertically candidates for case 1
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col + 2, ZEROS, CASE1) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + 2));
						}
						//this letter is no more a candidate for non of the cases
						horizonal.remove(j);
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else {
				++isValid;
			}
			//case **#*
			if ((horizonal.get(j).col <= 13) && (horizonal.get(j).col >= 2) &&
				(isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE3) == true)) {	
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(2, board.getLetter(horizonal.get(j).row, horizonal.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(horizonal.get(j).row, 
											   horizonal.get(j).col + CASE3[k], 
									           threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the vertical list
							if (isCndidate(horizonal.get(j).row, horizonal.get(j).col + CASE3[k], true) == true) {
								vertical.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + CASE3[k]));
							}
						}
						//check if the first letter is vertically candidates for case 4
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col - 2, ZEROS, CASE4) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col - 2));
						}
						//check if the last letter is vertically candidates for case 1
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col + 1, ZEROS, CASE1) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + 1));
						}
						//this letter is no more a candidate for non of the cases
						horizonal.remove(j);
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else {
				++isValid;
			}
			//case ***#
			if ((horizonal.get(j).col >= 3) && 
				(isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE4) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(3, board.getLetter(horizonal.get(j).row, horizonal.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(horizonal.get(j).row, 
											   horizonal.get(j).col + CASE4[k], 
									           threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the vertical list
							if (isCndidate(horizonal.get(j).row, horizonal.get(j).col + CASE4[k], true) == true) {
								vertical.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col + CASE4[k]));
							}		
						}
						//check if last letter is no more a candidate, it is possible only if it is candidate to case1
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col, ZEROS, CASE1) != true) {
							horizonal.remove(j); //remove this letter from the optional letters		
						}
						//first placed letter could also be a candidate for case4
						if (isCandidateByCase(horizonal.get(j).row, horizonal.get(j).col - 3, ZEROS, CASE4) == true) {
							horizonal.add(new LetterCellCords(horizonal.get(j).row, horizonal.get(j).col - 3));
						}
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else {
				++isValid;
			}
			
			//check if the current letter is still a candidate
			if (isValid == 4) {
				horizonal.remove(j);
			}
		}
		return null;
	}

	private String checkVerticalCases(StringBuffer threeLetterWord) {
		int isValid; //if isValid == 4 then the current candidate is no longer candidate
		for (int j = 0; j < vertical.size(); ++j) {
			isValid = 0;
			// case #
		    //	    *
		    //      *
		    //	    *
			if ((vertical.get(j).row <= 11)  && 
				(isCandidateByCase(vertical.get(j).row, vertical.get(j).col, CASE1, ZEROS) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(0, board.getLetter(vertical.get(j).row, vertical.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(vertical.get(j).row + CASE1[k],
									           vertical.get(j).col, 
									           threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the horizonal list
							if (isCndidate(vertical.get(j).row + CASE1[k], vertical.get(j).col, false) == true) {
								horizonal.add(new LetterCellCords(vertical.get(j).row + CASE1[k], vertical.get(j).col));
							}
						}
						//last placed letter could also be a candidate for case1
						if (isCandidateByCase(vertical.get(j).row + 3, vertical.get(j).col, CASE1, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row + 3, vertical.get(j).col));
						}
						//check if first letter is no more a candidate, it is possible only if it is candidate to case4
						if (isCandidateByCase(vertical.get(j).row, vertical.get(j).col, CASE4, ZEROS) != true) {
							vertical.remove(j); //remove this letter from the optional letters
						}
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else { //this letter is no longer a candidate for case1
				++isValid;
			}
			// case *
		    //	    #
		    //      *
		    //	    *
			if ((vertical.get(j).row <= 12) && (vertical.get(j).row >= 1) &&
				(isCandidateByCase(vertical.get(j).row, vertical.get(j).col, CASE2, ZEROS) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(1, board.getLetter(vertical.get(j).row, vertical.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(vertical.get(j).row + CASE2[k], 
									           vertical.get(j).col, 
									           threeLetterWord.toString().charAt(k));
							//if the new placed letter is candidate add it to the horizonal list
							if (isCndidate(vertical.get(j).row + CASE2[k], vertical.get(j).col, false) == true) {
								horizonal.add(new LetterCellCords(vertical.get(j).row + CASE2[k], vertical.get(j).col));
							}
						}
						//check if the first letter is vertically candidates for case 4
						if (isCandidateByCase(vertical.get(j).row - 1, vertical.get(j).col, CASE4, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row - 1, vertical.get(j).col));
						}
						//check if the last letter is vertically candidates for case 1
						if (isCandidateByCase(vertical.get(j).row + 2, j, CASE1, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row + 2, vertical.get(j).col));
						}
						//this letter is no more a candidate for non of the cases
						vertical.remove(j);
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else { //this letter is not a candidate for case2
				++isValid;
			}
			// case *
		    //	    *
		    //      #
		    //	    *
			if ((vertical.get(j).row <= 13) && (vertical.get(j).row >= 2) &&
				(isCandidateByCase(vertical.get(j).row, vertical.get(j).col, CASE3, ZEROS) == true)) {
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(2, board.getLetter(vertical.get(j).row, vertical.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(vertical.get(j).row + CASE3[k], 
									           vertical.get(j).col, 
									           threeLetterWord.toString().charAt(k));
							if (isCndidate(vertical.get(j).row + CASE3[k], vertical.get(j).col, false) == true) {
								horizonal.add(new LetterCellCords(vertical.get(j).row + CASE3[k], vertical.get(j).col));
							}
						}
						//check if the first letter is vertically candidates for case 4
						if (isCandidateByCase(vertical.get(j).row - 2, vertical.get(j).col, CASE4, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row - 2, vertical.get(j).col));
						}
						//check if the last letter is vertically candidates for case 1
						if (isCandidateByCase(vertical.get(j).row + 1, j, CASE1, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row + 1, vertical.get(j).col));
						}
						//this letter is no more a candidate for non of the cases
						vertical.remove(j);
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else { //this letter is no more a candidate for case3 
				++isValid;
			}
			// case *
		    //	    *
		    //      *
		    //	    #
			if ((vertical.get(j).row >= 3) &&
				(isCandidateByCase(vertical.get(j).row, vertical.get(j).col, CASE4, ZEROS) == true)) {	
					StringBuffer testWord = new StringBuffer(threeLetterWord);
					testWord.insert(3, board.getLetter(vertical.get(j).row, vertical.get(j).col));
					if (dic.contains(testWord.toString())) {
						for (int k = 0; k < 3; k++) {
							board.insertLetter(vertical.get(j).row + CASE4[k], 
									           vertical.get(j).col, 
									           threeLetterWord.toString().charAt(k));
							if (isCndidate(vertical.get(j).row + CASE4[k], vertical.get(j).col, false) == true) {
								horizonal.add(new LetterCellCords(vertical.get(j).row + CASE4[k], vertical.get(j).col));
							}
						}
						//check if the first letter is vertically candidates for case 4
						if (isCandidateByCase(vertical.get(j).row - 3, vertical.get(j).col, CASE4, ZEROS) == true) {
							vertical.add(new LetterCellCords(vertical.get(j).row - 3, vertical.get(j).col));
						}
						//check if the last letter is vertically candidates for case 1
						if (isCandidateByCase(vertical.get(j).row, j, CASE1, ZEROS) != true) {
							vertical.remove(j);
						}
//							System.out.println(testWord);
						return testWord.toString();
					}
			}
			else { //this letter id no more a candidate for case 4
				++isValid;
			}
			//check if current letter is no more a candidate
			if (isValid == 4) {
				vertical.remove(j);
			}
		}
		return null;
	}
	
	public static boolean isCndidate(int i, int j, boolean isVertical) {
		int[][] rowCase = {CASE1, CASE2, CASE3, CASE4};
		int[][] colCase = {ZEROS, ZEROS, ZEROS, ZEROS};
		
		
		if (isVertical != true) {
			int[][] temp = rowCase;
			rowCase = colCase;
			colCase = temp;
		}
		for (int k = 0; k < 4; k++) {
			if (isCandidateByCase(i, j, rowCase[k], colCase[k]) == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCandidateByCase(int i, int j, int[] caseRow, int[] caseCol) {
		for (int k = 0; k < caseRow.length; k++) {
			if (((i + caseRow[k]) > 14) || ((i + caseRow[k]) < 0) ||
			    ((j + caseCol[k]) > 14) || ((j + caseCol[k]) < 0)) {
				   return false;
			   }
			if (board.isCellFree(i + caseRow[k], j + caseCol[k]) != true) {
				return false;
			}
		}
		return true;
	}
	
	private class LetterCellCords {
		int row = 0;
		int col = 0;
		
		private LetterCellCords(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	
}
