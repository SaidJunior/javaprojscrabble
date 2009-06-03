package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			boolean i = false;
             Connection con =dbcon.connect();
  //           con.setAutoCommit(false);
             dbcon.CreateGamesTable(con);
             dbcon.CreateUsersTable(con);
             ResultSet result=null;
			 result = con.getMetaData().getTables(null,null, "USERS", null);
			  if(result.next()){
			  System.out.println("The tables were created");
			  }
			
			impl.addNewUser(user1);
			impl.updateUserGames(user1.getName(), user1.getNumOfVictories(), user1.getBestResult(),game1);
//			User temp = impl.getUserDetails(user1.getName(), "", false);
			User tempRivals= impl.getUserDetails(user1.getName(), user1.getPassword(), true);
//			System.out.println(temp.getName());
			System.out.println(user1.getName());
			System.out.println(tempRivals.getHistory().get(0).getRivals().get(1));
			System.out.println("the first rival of the game is " +game1.getRivals().get(1));
//			con.commit();
//			con.setAutoCommit(true);
			dbcon.retConn(con);
			impl.CloseConnectionsDB();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initParams()
	{
		user1.setName("Andreea17");
		user1.setPassword("scrabble");
		user1.setEmail("Andreea1@yadoo.co.il");
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
		
		game1.setName("Andreea17");
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
