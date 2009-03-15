package scrabbleMain;

import java.io.Serializable;
import java.util.List;

public class GameEntity implements Serializable{

	private List<Player> playerList;
	private LettersSet lettersSet;
	private Board board;
	private int player_id;
	
	public GameEntity(List<Player> playerList, LettersSet lettersSet, Board board,int player_id)
	{
		this.playerList = playerList;
		this.lettersSet = lettersSet;
		this.board = board;
		this.player_id=player_id;
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

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
}
