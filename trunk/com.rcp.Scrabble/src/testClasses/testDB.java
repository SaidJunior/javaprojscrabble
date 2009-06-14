package testClasses;

import java.util.ArrayList;
import java.util.Iterator;

import database.DBConnectionInit;
import database.DBException;
import database.DBUtils;
import database.UserQueriesImpl;

import gameUsers.GameHistory;
import gameUsers.User;
import junit.framework.TestCase;

public class testDB extends TestCase{

	User user1 = new User();
	User user2 = new User();
	User user3 = new User();
	User user4 = new User();
	GameHistory game1 = new GameHistory();
	GameHistory game2 = new GameHistory();
	GameHistory game3 = new GameHistory();
	GameHistory game4 = new GameHistory();
	
	public void initParams()
	{
		user1.setName("Roy1");
		user1.setPassword("scrabble1");
		user1.setEmail("Roy@yadoo.co.il");
		user1.setBestResult(3);
		user1.setNumOfVictories(4);
		
		user2.setName("Roy1");
		user2.setPassword("scrabble");
		user2.setEmail("Roy@yado.co.il");
		user2.setBestResult(3);
		user2.setNumOfVictories(5);
		
		user3.setName("Tamar");
		user3.setPassword("bla");
		user3.setEmail("Tamar@co.il");
		user3.setBestResult(56);
		user3.setNumOfVictories(15);
		
		user4.setName("yos't");
		user4.setPassword("ttt's");
		
		game1.setName("Roy1");
		game1.setCurrentScrore(32);
		ArrayList<String> riv1 = new ArrayList<String>();
		riv1.add("yosi");
		riv1.add("Tamar");
		game1.setRivals(riv1);
		
		game2.setName("Roy1");
		game2.setCurrentScrore(23);
		
		ArrayList<GameHistory> games = new ArrayList<GameHistory>();
		games.add(game1);
		games.add(game2);
		
		user1.setHistory(games);
		
		game3.setName("Tamar");
		game3.setCurrentScrore(54);
		
		ArrayList<GameHistory> games3 = new ArrayList<GameHistory>();
		user3.setHistory(games3);
	}
	
	public void testParseRivals()
	{
		String s1 = "roy";
		String s2 = "tamar";
		
		String s = s1 + "\n" + s2 + "\n";
		
		ArrayList<String> arr1 = new ArrayList<String>();
		arr1.add(s1);
		arr1.add(s2);
		
		ArrayList<String> arr2 = DBUtils.parseRivals(s);
		
		assertEquals(arr1.size(), arr2.size());
		for (int i=1; i < arr1.size(); i++)
			assertEquals(arr1.get(i), arr2.get(i));
		assertEquals(s1, DBUtils.parseRivals(s1).get(0));
		
	}
	
	public void testSimpleDB()
	{
		initParams();
		try {
			DBConnectionInit dbcon = new DBConnectionInit();
			UserQueriesImpl impl = new UserQueriesImpl(dbcon);
			boolean i1 = false;
			i1 = impl.addNewUser(user1);
			assertEquals(true, i1);
			boolean i2 = false;
			i2 = impl.updateUserGames(user1.getName(), -1, -1, game1);
			assertEquals(true, i2);
			
			User u1 = impl.getUserDetails(user1.getName(), "", false);
			assertEquals(user1.getEmail(), u1.getEmail());
			
			User u2 = impl.getUserDetails(user1.getName(), "", true);
			assertEquals(u2, null);
			
			u2 = impl.getUserDetails(user1.getName(), user1.getPassword(), true);
			
			assertEquals(user1.getNumOfVictories(), u1.getNumOfVictories());
			assertEquals(user1.getBestResult(), u2.getBestResult());
			
			i2 = impl.updateUserGames(user1.getName(), 98, 98, game1);
			assertEquals(true, i2);
			
			u2 = impl.getUserDetails(user1.getName(), user1.getPassword(), true);
			assertEquals(98, u2.getBestResult());
			
			i2 = impl.updateUserGames(user1.getName(), -1, 177, game2);
			assertEquals(true, i2);
			u2 = impl.getUserDetails(user1.getName(), user1.getPassword(), true);
			assertEquals(177, u2.getBestResult());
			
			impl.addNewUser(user3);
			
			i2 = impl.updateUserGames(user3.getName(), 498, -1, game3);
			assertEquals(true, i2);
			
			
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testApost()
	{
		initParams();
		DBConnectionInit dbcon;
		try {
			dbcon = new DBConnectionInit();
			UserQueriesImpl impl = new UserQueriesImpl(dbcon);
			boolean i1 = false;
			i1 = impl.addNewUser(user4);
			User temp = impl.getUserDetails(user4.getName(), "", false);
			assertEquals(true, i1);
			assertEquals(user4.getName(), temp.getName());
			
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
}

