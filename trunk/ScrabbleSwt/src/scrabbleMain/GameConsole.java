package scrabbleMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//import scrabbleMain.Game.LetterPosition;

public class GameConsole {
	private static GameLogic G = new GameLogic();

	public static void consoleMain() {
		int returnStartInputValue = 0;
		
		System.out.println("WELCOME TO SCABBLE CONSOLE");
		
		returnStartInputValue = parseUserStartInput(); 
		
		if (returnStartInputValue == 1)  { // quit the game
			updateRecordList();
			printRecordList();
			return;
		}
		
		while ((G.getLettersSet().getLetterSetSize() > 0) && (G.getFinishGame() == false)) {
			for( ; G.getTurnInd() < G.getNumberOfPlayers(); G.setTurnInd(G.getTurnInd() + 1)) {
			
				System.out.println("\n\nNow playing: " + G.getCurrentPlayerName() + " your score is: " + G.getCurrentPlayerScore());
				System.out.println("\n\n");
				
				G.getBoard().printBoard(G.getMode());
				
				System.out.print("\n\n Your letters are: ");
				System.out.println();
				
				G.printCurrentPlayerLetters();
				
				System.out.println("\n\n");
				
				parseUserInput(G.getTurnInd());
				
				if (G.getFinishGame() == true) {
					break;
				}
			}
			if(G.getNumberOfPlayers() != 0){
				if (G.getTurnInd() % G.getNumberOfPlayers() == 0)
					G.setTurnInd(0);
			}
		}

		saveBeforeExit();
		printExitScreen();
		updateRecordList();
		printRecordList();
	}



	private static void printRecordList() {
		System.out.println("Top Scores\n----------");
		G.getRecordList().printRecordList();
		FileOutputStream file;
		
			try {
				if(G.getMode() == 'a'){
                    file = new FileOutputStream(gameDirectories.getAdvancedRecordsFullFileName());   
				}else {
                    file = new FileOutputStream(gameDirectories.getBasicRecordsFullFileName());
				}
				ObjectOutputStream data = new ObjectOutputStream(file);
//				recordList.updatePlayer("First Player", 10);
				data.writeObject(G.getRecordList());
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
			if(G.getMode() == 'a'){
                file = new FileInputStream(gameDirectories.getAdvancedRecordsFullFileName());   
			}else {
                file = new FileInputStream(gameDirectories.getBasicRecordsFullFileName());
			}
			ObjectInputStream data = new ObjectInputStream(file);
		    G.setRecordList((RecordList) data.readObject());
			data.close();
			file.close();
			if(!(G.getPlayerList().size()==0)){
			for(Player player : G.getPlayerList()){
				G.getRecordList().updatePlayer(player.getName(),player.getScore());
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
			startInput = GetUserInput.getUserCharInput("Enter 'n' for a new game, 'l' for loading a game, 'h' for help or 'q' to exit", G.getConsoleReader());
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
		
		String currentName = GetUserInput.getGameName(G.getConsoleReader());
		boolean succ = false;
		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name ");
			return succ;
		}
		if (!checkIfExist(currentName + G.getFileSuffix()))
		{
			System.out.println("A game named: " + currentName + " does not exists");
			return succ;
		}
		currentName += G.getFileSuffix();
		
		try {
			FileInputStream file = new FileInputStream(gameDirectories.getSavedGamesDirectorty() + "/" + currentName);
			ObjectInputStream data = new ObjectInputStream(file);
			GameEntity gameEntity = (GameEntity)data.readObject();
			data.close();
			file.close();
			
			G.setPlayerList(gameEntity.getPlayerList());
			G.setLettersSet(gameEntity.getLettersSet());
			G.setBoard(gameEntity.getBoard());
			G.setNumberOfPlayers(G.getPlayerList().size());
			G.setTurnInd(gameEntity.turnInd());
			G.setMode(gameEntity.getMode());
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
			G.setMode(GetUserInput.getUserCharInput("Enter 'b' for basic settings and 'a' for advanced", G.getConsoleReader()));
		}while (G.getMode() != 'b' && G.getMode() != 'a');
		
		if (G.getMode() == 'a') {
			G.getBoard().makeAdvancedBoard();
		}
	}
	
	//get the score of the word
	private static int calcScore(int startRow, int startCol, int endRow, int endCol){
		int sum = 0;
		if (startRow == endRow)
			for (int i = startCol; i <= endCol; i++)
				sum += G.getBoard().getScore(startRow, i);
		if (startCol == endCol)
			for (int i = startRow; i <= endRow; i++)
				sum += G.getBoard().getScore(i, startCol);
		return sum;
	}


	private static void parseUserInput(int i) {
		char    currentMove;
		
		boolean validInput = false;
		
		do {
			currentMove = GetUserInput.getUserCharInput("Choose your next move:\n" +
					"t for throwing letters, w for adding a word to board, s for saving the game, h for help screen, i for game-information, q for exit", G.getConsoleReader());
			switch (currentMove) {
			case 't': throwLetter(G.getPlayerList().get(i)); 
					  validInput = true; 
					  G.setIsSaved(false);
					  break;
			case 'w': 
					  if(G.getMode() == 'b') 
						  placeWordBasic(G.getPlayerList().get(i)); 
					  else
						  placeWordAdvanced(G.getPlayerList().get(i));
			          validInput = true; 
			          G.setIsSaved(false);
			          break;
			case 'q': G.setFinishGame(true); 
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
	

	private static void saveBeforeExit()
	{
//		boolean validInput = false;
		char answer;
		while (!(G.getIsSaved()))
		{
			System.out.println("Current game is not saved. Would you like to save the game before exit? ");
			
			answer = GetUserInput.getYesOrNo(G.getConsoleReader());
			
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
		
		String currentName = GetUserInput.getGameName(G.getConsoleReader());

		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name.");
			G.setTurnInd(G.getTurnInd() - 1);
			return;
		}
		currentName += G.getFileSuffix();
		//check if such a game already exists.
		if(checkIfExist(currentName))
		{
			System.out.println("A game with this name already exists.\n\nDo you want to overwrite it?");
			char answer = GetUserInput.getYesOrNo(G.getConsoleReader());
			if (answer == 'n')
			{
				//otherwise, play the turn again
				G.setTurnInd(G.getTurnInd() - 1);
				return;
			}
		}
		
		GameEntity gameEntity = new GameEntity(G.getPlayerList(), G.getLettersSet(), G.getBoard(), G.getTurnInd(), G.getMode());
		try {
			FileOutputStream file = new FileOutputStream(gameDirectories.getSavedGamesDirectorty() + "/" + currentName);
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
		G.setTurnInd(G.getTurnInd() - 1);;
		G.setIsSaved(true);
	}
	

	private static boolean checkIfExist(String fileName){
		
		File file = new File(gameDirectories.getSavedGamesDirectorty() + "/" + fileName);
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
		row         = GetUserInput.getUsetIntgerInput(0, G.ROWS - 1, "enter letter row number", G.getConsoleReader());
		column      = GetUserInput.getUsetIntgerInput(0, G.COLUMNS - 1, "enter letter column number", G.getConsoleReader());
		letterIndex = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "enter the index of the wanted letter", G.getConsoleReader());
		
		if ((G.getBoard().hasNeigbours(row, column) == false) || (G.getBoard().isCellFree(row, column) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		
		startRow = GetUserInput.getUsetIntgerInput(0, G.ROWS - 1, "enter word's start row", G.getConsoleReader());
		startCol = GetUserInput.getUsetIntgerInput(0, G.COLUMNS - 1, "enter word's start column", G.getConsoleReader());
		endRow   = GetUserInput.getUsetIntgerInput(0, G.ROWS - 1, "enter word's end row", G.getConsoleReader());
		endCol   = GetUserInput.getUsetIntgerInput(0, G.COLUMNS - 1, "enter word's end column", G.getConsoleReader());
		
		if ((startRow != endRow) && (startCol != endCol)) {
			System.out.println("Word cordinates not valid - you lost you turn");
			return;
		}
		if (((startRow == endRow) && (endRow != row)) || ((endCol == startCol) && (startCol != column))){
			System.out.println("Word cordinates do not include inserted letter - you lost your turn");
			return;
		}
		
		G.getBoard().insertLetter(row, column, player.getLetter(letterIndex));
		//board.printBoard();
		userWord = G.getBoard().getWord(startRow, startCol, endRow, endCol);
		if (userWord == null) {
			System.out.println("Given indeces are not valid, you lost your turn");
			G.getBoard().removeLetter(row, column);
		}
		if(G.getDictionary().contains(userWord)) {
			int addedPoints = calcScore(startRow, startCol, endRow, endCol);
			player.removeLetter(letterIndex);
			player.insertLetter(G.getLettersSet().getLetter(), letterIndex);
			player.setScore(addedPoints);
			System.out.println("\n\nVery Good - you made the word: " + userWord + ". You gained " + addedPoints + " more pointes\n\n");
		}
		else {
			G.getBoard().removeLetter(row, column);
			System.out.println("Word: "+ userWord + " does not exist in the dictionary");
		}
		
	}

	private static void placeWordBasic(Player player) { 
		int row;
		int column;
//		int maxWordLength = -1;
		int letterIndex;
		String userWord;
//		String maxWord = null;
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
			row         = GetUserInput.getUsetIntgerInput(0, G.ROWS - 1, "Enter letter row number", G.getConsoleReader());
			column      = GetUserInput.getUsetIntgerInput(0, G.COLUMNS - 1, "Enter letter column number", G.getConsoleReader());
			letterIndex = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "Enter the index of the wanted letter", G.getConsoleReader());
	
			//check if cell already taken
			if (G.getBoard().isCellFree(row, column) == false) {
				System.out.println("This cell is already taken - you lost your turn");
				return;
			}
			
			//add letter to board
			G.getBoard().insertLetter(row, column, player.getLetter(letterIndex));
			usedLetters.add(new LetterPosition(row, column, player.getLetter(letterIndex), letterIndex));
			player.removeLetter(letterIndex);
			
			G.getBoard().printBoard(G.getMode());
			player.printPlayerLetters();
			System.out.println();
			
			do {
				addMoreLetters = GetUserInput.getUserCharInput("Do you want to place another letter?(y,n)", G.getConsoleReader());
				if ((addMoreLetters == 'n') || (addMoreLetters == 'y')) {
					validInput = true;
				}
				else {
					System.out.println("Please enter y/n");
				}
			} while (validInput == false);
			
		} while ((addMoreLetters == 'y') && (player.getNumberOfLetters() > 0)); 
		
		if ((usedLetters.size() == 1) && (!(G.getBoard().hasNeigbours(usedLetters.get(0).row, usedLetters.get(0).col)))) {
			System.out.println("One of your given letter has no neigbours - you lost you turn");
			G.getBoard().removeLetter(usedLetters.get(0).row, usedLetters.get(0).col);
			player.insertLetter(usedLetters.get(0).letter, letterIndex);
			return;
		}
		
		//check that the given letter list is valid
		for (int i = 1; i < usedLetters.size(); i++) {
			if (usedLetters.get(i).row != usedLetters.get(i - 1).row) {
				validByRows = false;
			}
			else {
				validContinueRow = G.getBoard().hasleftNiegbour(usedLetters.get(i).row, usedLetters.get(i).col);
			}
			if (usedLetters.get(i).col != usedLetters.get(i - 1).col) {
				validByCols = false;
			}
			else {
				validContinueCol = G.getBoard().hasUpperNiegbour(usedLetters.get(i).row, usedLetters.get(i).col);
			}
		}
		if (((validByCols == false) && (validByRows == false)) || 
			((validByRows == true) && (validContinueRow == false)) ||
			((validByCols == true) && (validContinueCol == false))) {
			System.out.println("Your letters do not placed by one colunm or one row or you have holes in your word- you lost your turn");
			for (int i = 0; i < usedLetters.size(); i++) {
				G.getBoard().removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter, usedLetters.get(i).index);
			}
			return;
		}
		
		userWord = getWordBasic(usedLetters.get(0).row, usedLetters.get(0).col, validByRows, validByCols, usedLetters.size());

		
		if (userWord != null) {
			for (int i = 0; i < usedLetters.size(); i++) {
				player.insertLetter(G.getLettersSet().getLetter(), usedLetters.get(i).index);
			}
			player.setScore(userWord.length());
			System.out.println("Very Good - you made the word: " + userWord + ". You gained " + userWord.length() + " more pointes");
		}
		else {
			for (int i = 0; i < usedLetters.size(); i++) {
				G.getBoard().removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter, usedLetters.get(i).index);
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
		for(int i = row + 1; i < G.ROWS; i++) {
			if (G.getBoard().isCellFree(i , column)) {
				rowUpperBound = i - 1;
				break;
			}
		}
		
		//find the first not empty cell of the column
		for(int i = row - 1; 0 <= i; i--) {
			if (G.getBoard().isCellFree(i , column)) {
				rowLowerBound = i + 1;
				break;
			}
		}
		
		for(int i = column + 1; i < G.COLUMNS; i++) {
			if (G.getBoard().isCellFree(row , i)) {
				colUpperBound = i - 1;
				break;
			}
		}
		
		for(int i = column - 1; 0 <= i; i--) {
			if (G.getBoard().isCellFree(row , i)) {
				colLowerBound = i + 1;
				break;
			}
		}
		
		if ((validByCols) && (rowLowerBound < rowUpperBound)) {
			boardString = G.getBoard().getWord(rowLowerBound, column, rowUpperBound, column);
			colLogestWord = G.getDictionary().getLongesrWord(boardString, row - rowLowerBound, row - rowLowerBound - 1 + wordLength);
		}
		if ((validByRows) && (colLowerBound < colUpperBound)) {
			boardString = G.getBoard().getWord(row, colLowerBound, row, colUpperBound);
			rowLogestWord = G.getDictionary().getLongesrWord(boardString, column - colLowerBound, column - colLowerBound - 1 + wordLength);
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
			wantedLetter = GetUserInput.getUsetIntgerInput(0, player.getNumberOfLetters() - 1, "Enter the number of letter you want to change", G.getConsoleReader());
			player.removeLetter(wantedLetter);
			player.insertLetter(G.getLettersSet().getLetter(), wantedLetter);
			player.printPlayerLetters();
			System.out.println();
			if (i < 2) {	
				do {
					changeMore = GetUserInput.getUserCharInput("Do you want to change another letter (you have " + (3 - i -1) + " more changes)?(y/n)", G.getConsoleReader());
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
		for (int i = 1; i < G.getNumberOfPlayers() + 1; i++) {
			String playerName = null;
			
			try {
				do {
					System.out.print("Enter Name Of Player(Length less than 20) " + i + ":");
					playerName = G.getConsoleReader().readLine();
				} while (playerName.length() > G.MAX_NAME_LENGTH || !checkIfValidName(playerName));
				
				Player newPlayer = new Player(playerName);
				
				for (int j = 0; j < 7; j++) {
					newPlayer.insertLetter(G.getLettersSet().getLetter(), j);
				}
				G.getPlayerList().add(newPlayer);
			} catch (IOException e) {
				System.out.println("IO Error");
			}						
		}
	}

	private static void getNumberOfPlayers() {
		G.setNumberOfPlayers(GetUserInput.getUsetIntgerInput(1, 4,"WELLCOME TO SCRABBLE!!!!!\n\n Enter Number Of Players(1 - 4)", G.getConsoleReader()));
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
		System.out.println("The winner is: " + G.getPlayerList().get(maxScorePlayer).getName());
		System.out.println("\n\n\n");
	}
	
	private static class LetterPosition {
		int row;
		int col;
		char letter;
		int index;
		
		private LetterPosition(int row, int col, char letter, int index) {
			this.row    = row;
			this.col    = col;
			this.letter = letter;
			this.index  = index;
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
		for (int i = 0; i < G.getNumberOfPlayers(); i++) {
			if (maxScore < G.getPlayerList().get(i).getScore()) {
				maxScore = G.getPlayerList().get(i).getScore();
				maxScorePlayer = i;
			}
			System.out.println("Player: " + G.getPlayerList().get(i).getName() + " scored: " + G.getPlayerList().get(i).getScore());
		}
		return maxScorePlayer;
	}
	
	private static void printInfo()
	{
		int currentWinner = printPlayersScores();
		System.out.println("\nCurret Winner is: " + G.getPlayerList().get(currentWinner).getName());
		System.out.println("Total letters left: " + G.getLettersSet().getLetterSetSize() );
		G.setTurnInd(G.getTurnInd() - 1);;
	}
}
