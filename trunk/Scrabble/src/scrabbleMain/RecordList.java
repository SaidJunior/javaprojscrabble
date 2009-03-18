package scrabbleMain;

import java.io.Serializable;
import java.util.*;

public class RecordList implements Serializable {
	
	private TreeMap<Integer,LinkedList<String>> recordList;
	
	public RecordList(TreeMap<Integer,LinkedList<String>> recordList){
		this.recordList=recordList;
	}
	
	public TreeMap<Integer,LinkedList<String>> getRecordList(){
		return this.recordList;
	}
	
	public void setRecordList(TreeMap<Integer,LinkedList<String>> recordList){
		this.recordList=recordList;
	}
/*
 * This function adds a new player and it's score to the RecordList
 * The number of scores in the list is at most 20
 * If two players have the same score they will both be shown in the list
 */
	public void updatePlayer(String name, int score) {
		if(!this.recordList.containsKey(score))
		{
			this.recordList.put(score,new LinkedList<String>());
		}
		this.recordList.get(score).add(name);
		if(this.recordList.size()>19){
			int minScore=this.recordList.firstKey();
			this.recordList.remove(minScore);
		}
		}
/*
 * This function prints the list such that next to each player there is 
 * his score
 */	
	public void printRecordList(){
		for (int key : this.recordList.descendingKeySet()) {
			for(String name:recordList.get(key)){
				System.out.print(name + "  ");
				System.out.println(key);
			}
		} 
	}
		
	
	
}

