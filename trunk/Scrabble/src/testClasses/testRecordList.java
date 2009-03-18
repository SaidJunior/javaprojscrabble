package testClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;
import java.util.TreeMap;
import java.util.Random;

import scrabbleMain.Player;
import scrabbleMain.RecordList;
import scrabbleMain.Game;
import junit.framework.TestCase;

public class testRecordList extends TestCase {
	
	private static RecordList     recordList = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	
	public void addPlayer(String name,Integer score){
		recordList.updatePlayer(name, score);
		
	}
	public Integer topScore(){
		return this.recordList.getRecordList().lastKey();
	}
	
	public boolean testRecorsList(){
	  testRecordList test = new testRecordList();
	  test.addPlayer("first", 1000);
	  Random random = new Random();
	  for(int i=0;i<20;i++){
		  Double j = Math.random() * 100;
		  String name = j.toString();
		  Integer score = random.nextInt();
		  test.addPlayer(name, score);
	  }
	  if( (test.recordList.getRecordList().size()< 20) && (test.topScore()==1000)){
	      test.recordList.printRecordList();
		  return true;
	  }
	  else return false;
	}
}
