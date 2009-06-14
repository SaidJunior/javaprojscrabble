package testClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import scrabbleMain.GameEntity;
import scrabbleMain.Player;

import junit.framework.TestCase;

public class testSaveLoad extends TestCase{

	String savedGamesPath = "src/Saved_Games/";
	GameEntity game;
	
	public void testIfExists()
	{
		File file = new File(savedGamesPath + "A");
		assertEquals(false, file.exists());
	}
	
	public void initGame()
	{
		Player player1 = new Player("player1");
	}
	
	public void testSimpleSaveLoad()
	{
		SimpleObj obj1 = new SimpleObj("obj1",1);
		
		String name = "simpleTest";
		
		try {
			FileOutputStream file = new FileOutputStream(savedGamesPath + name);		  
			ObjectOutputStream data = new ObjectOutputStream(file);
			
			data.writeObject(obj1);
			data.close();
			file.close();
			
			File check = new File (savedGamesPath + name);
			assertEquals(true, check.exists());			
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error while saving.");
		} catch (IOException e) {
			System.out.println("IOE Exception while saving.");
		}
		
		try {
			FileInputStream loadFile = new FileInputStream(savedGamesPath + name);
			ObjectInputStream loadData = new ObjectInputStream(loadFile);
			SimpleObj loadObj = (SimpleObj) loadData.readObject();
			loadData.close();
			loadFile.close();
			
			assertEquals(1, loadObj.getI());
			assertEquals("obj1", loadObj.getS());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
}
