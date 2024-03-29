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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//			if (G == null) System.out.println();
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
			return false;
		} catch (IOException e) {
			System.out.println("IOE Exception while saving.");
			return false;
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
		public void setRow(int row){
			this.row=row;
		}
		public void setCol(int col){
			this.col=col;
		}
		public void setLetter(char letter){
			this.letter = letter;
		}
		public void setIndex(int index){
			this.index = index;
		}
		
		public int getIndex(){
			return this.index;
		}
		
		public char getLetter(){
			return this.letter;
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
	public static void undoLetterToBoard(int x,int y,int index,char letter){
		Player player = GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd());
		
		G.getBoard().deleteLetter(x, y);
		
		int lastElement = usedLetters.size()-1;
		usedLetters.remove(lastElement);
	//	System.out.println("GUI LETTER"+ letter+" i"+index);
		player.insertLetter(letter,index);
	}
	
	public static Map<String, Integer> letterScores = new HashMap<String, Integer>();
	public static void createLetterScores()
	{
		letterScores.put("a", 1);
		letterScores.put("b", 3);
		letterScores.put("c", 3);
		letterScores.put("d", 2);
		letterScores.put("e", 1);
		letterScores.put("f", 4);
		letterScores.put("g", 2);
		letterScores.put("h", 4);
		letterScores.put("i", 1);
		letterScores.put("j", 8);
		letterScores.put("k", 5);
		letterScores.put("l", 1);
		letterScores.put("m", 3);
		letterScores.put("n", 1);
		letterScores.put("o", 1);
		letterScores.put("p", 3);
		letterScores.put("q", 10);
		letterScores.put("r", 1);
		letterScores.put("s", 1);
		letterScores.put("t", 1);
		letterScores.put("u", 1);
		letterScores.put("v", 4);
		letterScores.put("w", 4);
		letterScores.put("x", 8);
		letterScores.put("y", 4);
		letterScores.put("z", 10);
	}

	public static int calcLetterBoardScore(LP let)
	{
		//0=double letter, 1=triple letter, 2=double word, 3=triple word, 4=regular
		switch (let.col)
		{
			case 0:
			{
				switch (let.row)
				{
					case 0:
					{
						return 3;
					}
					case 3:
					{
						return 0;
					}
					case 7:
					{
						return 3;
					}
					case 11:
					{
						return 0;
					}
					case 14:
					{
						return 3;
					}
					default: return 4;
				}
			}
			case 1:
			{
				switch (let.row)
				{
					case 1:
					{
						return 2;
					}
					case 5:
					{
						return 1;
					}
					case 9:
					{
						return 1;
					}
					case 13:
					{
						return 2;
					}
					default: return 4;
				}
			}
			case 2:
			{
				switch (let.row)
				{
					case 2:
					{
						return 2;
					}
					case 6:
					{
						return 0;
					}
					case 8:
					{
						return 0;
					}
					case 12:
					{
						return 2;
					}
					default: return 4;
				}				
			}
			case 3:
			{
				switch (let.row)
				{
					case 0:
					{
						return 0;
					}
					case 3:
					{
						return 2;
					}
					case 7:
					{
						return 0;
					}
					case 11:
					{
						return 2;
					}
					case 14:
					{
						return 0;
					}
					default: return 4;
				}				
			}
			case 4:
			{
				switch (let.row)
				{
					case 4:
					{
						return 2;
					}
					case 10:
					{
						return 2;
					}
						default: return 4;
				}
				
			}
			case 5:
			{
				switch (let.row)
				{
					case 1:
					{
						return 1;
					}
					case 5:
					{
						return 1;
					}
					case 9:
					{
						return 1;
					}
					case 13:
					{
						return 1;
					}
					default: return 4;
				}
				
			}
			case 6:
			{
				switch (let.row)
				{
					case 2:
					{
						return 0;
					}
					case 6:
					{
						return 0;
					}
					case 8:
					{
						return 0;
					}
					case 12:
					{
						return 0;
					}
					default: return 4;
				}				
			}
			case 7:
			{
				switch (let.row)
				{
					case 0:
					{
						return 3;
					}
					case 3:
					{
						return 0;
					}
					case 7:
					{
						return 2;
					}
					case 11:
					{
						return 0;
					}
					case 14:
					{
						return 3;
					}
					default: return 4;
				}				
			}						
			case 8:
			{
				switch (let.row)
				{
					case 2:
					{
						return 0;
					}
					case 6:
					{
						return 0;
					}
					case 8:
					{
						return 0;
					}
					case 12:
					{
						return 0;
					}
					default: return 4;
				}				
			}
			case 9:
			{
				switch (let.row)
				{
					case 1:
					{
						return 1;
					}
					case 5:
					{
						return 1;
					}
					case 9:
					{
						return 1;
					}
					case 13:
					{
						return 1;
					}
					default: return 4;
				}
				
			}
			case 10:
			{
				switch (let.row)
				{
					case 4:
					{
						return 2;
					}
					case 10:
					{
						return 2;
					}
						default: return 4;
				}
				
			}
			case 11:
			{
				switch (let.row)
				{
					case 0:
					{
						return 0;
					}
					case 3:
					{
						return 2;
					}
					case 7:
					{
						return 0;
					}
					case 11:
					{
						return 2;
					}
					case 14:
					{
						return 0;
					}
					default: return 4;
				}				
			}
			case 12:
			{
				switch (let.row)
				{
					case 2:
					{
						return 2;
					}
					case 6:
					{
						return 0;
					}
					case 8:
					{
						return 0;
					}
					case 12:
					{
						return 2;
					}
					default: return 4;
				}				
			}
			case 13:
			{
				switch (let.row)
				{
					case 1:
					{
						return 2;
					}
					case 5:
					{
						return 1;
					}
					case 9:
					{
						return 1;
					}
					case 13:
					{
						return 2;
					}
					default: return 4;
				}
			}
			case 14:
			{
				switch (let.row)
				{
					case 0:
					{
						return 3;
					}
					case 3:
					{
						return 0;
					}
					case 7:
					{
						return 3;
					}
					case 11:
					{
						return 0;
					}
					case 14:
					{
						return 3;
					}
					default: return 4;
				}
			}
		}
		return 4;
	}
	
	
	public static int calcWordScore(char[] word)
	{
		int result = 0;
		int wordBoardMultiplier = 1;
		for(int i=0;i<word.length;i++)
		{
			int letterBoardScore = 4;
			for(int j=0;j<usedLetters.size();j++)
			{
				if(usedLetters.get(j).letter == word[i])
				{
					letterBoardScore = calcLetterBoardScore(usedLetters.get(j));
					break;
				}
			}
			String letter = String.valueOf(word[i]);
			switch (letterBoardScore)
			{
				case 0:
				{
					result += 2 * letterScores.get(letter);
					break;
				}
				case 1:
				{
					result += 3 * letterScores.get(letter);
					break;
				}
				case 2:
				{
					result += letterScores.get(letter);
					wordBoardMultiplier *= 2;
					break;
				}
				case 3:
				{
					result += letterScores.get(letter);
					wordBoardMultiplier *= 3;
					break;
				}
				default:
				{
					result += letterScores.get(letter);
					break;
				}
			}
		}
		return (wordBoardMultiplier * result);
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
			
			int wordScore = calcWordScore(userWord.toCharArray());
			player.setScore(wordScore);
			
//			player.setScore(userWord.length());
			ret = true;
//			System.out.println("Very Good - you made the word: " + userWord + ". You gained " + wordScore + " more pointes");
			G.mainWindow.setPlayStatusText("Very Good - " + player.getName() + " made the word: " + userWord + ". You gained " + wordScore + " more pointes");
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
		if(G.getMode()=='b')
		{
			if(!(G.getPlayerList().size()==0))
			{
				for(Player player : G.getPlayerList()){
					gameDirectories.getRecordList().updatePlayer(player.getName(),player.getScore());}
			}
		}
		else{
			if(!(G.getPlayerList().size()==0))
			{
				for(Player player : G.getPlayerList())
				{
					gameDirectories.getRecordListAdvanced().updatePlayer(player.getName(),player.getScore());
				}
			}
		}
	}
	
	public static void uploadRecordList(){
		FileInputStream file;
		try {
			file = new FileInputStream(gameDirectories.getAdvancedRecordsFullFileName());   
			ObjectInputStream data = new ObjectInputStream(file);
			gameDirectories.setRecordListAdvanced((RecordList) data.readObject());
			data.close();
			file.close();

			file = new FileInputStream(gameDirectories.getBasicRecordsFullFileName());
			data = new ObjectInputStream(file);
			gameDirectories.setRecordList((RecordList) data.readObject());
			data.close();
			file.close();
		} 
		catch (FileNotFoundException e) {
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
			if(a=='b')
				data.writeObject(gameDirectories.getRecordList());
			if(a=='a')
				data.writeObject(gameDirectories.getRecordListAdvanced());
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
			for (int key : gameDirectories.getRecordList().getRecordList().descendingKeySet()) {
				for(String name:gameDirectories.getRecordList().getRecordList().get(key)){
					recordListString.append(name + "\t\t");
					recordListString.append(key + " points" + "\n");
				}
			} 
		}
		if(a=='a'){
			for (int key : gameDirectories.getRecordListAdvanced().getRecordList().descendingKeySet()) {
				for(String name:gameDirectories.getRecordListAdvanced().getRecordList().get(key)){
					recordListString.append(name + "\t\t");
					recordListString.append(key + " points" + "\n");
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
		String retWord=null;
		if(GameGui.getG().getMode() == 'b'){
			retWord = G.getAp().placeAutoWordAndUpdate(player);
		}
		else{//advanced
			retWord = G.getAp().placeAutoWordAndUpdateAdvanced(player);
		}
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
