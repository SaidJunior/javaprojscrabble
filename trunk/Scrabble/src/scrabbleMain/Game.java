package scrabbleMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
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
	static char mode;  //the rules
	private static RecordList     recordList      =new RecordList(new TreeMap<Integer,LinkedList<String>>());
	
	//Path to hold all saved games at.
	private static String savedGamesPath = "src/Saved_Games/";
	private static String savedRecordList ="src/RecordList/fileRecordList";
	
	public static void main(String[] args) {
		int returnStartInputValue;
		System.out.println("WELLCOME TO SCABBLE");
		returnStartInputValue = parseUserStartInput(); 
		
		if (returnStartInputValue == 1)  { // quit the game
			printRecordList();
			return;
		}
		
		while ((lettersSet.getLetterSetSize() > 0) && (finishGame == false)) {
			for( ; turnInd < numberOfPlayers; turnInd++) {
			
				System.out.println("Now playing: " + playerList.get(turnInd).getName() + " your score is: " + playerList.get(turnInd).getScore());
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
			if (turnInd % numberOfPlayers == 0)
				turnInd = 0;
		}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			for(Player player:playerList){
				recordList.updatePlayer(player.getName(),player.getScore());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Error while loading.");
			parseUserStartInput();
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOE Exception while loading updateRecordList.");
			
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Cast problem while loading.");
			parseUserStartInput();
			//e.printStackTrace();
		}
	}



	private static int parseUserStartInput() { //ask the user if to start a new game or to load 
		char startInput = 0;
		boolean validInput = false;
		
		do {
			startInput = getUserCharInput("Enter 'n' for a new game, 'l' for loading a game, 'h' for help or 'q' to exit");
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
			          validInput = true;
			          break;
			
			case 'q': return 1;
			
			default : System.out.println("input is not valid, please try again");
			}
			 
		} while (validInput == false);
		
		return 0;
	}

	private static boolean loadGame() {
		
		String currentName = getGameName();
		boolean succ = false;
		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name. ");
			return succ;
		}
		if (!checkIfExist(currentName))
		{
			System.out.println("A game named: " + currentName + " does not exists.");
			return succ;
		}
					
		try {
			FileInputStream file = new FileInputStream(savedGamesPath + currentName);
			ObjectInputStream data = new ObjectInputStream(file);
			GameEntity gameEntity= (GameEntity) data.readObject();
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
			mode = getUserCharInput("Enter 'b' for basic settings and 'a' for advanced");
		}while (mode != 'b' && mode != 'a');
		
		if (mode == 'a')
			makeAdvancedBoard();
	}

	private static void makeAdvancedBoard(){
		int []oddsArray = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		Random generator = new Random();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				board.setScore(i, j, oddsArray[generator.nextInt(10)]);
	}
	
	//get the score of the word
	private static int getScore(int startRow, int startCol, int endRow, int endCol){
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
			currentMove = getUserCharInput("choose your next move: t for throwing letters, w for adding a word to board, s for saving the game, q for exit");
			switch (currentMove) {
			case 't': throwLetter(playerList.get(i)); 
					  validInput = true; 
					  break;
			case 'w': 
					  if(mode == 'b') 
						  placeWordExtra(playerList.get(i)); //change this to wordBasic
					  else
						  placeWordExtra(playerList.get(i)); 
			          validInput = true; 
			          break;
			case 'q': finishGame = true; 
			          validInput = true; 
			          break;
			case 'h': printHelpScreen();
					  validInput = true;
					  break;
			case 's': saveCurrentGame();
			          validInput = true;
			          break;
			default: System.out.println("input is not valid, please try again");
			}
		} while (validInput == false);
	}
	
	

	private static void saveCurrentGame() {
		
		String currentName = getGameName();
		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name.");
			turnInd--;
			return;
		}
		//check if such a game already exists.
		if(checkIfExist(currentName))
		{
			System.out.println("A game with this name already exists.\n\nPlease type y if you want to overwrite it.");			
			try {
				String answer= consoleReader.readLine();
				if(!"y".equals(answer)){
					//otherwise, play the turn again
					turnInd--;
					return;
				}
				
			} catch (IOException e) {
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
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOE Exception while saving.");
			//e.printStackTrace();
		}
		//after saving the game, player get to play again
		turnInd--;
	}
	

/* Helper function. Checks if a file exists before saving it as a game.
 * */
	public static boolean checkIfExist(String fileName){
		
		File file=new File(savedGamesPath + fileName);
		return file.exists();		
	}


	private static void printHelpScreen() {
		// 
		
	}


/*
	private static void placeWord(Player player) {
		int rowCurrent;
		int columnCurrent;
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		int letterIndex;
		char addMore = 0;
		boolean validInput = false;
		List<Character> addedLetters = new ArrayList<Character>();

		String userWord;
		
		startRow    = getUsetIntgerInput(0, rows, "enter row number");
		startCol    = getUsetIntgerInput(0, columns, "enter column number");
		letterIndex = getUsetIntgerInput(0, player.getNumberOfLetters(), "enter the index of the wanted letter");
		
		if ((board.hasNeigbours(startRow, startCol) == false) || (board.isCellFree(startRow, startCol) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		board.insertLetter(startRow, startCol, player.getLetter(letterIndex));
		
		for (int i = 1; (i < player.getNumberOfLetters()) && (addMore != 'n'); i++){	
			do {
				addMore = getUserCharInput("Do you want to add another letter?(y/n)");
				if ((addMore == 'n') || (addMore == 'y')) {
					validInput = true;
				}
				else {
					System.out.println("Input not valid");
				}
			} while (validInput == false);
		}
		rowCurrent    = getUsetIntgerInput(0, rows, "enter row number");
		columnCurrent = getUsetIntgerInput(0, columns, "enter column number");
		letterIndex   = getUsetIntgerInput(0, player.getNumberOfLetters(), "enter the index of the wanted letter");
		
		if ((board.hasNeigbours(rowCurrent, columnCurrent) == false) || (board.isCellFree(rowCurrent, columnCurrent) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		
		
		board.insertLetter(rowCurrent, columnCurrent, player.getLetter(letterIndex));
		
		
		if(dictionary.contains(userWord)) {
			player.removeLetter(letterIndex);
			player.insertLetter(lettersSet.getLetter());
			player.setScore(userWord.length());
		}
		else {
			board.removeLetter(rowCurrent, columnCurrent);
			System.out.println("Word: "+ userWord + " does not exist in the dictionary");
		}
	}
	*/
	private static void placeWordExtra(Player player) { //this function will be an extra rule, currently not in use
		int row;
		int column;
		int letterIndex;
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		String userWord;
		
		row    = getUsetIntgerInput(0, rows, "enter row number");
		column = getUsetIntgerInput(0, columns, "enter column number");
		letterIndex = getUsetIntgerInput(0, player.getNumberOfLetters(), "enter the index of the wanted letter");
		
		if ((board.hasNeigbours(row, column) == false) || (board.isCellFree(row, column) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		
		startRow = getUsetIntgerInput(0, rows, "enter word's start row");
		startCol = getUsetIntgerInput(0, columns, "enter word's start column");
		endRow   = getUsetIntgerInput(0, rows, "enter word's end row");
		endCol   = getUsetIntgerInput(0, columns, "enter word's end column");
		
		board.insertLetter(row, column, player.getLetter(letterIndex));
		//board.printBoard();
		userWord = board.getWordExtra(startRow, startCol, endRow, endCol);
		if (userWord == null) {
			System.out.println("given indeces are not valid, you lost your turn");
			board.removeLetter(row, column);
		}
		if(dictionary.contains(userWord)) {
			player.removeLetter(letterIndex);
			player.insertLetter(lettersSet.getLetter());
			//player.setScore(userWord.length());
			player.setScore(getScore(startRow, startCol, endRow, endCol));
		}
		else {
			board.removeLetter(row, column);
			System.out.println("Word: "+ userWord + " does not exist in the dictionary");
		}
	}



	private static int getUsetIntgerInput(int min, int max, String message) {
		boolean validInput = false;
		int inputInt    = 0;
		System.out.println(message);
		do {
			try {
				inputInt = Integer.parseInt(consoleReader.readLine());
				if ((inputInt >= min) && (inputInt < max)) {
					break;
				}
				else {
					System.out.println("Number of row should be " + min + " to " + max + " please enter again");
				}
			} catch (IOException e) {
				System.out.println("IO Error, try again");
			} catch (NumberFormatException e) {
				System.out.println("Input is not a valid number, please enter again");
			}
		}  while (validInput == false);
		return inputInt;
	}


	private static void throwLetter(Player player) {
		int wantedLetter = 0;
		
		char changeMore = 0;
		boolean validInput = false;
		
		for (int i = 0; (i < 3) && (changeMore != 'n'); i++) {
			wantedLetter = getUsetIntgerInput(0, player.getNumberOfLetters(), "Enter the number of letter you want to change");
			player.removeLetter(wantedLetter);
			player.insertLetter(lettersSet.getLetter());
			player.printPlayerLetters();
			System.out.println();
			if (i < 2) {	
				do {
					changeMore = getUserCharInput("Do you want to change another letter (you have " + (3 - i -1) + " more changes)?(y/n)");
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


	private static char getUserCharInput(String message) {
		boolean validInput = false;
		char charInput = 0;
		
		System.out.println(message);
		do {
			try {
				String stringInput = null;
				stringInput = consoleReader.readLine();
				if (stringInput.length() != 1) {
					System.out.println("Input not valid, please enter again");
					continue;
				}
				charInput = stringInput.charAt(0);
				validInput = true;
				
			} catch (IOException e) {
				System.out.println("IO Error, please enter again");
			}
		} while (validInput == false);
		
		return charInput;
	}
	
	private static String getGameName() {
		
		String gameName = null;
		System.out.println("Please enter the name of the game: ");
		
		try {
			gameName = consoleReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gameName;
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
				} while (playerName.length() > maxNameLength);
				
				Player newPlayer = new Player(playerName);
				
				for (int j = 0; j < 7; j++) {
					newPlayer.insertLetter(lettersSet.getLetter());
				}
				playerList.add(newPlayer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
	}

	private static void getNumberOfPlayers() {
		numberOfPlayers = getUsetIntgerInput(1, 4,"WELLCOME TO SCRABBLE!!!!!\n\n Enter Number Of Players(1 - 4)");
	}
	
	private static void printExitScreen() {
		int maxScore = -1;
		int maxScorePlayer = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (maxScore < playerList.get(i).getScore()) {
				maxScore = playerList.get(i).getScore();
				maxScorePlayer = i;
			}
			System.out.println("player: " + playerList.get(i).getName() + " scored: " + playerList.get(i).getScore());
		}
		System.out.println("The winner is: " + playerList.get(maxScorePlayer).getName());
		System.out.println("\n\n\n");
	}

}
