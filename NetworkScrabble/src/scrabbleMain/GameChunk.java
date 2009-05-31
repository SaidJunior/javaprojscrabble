package scrabbleMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameChunk implements Serializable{
	
	private  int            numberOfPlayers = 0;
	private  boolean        finishGame      = false;

	private  List<Player>   playerList      = new ArrayList<Player>();
	private  int            LetterMode      = 0;
	private  LettersSet     lettersSet      = new LettersSet();
	private  Board          board; 
	private  int            turnInd         = 0;
	private  char           mode            = 'b';  //indicates the chosen rules set
	
	public GameChunk(){
		}

    public int getLetterMode(){
    	return LetterMode;
    }
    public void setLetterMode(int LetterModenew){
    	this.LetterMode = LetterModenew;
    }
	public  int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public  void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public  boolean getFinishGame() {
		return finishGame;
	}

	public  void setFinishGame(boolean finishGame) {
		this.finishGame = finishGame;
	}


	public  int getTurnInd() {
		return turnInd;
	}

	public  void setTurnInd(int turnInd) {
		this.turnInd = turnInd;
	}


	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public LettersSet getLettersSet() {
		return lettersSet;
	}

	public void setLettersSet(LettersSet lettersSet) {
		this.lettersSet = lettersSet;
	}


	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setturnInd(int turnInd) {
		this.turnInd = turnInd;
	}

	public char getMode(){
		return mode;
	}
	
	public void setMode(char mode){
		this.mode = mode;
	}
	
	public String getCurrentPlayerName() {
		return playerList.get(turnInd).getName();
	}
	
	public int getCurrentPlayerScore() {
		return playerList.get(turnInd).getScore();
	}
	
	public Player getCurrentPlayer() {
		return playerList.get(turnInd);
	}
	
	public void printCurrentPlayerLetters() {
		playerList.get(turnInd).printPlayerLetters();
	}


}
