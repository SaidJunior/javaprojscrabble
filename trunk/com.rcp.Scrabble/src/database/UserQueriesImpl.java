package database;

import gameUsers.GameHistory;
import gameUsers.User;
import gameUsers.UserDBQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserQueriesImpl implements UserDBQueries{

	private DBConnectionInit db_conn;
	
	public UserQueriesImpl()
	{
		try {
			db_conn = new DBConnectionInit();
			Connection con = db_conn.connect();
			db_conn.CreateUsersTable(con);
			db_conn.CreateGamesTable(con);
			db_conn.retConn(con);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public UserQueriesImpl(DBConnectionInit dbcon)
	{
		db_conn = dbcon;
		
	}
	
	public void CloseConnectionsDB(){
		  try
          {
              // the shutdown=true attribute shuts down Derby
              DriverManager.getConnection("jdbc:derby:;shutdown=true");

              // To shut down a specific database only, but keeep the
              // engine running (for example for connecting to other
              // databases), specify a database in the connection URL:
              //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
          }
          catch (SQLException se)
          {
              if (( (se.getErrorCode() == 50000)
                      && ("XJ015".equals(se.getSQLState()) ))) {
                  // we got the expected exception
                  System.out.println("Derby shut down normally");
                  // Note that for single database shutdown, the expected
                  // SQL state is "08006", and the error code is 45000.
              } else {
                  // if the error code or SQLState is different, we have
                  // an unexpected exception (shutdown failed)
                  System.err.println("Derby did not shut down normally");
                  System.out.println(se.getMessage());
              }
          }
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
				System.out.println("DB Connectivity failure, for adding the user: " + name);
				throw new DBException("DB Connectivity failure for adding the user: " + name);
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
				System.out.println("DB Connection Pool Error in adding the user.\nFull details: "+ e1.toString());
				throw new DBException("DB Connection Pool Error in adding the user.");
			}
			System.out.println("Error while adding the user: " + name + ".\nName already exists.");
			return false;
		}
		System.out.println("Done adding user: " + name);
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
				System.out.println("DB Connectivity failure, for adding the game for: " + userName);
				throw new DBException("DB Connectivity failure for adding the game for: " + userName);
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
				System.out.println("DB Connection Pool Error in adding the game.\nFull details: "+ e1.toString());
				throw new DBException("DB Connection Pool Error in adding the game.");
			}
			System.out.println("DB error while adding the game: " + userName + ".\nUser does not exists.");
			return false;
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
				System.out.println("DB Connectivity failure, for getting the name: " + userName);
				throw new DBException("DB Connectivity failure for getting the name: " + userName);
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
					user.setHistory(games);
				}
				else{
					System.out.println("password does not match");
					return null;
			}
			}
				
			rs.close();
			stmt.close();
			db_conn.retConn(conn);
			
		} catch (SQLException e) 
		{	
			try {
				db_conn.retConn(conn);
			} catch (Exception e1) {
				System.out.println("DB Connection Pool Error in getting the name.\nFull details: "+ e1.toString());
				throw new DBException("DB Connection Pool Error in getting the name.");
			}
			System.out.println("Error while getting the name: " + userName + ".\nUser does not exists.");
			return null;
		}
		System.out.println("Done getting user: " + userName + ", while pswd = " + comaprePassword);
		return user;
	}
	

}
