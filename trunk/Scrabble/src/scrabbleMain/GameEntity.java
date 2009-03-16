package scrabbleMain;

import java.io.Serializable;
import java.util.List;

public class GameEntity implements Serializable{

	private List<Player> playerList;
	private LettersSet lettersSet;
	private Board board;
	private int turnInd;
	
	public GameEntity(List<Player> playerList, LettersSet lettersSet, Board board,int player_id)
	{
		this.playerList = playerList;
		this.lettersSet = lettersSet;
		this.board = board;
		this.turnInd=player_id;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public LettersSet getLettersSet() {
		return lettersSet;
	}

	public void setLettersSet(LettersSet lettersSet) {
		this.lettersSet = lettersSet;
	}


	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int turnInd() {
		return turnInd;
	}

	public void setturnInd(int turnInd) {
		this.turnInd = turnInd;
	}
}
