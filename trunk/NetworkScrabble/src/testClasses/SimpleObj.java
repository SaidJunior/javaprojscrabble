package testClasses;

import java.io.Serializable;

public class SimpleObj implements Serializable{

	int i;
	String s;
	
	public SimpleObj()
	{
		i=3;
		s = "bla";
	}
	
	public SimpleObj (String s, int i)
	{
		this.i = i;
		this.s = s;
	}

	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
}
