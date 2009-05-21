package database;

import java.util.ArrayList;

import gameUsers.GameHistory;
import gameUsers.User;

public class mainTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		User user = new gameUsers.User();
		user.setName("Roy1");
		user.setPassword("scrabble1");
		user.setEmail("Roy@yadoo.co.il");
		user.setBestResult(3);
		user.setNumOfVictories(4);
		
		GameHistory game = new GameHistory();
		game.setName("Roy");
		game.setCurrentScrore(3);
		
		
		try {
			DBConnectionInit dbcon = new DBConnectionInit();
			UserQueriesImpl impl = new UserQueriesImpl(dbcon);
			impl.addNewUser(user);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		String nn = "roy " + "\n" + "tamar" + "\n";
		parseRivals(nn);
		
	}
	public static ArrayList<String> parseRivals(String rival)
	{
		ArrayList<String> res = new ArrayList<String>();
		
		String[] arr = rival.split("\n");
		System.out.println(arr.length);
		for (int i=0;i<arr.length;i++)
		{
			res.add(arr[i]);
			System.out.println(res.get(i));
		}

		return res;
	}

}
