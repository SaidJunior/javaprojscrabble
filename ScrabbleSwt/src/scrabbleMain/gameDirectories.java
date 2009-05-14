package scrabbleMain;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.TreeMap;

public class gameDirectories {

	private static String gameDirectory;
	private static String savedGamesDirectorty;
	private static String recordListDirectorty;
	private static final String savedGamesDirectoryName = "SavedGames";
	private static final String recordListDirectoryName = "Records";
	private static String basicRecordsFullFileName;
	private static String advancedRecordsFullFileName;
	
	private  static RecordList     recordListBasic      = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	private  static RecordList     recordListAdvanced     = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	
	
	/* This methods initialized all general needs of game: Directories, Records lists, 
	 * Letter Score 
	 * */
	
	public static void initGame()
	{
		initDirectories();
		GameGui.uploadRecordList();
		GameGui.createLetterScores();
	}
	
	/* Init game directories and upload Records lists. 
	 * */
	public static void initDirectories()
	{
		gameDirectory = System.getProperty("user.home") + "/Scrabble";
		savedGamesDirectorty = gameDirectory + "/" + savedGamesDirectoryName;
		recordListDirectorty = gameDirectory + "/" + recordListDirectoryName;
		setBasicRecordsFullFileName(recordListDirectorty + "/fileRecordListBasic");
		setAdvancedRecordsFullFileName(recordListDirectorty + "/fileRecordListAdvanced");
		initSavedGamesDir();
		initRecordListDir();	
	}
			
	private static void initSavedGamesDir()
	{
		File file = new File(getSavedGamesDirectorty());
		//check if directory exist, otherwise create
		if (file.exists())
			return;
		file.mkdirs();
	}
	
	private static void initRecordListDir()
	{
		File file = new File(getRecordListDirectorty());
		//check if directory exist, otherwise create
		if (!file.exists())
			file.mkdirs();
		//check if files exists, otherwise create
		try {
			file = new File(getBasicRecordsFullFileName());
			if (!file.exists())
				file.createNewFile();
			file = new File(getAdvancedRecordsFullFileName());
			if (!file.exists())
				file.createNewFile();
		} catch (IOException e) {
		}
	}

	public static String getSavedGamesDirectorty() {
		return savedGamesDirectorty;
	}

	private static void setSavedGamesDirectorty(String savedGamesDirectorty) {
		gameDirectories.savedGamesDirectorty = savedGamesDirectorty;
	}

	public static String getRecordListDirectorty() {
		return recordListDirectorty;
	}

	private static void setRecordListDirectorty(String recordListDirectorty) {
		gameDirectories.recordListDirectorty = recordListDirectorty;
	}

	public static String getBasicRecordsFullFileName() {
		return basicRecordsFullFileName;
	}

	private static void setBasicRecordsFullFileName(String basicRecordsFullFileName) {
		gameDirectories.basicRecordsFullFileName = basicRecordsFullFileName;
	}

	public static String getAdvancedRecordsFullFileName() {
		return advancedRecordsFullFileName;
	}

	private static void setAdvancedRecordsFullFileName(
			String advancedRecordsFullFileName) {
		gameDirectories.advancedRecordsFullFileName = advancedRecordsFullFileName;
	}
	
	public static RecordList getRecordList() {
		return recordListBasic;
	}

	public static void setRecordList(RecordList recordList) {
		recordListBasic = recordList;
	}
	
	public static  RecordList getRecordListAdvanced() {
		return recordListAdvanced;
	}
	public static void setRecordListAdvanced(RecordList recordList) {
		recordListAdvanced = recordList;
	}
}
