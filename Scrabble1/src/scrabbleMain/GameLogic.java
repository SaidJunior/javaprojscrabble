package scrabbleMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * This class contains all the logic variables of a Scrabble game
 * @author eviatar
 *
 */
public class GameLogic {
	public final  int ROWS            = 15;
	public final  int COLUMNS         = 15;
	public final  int MAX_NAME_LENGTH = 20;
	
	private  int            numberOfPlayers = 0;
	private  boolean        finishGame      = false;

	private  List<Player>   playerList      = new ArrayList<Player>();
	private  int            LetterMode      = 0;  
	private  BufferedReader consoleReader   = new BufferedReader(new InputStreamReader(System.in));
	private  LettersSet     lettersSet      = new LettersSet();
	private  Dictionary     dictionary      = new Dictionary(ROWS, COLUMNS);
	private  Board          board           = new Board(ROWS, COLUMNS, dictionary.getRandomWord());
	private  int            turnInd         = 0;
	private  char           mode            = 'b';  //indicates the chosen rules set
	private  RecordList     recordListBasic      = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	private  RecordList     recordListAdvanced     = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	private  boolean isSaved = false;
	//Path to hold all saved games at.
	private  String savedGamesPath  = "Saved_Games/";
	private  String savedRecordListPath = "RecordList/fileRecordList";
	private  String savedRecordListAdvancedPath  = "RecordList/fileRecordListAdvanced";
	private  String fileSuffix      = ".scrabble";
	public NewGUI.MainWindow1 mainWindow; 

    public int getLetterMode(){
    	return LetterMode;
    }
    public void setLetterMode(int LetterModenew){
    	this.LetterMode = LetterModenew;
    }
	public  int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public  String getsavedRecordListPath() {
		return this.savedRecordListPath;
	}
	
	public  void setsavedRecordListPath(String new_path) {
		this.savedRecordListPath = new_path;
	}
	
	public  String getsavedRecordListAdvancedPath() {
		return this.savedRecordListAdvancedPath;
	}
	
	public  void setsavedRecordListAdvancedPath(String new_path) {
		this.savedRecordListAdvancedPath = new_path;
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

	public  BufferedReader getConsoleReader() {
		return consoleReader;
	}

	public  void setConsoleReader(BufferedReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	public  Dictionary getDictionary() {
		return dictionary;
	}

	public  void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public  int getTurnInd() {
		return turnInd;
	}

	public  void setTurnInd(int turnInd) {
		this.turnInd = turnInd;
	}

	public  RecordList getRecordList() {
		return recordListBasic;
	}

	public  void setRecordList(RecordList recordList) {
		this.recordListBasic = recordList;
	}
	
	public  RecordList getRecordListAdvanced() {
		return recordListAdvanced;
	}
	public  void setRecordListAdvanced(RecordList recordList) {
		this.recordListAdvanced = recordList;
	}
	

	public  boolean getIsSaved() {
		return isSaved;
	}

	public  void setIsSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}

	public  String getSavedGamesPath() {
		return savedGamesPath;
	}

	public  void setSavedGamesPath(String savedGamesPath) {
		this.savedGamesPath = savedGamesPath;
	}


	public  String getFileSuffix() {
		return fileSuffix;
	}

	public  void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
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
	
	public void printCurrentPlayerLetters() {
		playerList.get(turnInd).printPlayerLetters();
	}

	
}