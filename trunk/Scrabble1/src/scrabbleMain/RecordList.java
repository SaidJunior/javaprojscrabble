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

	public void updatePlayer(String name, int score) {
		if(!this.recordList.containsKey(score))
		{
			this.recordList.put(score,new LinkedList<String>());
		}
		this.recordList.get(score).add(name);
		if(this.recordList.size()>20){
			int minScore=this.recordList.firstKey();
			this.recordList.remove(minScore);
		}
	}
	
	public void printRecordList(){
		for (int key : this.recordList.descendingKeySet()) {
			for(String name:recordList.get(key)){
				System.out.print(name + "  ");
				System.out.println(key);
			}
		} 
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer outString = new StringBuffer();
		
		for (int key : this.recordList.descendingKeySet()) {
			for(String name:recordList.get(key)){
				outString.append(name + "  " + key + "\n");
			}
		} 
		return outString.toString();
	}
		
}
	
/*	private String[][] recordList= new String[21][2];
	private int size;
	public RecordList(String[][] recordList){
		this.recordList=recordList;
		this.size = 0;
	}
	
	public void addPlayer(String name,Integer score){
		if (this.size==0){
			recordList[0][0]=name;
			recordList[0][1]=score.toString();
		}
		
	}*/


