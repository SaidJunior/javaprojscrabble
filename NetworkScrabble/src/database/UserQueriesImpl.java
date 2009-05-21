package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import gameUsers.GameHistory;
import gameUsers.User;
import gameUsers.UserDBQueries;

public class UserQueriesImpl implements UserDBQueries{

	private DBConnectionInit db_conn;
	
	public UserQueriesImpl(DBConnectionInit dbcon)
	{
		db_conn = dbcon;
		
	}
	
	public boolean addNewUser(User user) throws DBException 
	{
		if (user==null)
			return false;
		String insertCommand = setInsertUserCommand(user);
		String name = user.getName();
		
		Connection conn = db_conn.connect();
		try {
			if (conn == null)
			{
				System.out.println("Connectivity failure, for adding the user: " + name);
				throw new DBException("Connectivity failure for adding the user: " + name);
			}
			Statement stmt = conn.createStatement();
			stmt.execute(insertCommand);
			
			stmt.close();
			db_conn.retConn(conn);
			
		} catch (SQLException e) 
		{	
			try {
				db_conn.retConn(conn);
			} catch (Exception e1) {
				System.out.println("Connection Pool Error in adding the user.\nFull details: "+ e1.toString());
				throw new DBException("Connection Pool Error in adding the user.");
			}
			throw new DBException ("Error while adding the user: " + name + ".\nName already exists.");
		}
		System.out.println("Done inserting " + name);
		return true;
	}

	
	public boolean updateUserGames(String userName, int numOfVictories,
			int bestResult, GameHistory history) throws DBException 		
	{
		String insertCommand = setInsertGameCommand(history);
		
		Connection conn = db_conn.connect();
		try {
			if (conn == null)
			{
				System.out.println("Connectivity failure, for adding the game: " + userName);
				throw new DBException("Connectivity failure for adding the game: " + userName);
			}
			Statement stmt = conn.createStatement();
			stmt.execute(insertCommand);
			
			stmt.close();
			db_conn.retConn(conn);
			
		} catch (SQLException e) 
		{	
			try {
				db_conn.retConn(conn);
			} catch (Exception e1) {
				System.out.println("Connection Pool Error in adding the game.\nFull details: "+ e1.toString());
				throw new DBException("Connection Pool Error in adding the game.");
			}
			throw new DBException ("Error while adding the game: " + userName + ".\nUser does not exists.");
		}
		System.out.println("Done inserting game " + userName);
		return true;
	}

	/* If comparePassword==false, don't compare password and return userName anyway (if exists).
	 * If comparePassword==true: fist search for userName, and only if passWord match, search for 
	 * gameHistory.  
	 * */
	public User getUserDetails(String userName, String password,
			boolean comaprePassword) throws DBException {
		return null;
	}
	
	public static String setInsertUserCommand(User user)
	{
		String name = user.getName();
		String password = user.getPassword();
		String email = user.getEmail();
		int victories = user.getNumOfVictories();
		int bestScore = user.getBestResult();
		
		String cmd = "INSERT INTO USERS(NAME,PASSWORD,EMAIL,VICTORIES,BEST_RESULT) VALUES('" 
			+ name + "','" + password + "','" + email + "','" + victories + "','" + bestScore + "')";
		
		return cmd;
	}

	public static String setInsertGameCommand(GameHistory game)
	{
		String name = game.getName();
		String rivals = "";
		if (game.getRivals()!=null)
		{
			Iterator<String> iter = game.getRivals().iterator();
			while (iter.hasNext())
			{
				rivals += iter.next() + "\n"; 
			}
		}
		int score = game.getCurrentScrore();
		String cmd = "INSERT INTO GAMES(NAME,DATE1,RIVALS,SCORE) VALUES('" 
			+ name + "',SYSDATE,'" + rivals + "','" + score + "')";
		return cmd;
	}
	
	public static String setSelectUserCommand(String userName)
	{
		return "SELECT * FROM USERS WHERE NAME='" + userName +"'";
	}
	
	public static String setSelectGameCommand(String userName)
	{
		return "SELECT * FROM GAMES WHERE NAME=" + userName;
	}
}
