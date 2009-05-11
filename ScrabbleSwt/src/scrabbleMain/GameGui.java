package scrabbleMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import resources.resConfig;
import Gui.NewGameDialog.PlayerInfo;

public class GameGui {
	public static GameLogic G = new GameLogic();
	
	
	
	public static boolean loadGame(String currentName) {
		boolean succ = false;

		if (!checkIfExist(currentName))
		{
			return succ;
		}
		
		try {
			FileInputStream file = new FileInputStream(currentName);
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
			G.setAp(gameEntity.getAp()); //add for auto player
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
	
//	private static boolean checkIfValidName(String name) {
//		if (name == null || "".equals(name) || name.startsWith(" "))
//			return false;
//		return true;
//	}
	
	public static boolean checkIfExist(String fileName){
		
		File file = new File(fileName);
		return file.exists();		
	}
	
	public static boolean saveCurrentGame(String currentName) {

		//check if such a game already exists.
		if(checkIfExist(currentName))
		{
			//NewGUI.OverWriteScreen.startOverwriteScreen(currentName);
			//boolean ans = NewGUI.OverWriteScreen.getAns();
			boolean ans = G.mainWindow.showMessageDialog("This File is already exist. Would you like to overwrite "+currentName+"?", "overwrite file");
			if (!ans)
			{
				
				//otherwise, play the turn again

				//G.setTurnInd(G.getTurnInd() - 1);
				return false;
			}
		}
	
		if (!currentName.endsWith(".scrabble"))
			currentName += ".scrabble";
		//updated for auto player
		GameEntity gameEntity = new GameEntity(G.getPlayerList(), G.getLettersSet(), G.getBoard(), G.getTurnInd(), G.getMode(), G.getAp());
		try {
			FileOutputStream file = new FileOutputStream(currentName);		  
			ObjectOutputStream data = new ObjectOutputStream(file);
			
			data.writeObject(gameEntity);
			data.close();
			file.close();
			
//			System.out.println("The game: " + currentName + " has been successfully saved.\n");
		} catch (FileNotFoundException e) {
			System.out.println("File Error while saving.");
		} catch (IOException e) {
			System.out.println("IOE Exception while saving.");
		}
		//after saving the game, player get to play again
		//G.setTurnInd(G.getTurnInd() - 1);;
		G.setIsSaved(true);
		return true;
	}

	public static GameLogic getG() {
		return G;
	}
	
	public static String parseFileToString(String FileName) {
		StringBuffer str = new StringBuffer();
		String line = null;
		InputStream input = resConfig.getImageStream(FileName);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(input));

			while ((line = in.readLine()) != null) {
				str.append(line + "\n");
			}
		} catch (IOException e) {
			System.out
					.println("IO Error. Loading the help file failed. Please try again later");
		}

		return str.toString();

	}
	
	public static void initGameLogic() {
		G = new GameLogic();
	}

	public static void setNumberOfPlayers(int numOfPlayers) {
		G.setNumberOfPlayers(numOfPlayers);
		// System.out.println(G.getNumberOfPlayers());
	}

	public static void createPlayerList(String[] playerNames) {
		for (int i = 0; i < G.getNumberOfPlayers(); i++) {
			Player newPlayer = new Player(playerNames[i]);
			for (int j = 0; j < 7; j++) {
				newPlayer.insertLetter(G.getLettersSet().getLetter(), j);
			}
			G.getPlayerList().add(newPlayer);
			// System.out.println(G.getPlayerList().get(i).getName());
		}
	}
	
	public static void createPlayerList(PlayerInfo[] playerInfo) {
		for (int i = 0; i < G.getNumberOfPlayers(); i++) {
			Player newPlayer = new Player(playerInfo[i].getPlayerName(), playerInfo[i].isAuto());
			for (int j = 0; j < 7; j++) {
				newPlayer.insertLetter(G.getLettersSet().getLetter(), j);
			}
			G.getPlayerList().add(newPlayer);
			// System.out.println(G.getPlayerList().get(i).getName());
		}
	}
	
	public static void setGameMode(int gameMode) {
		G.setMode(((gameMode == 0) ? 'b' : 'a'));
		
	}
	public static void setLetterMode(int LetterMode) {
		G.setLetterMode(LetterMode);
		}
	private static int numberOfLetterChangesLeft = 0;
	
	public static void initNumberOfChanges() {
		numberOfLetterChangesLeft = 0;
	}
	
	public static void changeOneLetter(int index) {
		Player currentPlayer = G.getPlayerList().get(G.getTurnInd());
		if (numberOfLetterChangesLeft >= 3) {
			G.mainWindow.setPlayStatusText("You commited 3 changes, press Done buttun to next turn");
			return;
		}
		if (G.getLettersSet().getLetterSetSize() > 0) {
			currentPlayer.removeLetter(index);
			currentPlayer.insertLetter(G.getLettersSet().getLetter(), index);
			numberOfLetterChangesLeft++;
			G.mainWindow.setPlayStatusText("You have " + (3 - numberOfLetterChangesLeft) + " more changes");
		}
		else {
			G.mainWindow.setPlayStatusText("No more letters in the Letters sack");
		}
		
		
	}
	
	public static class LP {
		private int row;
		private int col;
		private char letter;
		private int index;
		
		public LP(int row, int col, char letter, int index) {
			this.row    = row;
			this.col    = col;
			this.letter = letter;
			this.index  = index;
		}
	}
	
	private static List<LP> usedLetters = null;
	
	public static void initUsedLetters() {
		usedLetters = new ArrayList<LP>();
	}
	public static void addLetterToBoardBasic(int x, int y, int index) {
		Player player = GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd());
		//check if cell already taken
		if (G.getBoard().isCellFree(x, y) == false) {
		    //update player that cell is not empty
			return;
		}
		
		G.getBoard().insertLetter(x, y, player.getLetter(index));
//		usedLetters.add(new LetterPosition(x, y, player.getLetter(index)));
		LP lp = new LP(x, y, player.getLetter(index), index);
//		if (lp == null) {System.out.println("bla");}
		usedLetters.add(lp);
		player.removeLetter(index);
	}
	
	public static boolean placeWordBasic() {
		Player player = GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd());
		String userWord;
		boolean ret = false;
		if ((usedLetters.size() == 1) && (!(G.getBoard().hasNeigbours(usedLetters.get(0).row, usedLetters.get(0).col)))) {
			G.mainWindow.setPlayStatusText("Your placed letter has no neigbours - you lost you turn");
			G.getBoard().removeLetter(usedLetters.get(0).row, usedLetters.get(0).col);
			player.insertLetter(usedLetters.get(0).letter, usedLetters.get(0).index);
			return false;
		}
		
		boolean validByRows      = true;
		boolean validByCols      = true;
		boolean validContinueRow = true;
		boolean validContinueCol = true;
		
		//check that the given letter list is valid, i.e all in one col or one row and using an existing letter
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
			G.mainWindow.setPlayStatusText(player.getName() + ", your letters do not placed by one colunm or one row or you have holes in your word- you lost your turn");
			for (int i = 0; i < usedLetters.size(); i++) {
				G.getBoard().removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter, usedLetters.get(i).index);
			}
			return false;
		}
		
		userWord = getWordBasic(usedLetters.get(0).row, usedLetters.get(0).col, validByRows, validByCols, usedLetters.size());

		
		if (userWord != null) {
			for (int i = 0; i < usedLetters.size(); i++) {
				if (G.getLettersSet().getLetterSetSize() > 0) {
					player.insertLetter(G.getLettersSet().getLetter(), usedLetters.get(i).index);
				}
				else { //no more letters, game finished
					break;
				}
			}	
			player.setScore(userWord.length());
			ret = true;
//			System.out.println("Very Good - you made the word: " + userWord + ". You gained " + userWord.length() + " more pointes");
			G.mainWindow.setPlayStatusText("Very Good - " + player.getName() + " made the word: " + userWord + ". You gained " + userWord.length() + " more pointes");
		}
		else {
			for (int i = 0; i < usedLetters.size(); i++) {
				G.getBoard().removeLetter(usedLetters.get(i).row, usedLetters.get(i).col);
				player.insertLetter(usedLetters.get(i).letter, usedLetters.get(i).index);
				//add for auto player
				if (scrabbleMain.AutoPlayer.isCndidate(usedLetters.get(i).row, usedLetters.get(i).col, true) == true) {
					G.getAp().addLetterVertical(usedLetters.get(i).row, usedLetters.get(i).col);
				}
				if (scrabbleMain.AutoPlayer.isCndidate(usedLetters.get(i).row, usedLetters.get(i).col, false) == true) {
					G.getAp().addLetterHorizonal(usedLetters.get(i).row, usedLetters.get(i).col);
				}
			}
//			System.out.println("Your word does not exist in the dictionary - you lost your turn");
			G.mainWindow.setPlayStatusText(player.getName() + ", your word does not exist in the dictionary - you lost your turn");
		}
		return ret;
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
		for(int i = row + 1; i < GameLogic.ROWS; i++) {
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
		
		for(int i = column + 1; i < GameLogic.COLUMNS; i++) {
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
	
	public static void updateRecordList() {
		    if(G.getMode()=='b'){
			if(!(G.getPlayerList().size()==0)){
			for(Player player : G.getPlayerList()){
				G.getRecordList().updatePlayer(player.getName(),player.getScore());}
			}
		    }else{if(!(G.getPlayerList().size()==0)){
				for(Player player : G.getPlayerList()){
					G.getRecordListAdvanced().updatePlayer(player.getName(),player.getScore());}
		    }}
	}
	
	public static void UploadrecordList(char a){
		FileInputStream file;
		try {
			if(a == 'a'){
                file = new FileInputStream(gameDirectories.getAdvancedRecordsFullFileName());   
			}else {
                file = new FileInputStream(gameDirectories.getBasicRecordsFullFileName());
			}
			ObjectInputStream data = new ObjectInputStream(file);
			if(a=='b'){
		    G.setRecordList((RecordList) data.readObject());
			}
			if(a=='a'){
			 G.setRecordListAdvanced((RecordList) data.readObject());
			}
			data.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error while loading.");
		} catch (IOException e) {
			System.out.println("IO Exception while loading updateRecordList.");
		} catch (ClassNotFoundException e) {
			System.out.println("Cast problem while loading.");
		}
		
	}
	
	public static void saveRecordList(char a){
		FileOutputStream fileo;
		try {
			if(a == 'a'){
                fileo = new FileOutputStream(gameDirectories.getAdvancedRecordsFullFileName());   
			}else {
                fileo = new FileOutputStream(gameDirectories.getBasicRecordsFullFileName());
			}
			ObjectOutputStream data = new ObjectOutputStream(fileo);
//			recordList.updatePlayer("First Player", 10);
			if(a=='a')
				data.writeObject(G.getRecordList());
			if(a=='b')
				data.writeObject(G.getRecordListAdvanced());
			data.close();
			fileo.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("IO error - File not found. The record list will not be printed - try again later");
		} catch (IOException e) {
			System.out.println("IO error. The record list will not be printed - try again later");			
			}
		
	}
	public static String printRecordListToLabel(char a) {
		
		StringBuffer recordListString = new StringBuffer();
		String open = "Top Scores"+"\n"+"-----------------" + "\n";
		recordListString.append(open);
		recordListString.append("          " + "\n");
		if(a=='b'){
		for (int key : G.getRecordList().getRecordList().descendingKeySet()) {
			for(String name:G.getRecordList().getRecordList().get(key)){
				recordListString.append(name + "  ");
				recordListString.append(key+ "\n");
			}
		} 
		}
		if(a=='a'){
			for (int key : G.getRecordListAdvanced().getRecordList().descendingKeySet()) {
				for(String name:G.getRecordListAdvanced().getRecordList().get(key)){
					recordListString.append(name + "  ");
					recordListString.append(key+ "\n");
				}
			} 
		}

		return recordListString.toString();
	}


	public static void moveToNextPlayer() {
		G.setTurnInd((G.getTurnInd()+ 1) % G.getNumberOfPlayers());
	}

	public static void addLetterToBoardAdvanced(int row, int column, int index) {
		Player player = GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd());
		if ((G.getBoard().hasNeigbours(row, column) == false) || (G.getBoard().isCellFree(row, column) == false)) {
			return;
		}
		G.getBoard().insertLetter(row, column, player.getLetter(index));
		
	}

	public static void placeAutoWord() {
		Player player = GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd());
		String retWord = G.getAp().placeAutoWordAndUpdate(player);
		if (retWord != null) {
//			for (int i = 0; i < 3; i++) {
//				if (G.getLettersSet().getLetterSetSize() > 0) {
//					player.getPlayerLetters().compresSet();
//					player.insertLetter(G.getLettersSet().getLetter());
//				}
//				else {
//					break;
//				}
//			}
			player.getPlayerLetters().completeLetters(G);
			player.setScore(retWord.length());
			G.mainWindow.setPlayStatusText("Auto player " + player.getName() + " placed the word: " + retWord + " and won " + retWord.length() + "points");
		}
		else {
			G.mainWindow.setPlayStatusText("Auto player " + player.getName() + " failed to place a word");
		}
	}
	
}
