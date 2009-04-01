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

public class GameGui {
	private static GameLogic G = new GameLogic();
	
	
	public static boolean loadGame(String currentName) {
		
		boolean succ = false;
		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name ");
			return succ;
		}
		if (!checkIfExist(currentName))
		{
			System.out.println("A game named: " + currentName + " does not exists");
			return succ;
		}
		//currentName += G.getFileSuffix();
		
		try {
			FileInputStream file = new FileInputStream(G.getSavedGamesPath() + currentName);
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
	
	private static boolean checkIfValidName(String name) {
		if (name == null || "".equals(name) || name.startsWith(" "))
			return false;
		return true;
	}
	
	private static boolean checkIfExist(String fileName){
		
		File file = new File(G.getSavedGamesPath() + fileName);
		return file.exists();		
	}
	
	public static void saveCurrentGame(String currentName) {
		

		if (!checkIfValidName(currentName))
		{
			System.out.println("Please enter a vaild name.");
			G.setTurnInd(G.getTurnInd() - 1);
			return;
		}
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
			FileOutputStream file = new FileOutputStream(G.getSavedGamesPath() + currentName);		  
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

	public static GameLogic getG() {
		return G;
	}
	
	public static String parseFileToString(String FileName) {
		StringBuffer str = new StringBuffer();
		String line = null;

		try {
			BufferedReader in = new BufferedReader(new FileReader(FileName));

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
				newPlayer.insertLetter(G.getLettersSet().getLetter());
			}
			G.getPlayerList().add(newPlayer);
			// System.out.println(G.getPlayerList().get(i).getName());
		}
	}

	public static void setGameMode(int gameMode) {
		G.setMode(((gameMode == 0) ? 'b' : 'a'));
		// System.out.println(G.getMode());
	}

	
}