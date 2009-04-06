package scrabbleMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class GameEntity implements Serializable{
	
	private List<Player> playerList;
    private LettersSet lettersSet;
    private Board board;
    private int turnInd;
    private char mode;
    private AutoPlayer ap;
    
    public GameEntity(List<Player> playerList, LettersSet lettersSet, Board board,
            int player_id, char mode)
    {
    	this.playerList = playerList;
    	this.lettersSet = lettersSet;
    	this.board = board;
    	this.turnInd=player_id;
    	this.mode = mode;
	}
    
    public GameEntity(List<Player> playerList, LettersSet lettersSet, Board board,
                                     int player_id, char mode, AutoPlayer ap)
    {
            this.playerList = playerList;
            this.lettersSet = lettersSet;
            this.board = board;
            this.turnInd=player_id;
            this.mode = mode;
            this.ap = ap;
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

    public char getMode(){
            return mode;
    }
    
    public void setMode(char mode){
            this.mode = mode;
    }

	public AutoPlayer getAp() {
		return ap;
	}

	public void setAp(AutoPlayer ap) {
		this.ap = ap;
	}
	
}
