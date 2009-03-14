package scrabbleMain;

import java.io.Serializable;
import java.util.List;

public class GameEntity implements Serializable{

	private List<Player> playerList;
	private LettersSet lettersSet;
	private Dictionary dictionary;
	private Board board;
	
	public GameEntity(List<Player> playerList, LettersSet lettersSet, Dictionary dictionary, Board board)
	{
		this.playerList = playerList;
		this.lettersSet = lettersSet;
		this.dictionary = dictionary;
		this.board = board;
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

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
