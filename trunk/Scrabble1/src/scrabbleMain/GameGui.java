package scrabbleMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameGui {
	public static GameLogic G = new GameLogic();

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

	
}
