package testClasses;


import java.util.LinkedList;
import java.lang.Math;
import java.util.TreeMap;
import scrabbleMain.RecordList;
import junit.framework.TestCase;

public class RecordListTest extends TestCase {
	
	private  RecordList     recordList = new RecordList(new TreeMap<Integer,LinkedList<String>>());
	
	
	public void setup(){
	  this.recordList.updatePlayer("first", 1000);
	  for(int i=0;i<20;i++){
		  Double j = Math.random() * 100;
		  String name = j.toString();
		  Integer score = j.intValue();
		  this.recordList.updatePlayer(name, score);
	  }
	}
	public void testRecordList(){
	  this.setup();
	  assertTrue(recordList.getRecordList().size()< 20);
	  Integer i = 1000;
	  assertTrue(recordList.getRecordList().lastKey().compareTo(i)==0); 
	  System.out.println("The top record is: " +recordList.getRecordList().lastKey());
	  recordList.printRecordList();
	  }
	
}	

