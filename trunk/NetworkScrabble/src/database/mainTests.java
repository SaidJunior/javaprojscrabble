package database;

import java.util.ArrayList;

import gameUsers.GameHistory;
import gameUsers.User;

public class mainTests {

	static User user1 = new User();
	static User user2 = new User();
	static User user3 = new User();
	static User user4 = new User();
	static GameHistory game1 = new GameHistory();
	static GameHistory game2 = new GameHistory();
	static GameHistory game3 = new GameHistory();
	static GameHistory game4 = new GameHistory();
	
	
	public static void main(String[] args) {
		
		
		initParams();
		DBConnectionInit dbcon;
		try {
			dbcon = new DBConnectionInit();
			UserQueriesImpl impl = new UserQueriesImpl(dbcon);
			boolean i1 = false;
			i1 = impl.addNewUser(user4);
			User temp = impl.getUserDetails(user4.getName(), "", false);
			System.out.println(temp.getName());
			System.out.println(user4.getName());
			
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initParams()
	{
		user1.setName("Roy'1");
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
		
		game1.setName("Roy'1");
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

}
