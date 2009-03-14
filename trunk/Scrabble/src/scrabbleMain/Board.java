package scrabbleMain;

import java.io.Serializable;



public class Board implements Serializable{
	
	private final int length, width;
	private Cell[][] CellArray; 
	
		
	public Board(int length, int width, String randomWord){
		
		this.length=length;
		this.width=width;
		
		CellArray = new Cell[length][width]; 
		
		for(int i=0; i<length; i++ )
			for(int j=0; j<width; j++)
				CellArray[i][j] = new Cell();
		
		for(int k=0; k<randomWord.length(); k++) //assert words lengths fits board dimentions/2
			insertLetter(length/2, (width-randomWord.length())/2+k, randomWord.charAt(k));
	}
	
	public void printBoard(){
		
		System.out.print("          ");
		for (int i = 0; i < width; i++) {
			System.out.format("%2d ", i);
		}
		System.out.println();
		System.out.println("          -----------------------------------------------------------");
		
		for(int i=0; i<length; i++ ){
			System.out.format("%8d| ", i);
			for(int j=0; j<width; j++){
				System.out.format("%2c ",CellArray[i][j].letter);
			}
			System.out.println();
		}
		System.out.println("          -----------------------------------------------------------");
	}
	
	public void insertLetter(int x, int y, char letter){
		CellArray[x][y].letter=letter;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}
	
	public char getLetter(int i, int j)
	{
		return CellArray[i][j].letter;
	}
	
	public boolean isCellFree(int i, int j) {
		if ((CellArray[i][j].letter != '*') && (CellArray[i][j].letter != '2'))
			return false;
		return true;
	}
	
	public boolean hasNeigbours(int i, int j) {
		if ((i > 0) && (CellArray[i - 1][j].letter != '*')) {
			return true;
		}
		if ((i < length - 1) && (CellArray[i + 1][j].letter != '*')) {
			return true;
		}
		if ((j > 0) && (CellArray[i][j - 1].letter != '*')) {
			return true;
		}
		if ((i < width - 1) && (CellArray[i][j + 1].letter != '*')) {
			return true;
		}
		
		return false;
	}
	public String getWord() {
		return null;
	}
	
	public String getWordExtra(int startRow, int startCol, int endRow, int endCol){
		StringBuffer  word = new StringBuffer();
		if (startRow == endRow) {
			for(int i = startCol; i <= endCol; i++) {
				word.append(CellArray[startRow][i].letter); 
			}
		}
		else if (startCol == endCol) {
			for(int i = startRow; i <= endRow; i++) {
				word.append(CellArray[i][startCol].letter); 
			}
		}
		else {
			return null;
		}
		return word.toString();
	}
	
	public void removeLetter(int i, int j) {
		CellArray[i][j].letter = '*';	
	}
	
	private class Cell implements Serializable{
		char letter;
		int type; //cells with different score
		
		private Cell() {
			this(1);
		}
		
		private Cell(int type){
			switch(type){
			case 1:	letter = '*'; break;
			case 2: letter = '2'; break;
			default:;
			}
		}
	}

	

}
