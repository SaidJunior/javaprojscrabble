package scrabbleMain;
/*
 * This class defines the functions that need 
 * to be implemented in the gui classes
 * The idea is that at the beginning of the game, 
 * a screen with the options of textual or gui game will be displayed
 * In the gui representation, there should be a screen that shows 
 *  the current player name, it's score till now, the cards it has, 
 *  and two buttons one for Change Letters and one for Add Letters to the board
 *  if one chooses to Change Letters  the function makeTurn that will make the Board inactive
 *  and if the Add Letters the function makeTurn will not let the  players change letters
 *   
 */

public abstract class Builder {
	
	public abstract void makeHelp();
	
	public abstract boolean makeSave();
	
	public abstract boolean makeLoad();
/*
 * This function will display the end of game Screen
 * this function should contain also the function showRecordList() and such;
 */	
	public abstract void exitScreen();
	
/*
 * This function should display a shell where the user can choose 
 * how many players will play and the names of  the players
 */	
	public abstract void newGame();
/*
 * This function will create the Board 
 */	
	public abstract void makeBoard();
/*
 * This function will give the player the option to throw letters
 * or add letters 
 *  it will contain one turn of a player and a will define if the player changes letters or add letters
 */	
	public abstract boolean makeTurn(Player player,char a);
	
	
}
