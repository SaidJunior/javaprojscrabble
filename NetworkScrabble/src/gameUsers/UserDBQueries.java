package gameUsers;

import database.DBException;

public interface UserDBQueries {

	/* This interface will hold all methods, that are required to 
	 * work with user's accounts from DB side.
	 * DBException will be thrown, with a message for DB error,
	 * so we will be able to distinguish between our inner errors to DB errors. 
	 * There is no need to set the date field for GameHistory. DB will generate it.
	 *  
	 * */
	
	
	/** Add new User, user, to database.
	 * 	Returns true, if succeed.
	 * 	Returns false if failed because user already exists, exception message will be thrown.
	 * */
	public boolean addNewUser(User user) throws DBException;
	
	
	/** Get User userName.
	 *  Returns the User: userName. 
	 *  pass comparePassword=true, if you want to get userName, only if password is correct.
	 *  pass comparePassword=false, if you want to get userName anyway.
	 *  Returns null, if failed because user does not exists, or pass does not match.
	 * */
	public User getUserDetails(String userName, String password, boolean comaprePassword) throws DBException;
	
	
	/** Update user's game info.
	 *  userName must be a valid User (a name of a real user).
	 *  currentGame = only the new game to add to DB (we don't edit old games).
	 *  If one of the players is a guest do not use this method
	 *  numOfVictories and bestResults, will each hold the current value if 
	 *  it had changed, otherwise -1.
	 *  history will the game to add to DB, or null if from some reason we don't want to 
	 *  add any game.
	 *  Returns true, if succeed.
	 *  Returns false, if failed from any reason.     
	 * */
	public boolean updateUserGames (String userName, int numOfVictories, int bestResult,
			GameHistory currentGame)throws DBException;
	

	
}
;