package database;

import gameUsers.GameHistory;
import gameUsers.User;
import gameUsers.UserDBQueries;

public class UserQueriesImpl implements UserDBQueries{

	public boolean addNewUser(User user) throws DBException 
	{
		return false;
	}

	public boolean updateUserGames(String userName, int numOfVictories,
			int bestResult, GameHistory history) throws DBException 		
	{
		return false;
	}

	/* If comparePassword==false, don't compare password and return userName anyway (if exists).
	 * If comparePassword==true: fist search for userName, and only if passWord match, search for 
	 * gameHistory.  
	 * */
	public User getUserDetails(String userName, String password,
			boolean comaprePassword) throws DBException {
		return null;
	}

}
