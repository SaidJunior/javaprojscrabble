package scrabbleMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Game{

	
	private final static int rows          = 15;
	private final static int columns       = 15;
	private final static int maxNameLength = 50;
	
	private static int            numberOfPlayers = 0;
	private static boolean        finishGame      = false;

	private static List<Player>   playerList      = new ArrayList<Player>();
	private static BufferedReader consoleReader   = new BufferedReader(new InputStreamReader(System.in));
	private static LettersSet     lettersSet      = new LettersSet();
	private static Dictionary     dictionary      = new Dictionary(rows, columns);
	private static Board          board           = new Board(rows, columns, dictionary.getRandomWord());
	private static int turnInd = 0;
	static char mode;  //indicates the chosen rules set
	private static RecordList     recordList      = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	
	private static boolean isSaved = false;
	//Path to hold all saved games at.
	private static String savedGamesPath = "Saved_Games/";
	private static String savedRecordList ="RecordList/fileRecordList";
	private static String fileSuffix = ".scrabble";
	
	public static void main(String[] args) {
		int returnStartInputValue = 0;
		
		System.out.println("WELCOME TO SCABBLE");
		
		returnStartInputValue = parseUserStartInput(); 
		
		if (returnStartInputValue == 1)  { // quit the game
			updateRecordList();
			printRecordList();
			return;
		}
		
		while ((lettersSet.getLetterSetSize() > 0) && (finishGame == false)) {
			for( ; turnInd < numberOfPlayers; turnInd++) {
			
				System.out.println("\n\nNow playing: " + playerList.get(turnInd).getName() + " your score is: " + playerList.get(turnInd).getScore());
				System.out.println("\n\n");
				
				board.printBoard();
				
				System.out.print("\n\n Your letters are: ");
				System.out.println();
				
				playerList.get(turnInd).printPlayerLetters();
				
				System.out.println("\n\n");
				
				parseUserInput(turnInd);
				
				if (finishGame == true) {
					break;
				}
			}
			if(numberOfPlayers != 0){
				if (turnInd % numberOfPlayers == 0)
					turnInd = 0;
			}
		}

		saveBeforeExit();
		printExitScreen();
		updateRecordList();
		printRecordList();
	}



	private static void printRecordList() {
		System.out.println("Top Scores");
		System.out.println("----------");
		recordList.printRecordList();
		FileOutputStream file;
		
			try {
				file = new FileOutputStream(savedRecordList);
				ObjectOutputStream data = new ObjectOutputStream(file);
//				recordList.updatePlayer("First Player", 10);
				data.writeObject(recordList);
				data.close();
				file.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("IO error - File not found. The record list will not be printed - try again later");
				return;
			} catch (IOException e) {
				System.out.println("IO error. The record list will not be printed - try again later");
				return;
			}
			
		System.out.println("Thank you for playing Scrabble!!");
	}



	private static void updateRecordList() {
		FileInputStream file;
		try {
			file = new FileInputStream(savedRecordList);
			ObjectInputStream data = new ObjectInputStream(file);
		    recordList= (RecordList) data.readObject();
			data.close();
			file.close();
			if(!(playerList.size()==0)){
			for(Player player:playerList){
				recordList.updatePlayer(player.getName(),player.getScore());
			}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Error while loading.");
			parseUserStartInput();
		} catch (IOException e) {
			System.out.println("IO Exception while loading updateRecordList.");
		} catch (ClassNotFoundException e) {
			System.out.println("Cast problem while loading.");
			parseUserStartInput();
		}
	}

	private static int parseUserStartInput() { //ask the user if start a new game or to load 
		char startInput = 0;
		boolean validInput = false;
		int returnValue = 0;
		
		do {
			startInput = GetUserInput.getUserCharInput("Enter 'n' for a new game, 'l' for loading a game, 'h' for help or 'q' to exit", consoleReader);
			switch (startInput) {
			case 'n': getGameRules(); 
				      getNumberOfPlayers();
		              createPlayersList();
		              validInput = true;
		              break;
			case 'l': 
			          validInput = loadGame();;
			          break;
			case 'h': printHelpScreen();
			          break;
			
			case 'q': return 1;
			
			default : System.out.println("Input is not valid, please try again");
			}
			 
		} while (validInput == false);
		
		return returnValue;
	}

	private static boolean loadGame() {
		
		String currentName = GetUserInput.getGameName(consoleReader);
		boolean succ = false;
		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name. ");
			return succ;
		}
		if (!checkIfExist(currentName + fileSuffix))
		{
			System.out.println("A game named: " + currentName + " does not exists.");
			return succ;
		}
		currentName += fileSuffix;
		
		try {
			FileInputStream file = new FileInputStream(savedGamesPath + currentName);
			ObjectInputStream data = new ObjectInputStream(file);
			GameEntity gameEntity = (GameEntity) data.readObject();
			data.close();
			file.close();
			
			playerList = gameEntity.getPlayerList();
			lettersSet = gameEntity.getLettersSet();
			board = gameEntity.getBoard();
			numberOfPlayers = playerList.size();
			turnInd = gameEntity.turnInd();
			mode = gameEntity.getMode();
			succ = true;
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error while loading the game.");
			return succ;
		} catch (IOException e) {
			System.out.println("IOE Exception while loading the game.");
			return succ;
		} catch (ClassNotFoundException e) {
			System.out.println("Cast problem while loading the game.");
			return succ;
		}
		return succ;
	}



	private static void getGameRules() { //this function sets the rules
		do{
			mode = GetUserInput.getUserCharInput("Enter 'b' for basic settings and 'a' for advanced", consoleReader);
		}while (mode != 'b' && mode != 'a');
		
		if (mode == 'a') {
			board.makeAdvancedBoard();
		}
	}
	
	//get the score of the word
	private static int calcScore(int startRow, int startCol, int endRow, int endCol){
		int sum = 0;
		if (startRow == endRow)
			for (int i = startCol; i <= endCol; i++)
				sum += board.getScore(startRow, i);
		if (startCol == endCol)
			for (int i = startRow; i <= endRow; i++)
				sum += board.getScore(i, startCol);
		return sum;
	}


	private static void parseUserInput(int i) {
		char    currentMove;
		
		boolean validInput = false;
		
		do {
			currentMove = GetUserInput.getUserCharInput("Choose your next move:\n" +
					"t for throwing letters, w for adding a word to board, s for saving the game, h for help screen, i for game-information, q for exit", consoleReader);
			switch (currentMove) {
			case 't': throwLetter(playerList.get(i)); 
					  validInput = true; 
					  isSaved = false;
					  break;
			case 'w': 
					  if(mode == 'b') 
						  placeWordBasic(playerList.get(i)); 
					  else
						  placeWordAdvanced(playerList.get(i));
			          validInput = true; 
			          isSaved = false;
			          break;
			case 'q': finishGame = true; 
			          validInput = true; 
			          break;
			case 'h': printHelpScreen();
					  break;
			case 's': saveCurrentGame();
			          validInput = true;
			          break;
			case 'i': printInfo();
					  validInput = true;
					  break;
			default: System.out.println("Input is not valid, please try again");
			}
		} while (validInput == false);
	}
	

	public static void saveBeforeExit()
	{
		boolean validInput = false;
		char answer;
		while (!isSaved)
		{
			System.out.println("Current game is not saved. Would you like to save the game before exit? ");
			
			answer = GetUserInput.getYesOrNo(consoleReader);
			
			if (answer == 'y')
			{
				saveCurrentGame();
			}
			if (answer == 'n')
			{
				return;
			}
		}
	}


	private static void saveCurrentGame() {
		
		String currentName = GetUserInput.getGameName(consoleReader);

		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name.");
			turnInd--;
			return;
		}
		currentName += fileSuffix;
		//check if such a game already exists.
		if(checkIfExist(currentName))
		{
			System.out.println("A game with this name already exists.\n\nDo you want to overwrite it?");
			char answer = GetUserInput.getYesOrNo(consoleReader);
			if (answer == 'n')
			{
				//otherwise, play the turn again
				turnInd--;
				return;
			}
		}
		
		GameEntity gameEntity = new GameEntity(playerList, lettersSet, board, turnInd, mode);
		try {
			FileOutputStream file = new FileOutputStream(savedGamesPath + currentName);		  
			ObjectOutputStream data = new ObjectOutputStream(file);
			
			data.writeObject(gameEntity);
			data.close();
			file.close();
			
			System.out.println("The game: " + currentName + " has been successfully saved.\n");
		} catch (FileNotFoundException e) {
			System.out.println("File Error while saving.");
		} catch (IOException e) {
			System.out.println("IOE Exception while saving.");
		}
		//after saving the game, player get to play again
		turnInd--;
		isSaved = true;
	}
	

	public static boolean checkIfExist(String fileName){
		
		File file = new File(savedGamesPath + fileName);
		return file.exists();		
	}


	private static void printHelpScreen() {
		try{
			BufferedReader in = 
				new BufferedReader(new FileReader("resources/help_file.txt"));
			String str;
			while ((str = in.readLine()) != null)
				System.out.println(str);	
		}
		catch(IOException e){
			System.out.println("IO Error. Loading the help file failed. Please try again later");
		}
	}
	
	private static void placeWordAdvanced(Player player) { //this function will be an extra rule, currently not in use
		int row;
		int column;
		int letterIndex;
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		String userWord;
		
		System.out.println("Choose JUST ONE letter to place in order to make a word");
		row         = GetUserInput.getUsetIntgerInput(0, rows - 1, "enter letter row number", consoleReader);
		column      = GetUserInput.getUsetIntgerInput(0, columns - 1, "enter letter column number", consoleReader);
		letterIndex = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "enter the index of the wanted letter", consoleReader);
		
		if ((board.hasNeigbours(row, column) == false) || (board.isCellFree(row, column) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		
		startRow = GetUserInput.getUsetIntgerInput(0, rows - 1, "enter word's start row", consoleReader);
		startCol = GetUserInput.getUsetIntgerInput(0, columns - 1, "enter word's start column", consoleReader);
		endRow   = GetUserInput.getUsetIntgerInput(0, rows - 1, "enter word's end row", consoleReader);
		endCol   = GetUserInput.getUsetIntgerInput(0, columns - 1, "enter word's end column", consoleReader);
		
		if ((startRow != endRow) && (startCol != endCol)) {
			System.out.println("Word cordinates not valid - you lost you turn");
			return;
		}
		if (((startRow == endRow) && (endRow != row)) || ((endCol == startCol) && (startCol != column))){
			System.out.println("Word cordinates do not include inserted letter - you lost your turn");
			return;
		}
		
		board.insertLetter(row, column, player.getLetter(letterIndex));
		//board.printBoard();
		userWord = board.getWord(startRow, startCol, endRow, endCol);
		if (userWord == null) {
			System.out.println("Given indeces are not valid, you lost your turn");
			board.removeLetter(row, column);
		}
		if(dictionary.contains(userWord)) {
			int addedPoints = calcScore(startRow, startCol, endRow, endCol);
			player.removeLetter(letterIndex);
			player.insertLetter(lettersSet.getLetter());
			player.setScore(addedPoints);
			System.out.println("\n\nVery Good - you made the word: " + userWord + ". You gained " + addedPoints + " more pointes\n\n");
		}
		else {
			board.removeLetter(row, column);
			System.out.println("Word: "+ userWord + " does not exist in the dictionary");
		}
		
	}

	private static void placeWordBasic(Player player) { 
		int row;
		int column;
		int maxWordLength = -1;
		int letterIndex;
		String userWord;
		String maxWord = null;
		char addMoreLetters;
		boolean validInput       = false;
		boolean validByRows      = true;
		boolean validByCols      = true;
		boolean validContinueRow = true;
		boolean validContinueCol = true;
		
		List<LetterPosition> usedLetters = new ArrayList<LetterPosition>();
		
		System.out.println("\n\nENTER LETTERS FROM RIGHT TO LEFT OR UP TO DOWN!!!!\n\n");
		do {
			System.out.println("Choose a letter to place in order to make a word");
			row         = GetUserInput.getUsetIntgerInput(0, rows - 1, "Enter letter row number", consoleReader);
			column      = GetUserInput.getUsetIntgerInput(0, columns - 1, "Enter letter column number", consoleReader);
			letterIndex = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "Enter the index of the wanted letter", consoleReader);
	
			//check if cell already taken
			if (board.isCellFree(row, column) == false) {
				System.out.println("This cell is already taken - you lost your turn");
				return;
			}
			
			//add letter to board
			board.insertLetter(row, column, player.getLetter(letterIndex));
			usedLetters.add(new LetterPosition(row, column, player.getLetter(letterIndex)));
			player.removeLetter(letterIndex);
			
			board.printBoard();
			player.printPlayerLetters();
			System.out.println();
			
			do {
				addMoreLetters = GetUserInput.getUserCharInput("Do you want to place another letter?(y,n)", consoleReader);
				if ((addMoreLetters == 'n') || (addMoreLetters == 'y')) {
					validInput = true;
				}
				else {
					System.out.println("Please enter y/n");
				}
			} while (validInput == false);
			
		} while ((addMoreLetters == 'y') && (player.getNumberOfLetters() > 0)); 
		
		if ((usedLetters.size() == 1) && (!(board.hasNeigbours(usedLetters.get(0).row, usedLetters.get(0).col)))) {
			System.out.println("The given letter has no neigbours - you lost you turn");
			board.removeLetter(usedLetters.get(0).row, usedLetters.get(0).col);
			player.insertLetter(usedLetters.get(0).letter);
			return;
		}
		
		//check that the given letter list is valid
		for (int i = 1; i < usedLetters.size(); i++) {
			if (usedLetters.get(i).row != usedLetters.get(i - 1).row) {
				validByRows = false;
			}
			else {
				validContinueRow = board.hasleftNiegbour(usedLetters.get(i).row, usedLetters.get(i).col);
			}
			if (usedLetters.get(i).col != usedLetters.get(i - 1).col) {
				validByCols = false;
			}
			else {
				validContinueCol = board.hasUpperNiegbour(usedLetters.get(i).row, usedLetters.get(i).col);
			}
		}
		if (((validByCols == false) && (validByRows == false)) || 
			((validByRows == true) && (validContinueRow == false)) ||
			((validByCols == true) && (validContinueCol == false))) {
			System.out.println("Your letters do not placed by one colunm or one row or you have holes in your word- you lost your turn");
			for (int i = 0; i < usedLetters.size(); i++) {
				board.removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter);
			}
			return;
		}
		
		userWord = getWordBasic(usedLetters.get(0).row, usedLetters.get(0).col, validByRows, validByCols, usedLetters.size());

		
		if (userWord != null) {
			for (int i = 0; i < usedLetters.size(); i++) {
				player.insertLetter(lettersSet.getLetter());
			}
			player.setScore(userWord.length());
			System.out.println("Very Good - you made the word: " + userWord + ". You gained " + userWord.length() + " more pointes");
		}
		else {
			for (int i = 0; i < usedLetters.size(); i++) {
				board.removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter);
			}
			System.out.println("Your word does not exist in the dictionary - you lost your turn");
		}
		
	}

	private static String getWordBasic(int row, int column, boolean validByRows, boolean validByCols,int wordLength) {
		int rowUpperBound     = row;
		int rowLowerBound     = row;
		int colUpperBound     = column;
		int colLowerBound     = column;
		String rowLogestWord  = null;
		String colLogestWord  = null;
		String boardString    = null;
		
		//find the last not empty cell of the column
		for(int i = row + 1; i < rows; i++) {
			if (board.isCellFree(i , column)) {
				rowUpperBound = i - 1;
				break;
			}
		}
		
		//find the first not empty cell of the column
		for(int i = row - 1; 0 <= i; i--) {
			if (board.isCellFree(i , column)) {
				rowLowerBound = i + 1;
				break;
			}
		}
		
		for(int i = column + 1; i < columns; i++) {
			if (board.isCellFree(row , i)) {
				colUpperBound = i - 1;
				break;
			}
		}
		
		for(int i = column - 1; 0 <= i; i--) {
			if (board.isCellFree(row , i)) {
				colLowerBound = i + 1;
				break;
			}
		}
		
		if ((validByCols) && (rowLowerBound < rowUpperBound)) {
			boardString = board.getWord(rowLowerBound, column, rowUpperBound, column);
			colLogestWord = dictionary.getLongesrWord(boardString, row - rowLowerBound, row - rowLowerBound - 1 + wordLength);
		}
		if ((validByRows) && (colLowerBound < colUpperBound)) {
			boardString = board.getWord(row, colLowerBound, row, colUpperBound);
			rowLogestWord = dictionary.getLongesrWord(boardString, column - colLowerBound, column - colLowerBound - 1 + wordLength);
		}
		
		if ((colLogestWord == null) && (rowLogestWord == null)) {
			return null;
		}
		if (rowLogestWord == null) {
			return colLogestWord;
		}
		if (colLogestWord == null) {
			return rowLogestWord;
		}
		
		return ((rowLogestWord.length() > colLogestWord.length()) ? rowLogestWord : colLogestWord);
	}

	private static void throwLetter(Player player) {
		int wantedLetter = 0;
		
		char changeMore = 0;
		boolean validInput = false;
		
		for (int i = 0; (i < 3) && (changeMore != 'n'); i++) {
			wantedLetter = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "Enter the number of letter you want to change", consoleReader);
			player.removeLetter(wantedLetter);
			player.insertLetter(lettersSet.getLetter());
			player.printPlayerLetters();
			System.out.println();
			if (i < 2) {	
				do {
					changeMore = GetUserInput.getUserCharInput("Do you want to change another letter (you have " + (3 - i -1) + " more changes)?(y/n)", consoleReader);
					if ((changeMore == 'n') || (changeMore == 'y')) {
						validInput = true;
					}
					else {
						System.out.println("Input not valid");
					}
				} while (validInput == false);
			}
		}
		
	}

	private static boolean checkIfValidName(String name) {
		if (name == null || "".equals(name) || name.startsWith(" "))
			return false;
		return true;
	}
	
	
	private static void createPlayersList() {
		for (int i = 1; i < numberOfPlayers + 1; i++) {
			String playerName = null;
			
			try {
				do {
					System.out.print("Enter Name Of Player(Length less than 50) " + i + ":");
					playerName = consoleReader.readLine();
				} while (playerName.length() > maxNameLength || !checkIfValidName(playerName));
				
				Player newPlayer = new Player(playerName);
				
				for (int j = 0; j < 7; j++) {
					newPlayer.insertLetter(lettersSet.getLetter());
				}
				playerList.add(newPlayer);
			} catch (IOException e) {
				System.out.println("IO Error");
			}						
		}
	}

	private static void getNumberOfPlayers() {
		numberOfPlayers = GetUserInput.getUsetIntgerInput(1, 4,"WELLCOME TO SCRABBLE!!!!!\n\n Enter Number Of Players(1 - 4)", consoleReader);
	}
	
	private static void printExitScreen() {
		/*int maxScore = -1;
		int maxScorePlayer = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (maxScore < playerList.get(i).getScore()) {
				maxScore = playerList.get(i).getScore();
				maxScorePlayer = i;
			}
			System.out.println("Player: " + playerList.get(i).getName() + " scored: " + playerList.get(i).getScore());
		}*/
		int maxScorePlayer = printPlayersScores();
		System.out.println("The winner is: " + playerList.get(maxScorePlayer).getName());
		System.out.println("\n\n\n");
	}
	
	private static class LetterPosition {
		int row;
		int col;
		char letter;
		
		private LetterPosition(int row, int col, char letter) {
			this.row    = row;
			this.col    = col;
			this.letter = letter;
		}
	}
	
	/*public static String getPath(){
		File f = new File("src/");
		if (f.exists())
			return "src/";
		return "";
		
	}*/
	
	/* Prints current scores for all players.
	 * Returns index of current winner of the game.
	 * */
	private static int printPlayersScores()
	{
		int maxScore = -1;
		int maxScorePlayer = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (maxScore < playerList.get(i).getScore()) {
				maxScore = playerList.get(i).getScore();
				maxScorePlayer = i;
			}
			System.out.println("Player: " + playerList.get(i).getName() + " scored: " + playerList.get(i).getScore());
		}
		return maxScorePlayer;
	}
	
	private static void printInfo()
	{
		int currentWinner = printPlayersScores();
		System.out.println("\nCurret Winner is: " + playerList.get(currentWinner).getName());
		System.out.println("Total letters left: " + lettersSet.getLetterSetSize() );
		turnInd--;
	}
}
