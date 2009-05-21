package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import gameUsers.GameHistory;
import gameUsers.User;
import gameUsers.UserDBQueries;

public class UserQueriesImpl implements UserDBQueries{

	private DBConnectionInit db_conn;
	
	public UserQueriesImpl()
	{
		
	}
	
	public UserQueriesImpl(DBConnectionInit dbcon)
	{
		db_conn = dbcon;
		
	}
	
	public boolean addNewUser(User user) throws DBException 
	{
		if (user==null)
			return false;
		String insertCommand = DBUtils.setInsertUserCommand(user);
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
		String cmd1 = DBUtils.setInsertGameCommand(history);
		String cmd2 = DBUtils.setUpdateUserCommand(bestResult, numOfVictories, userName);
		
		Connection conn = db_conn.connect();
		try {
			if (conn == null)
			{
				System.out.println("Connectivity failure, for adding the game: " + userName);
				throw new DBException("Connectivity failure for adding the game: " + userName);
			}
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			if (cmd1 != null)
				stmt.execute(cmd1);
			if (cmd2 != null)
				stmt.execute(cmd2);
			
			stmt.close();
			conn.commit();
			conn.setAutoCommit(true);
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
		
		if (userName == null)
			return null;
		User user = new User();
		user.setName(userName);
		String cmd = DBUtils.setSelectUserCommand(userName);
		Connection conn = db_conn.connect();
		try {
			if (conn == null)
			{
				System.out.println("Connectivity failure, for getting the name: " + userName);
				throw new DBException("Connectivity failure for getting the name: " + userName);
			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(cmd);
			while (rs.next() == true)
			{
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setBestResult(rs.getInt("BEST_RESULT"));
				user.setNumOfVictories(rs.getInt("VICTORIES"));
			}
			if (comaprePassword)
			{
				if (password != null && password.equalsIgnoreCase(user.getPassword()))
				{
					cmd = DBUtils.setSelectGameCommand(userName);
					rs = stmt.executeQuery(cmd);
					ArrayList<GameHistory> games = new ArrayList<GameHistory>();
					GameHistory temp = new GameHistory();
					while (rs.next() == true)
					{
						temp.setName(userName);
						temp.setDate(rs.getString("DATE1"));
						temp.setCurrentScrore(rs.getInt("SCORE"));
						String rivals = rs.getString("RIVALS");
						temp.setRivals(DBUtils.parseRivals(rivals));
						games.add(temp);
					}
				}
				else
					return null;
			}
			rs.close();
			stmt.close();
			db_conn.retConn(conn);
			
		} catch (SQLException e) 
		{	
			try {
				db_conn.retConn(conn);
			} catch (Exception e1) {
				System.out.println("Connection Pool Error in getting the name.\nFull details: "+ e1.toString());
				throw new DBException("Connection Pool Error in getting the name.");
			}
			throw new DBException ("Error while getting the name: " + userName + ".\nUser does not exists.");
		}
		
		return user;
	}
	
}
