package database;

import gameUsers.GameHistory;
import gameUsers.User;

import java.util.ArrayList;
import java.util.Iterator;

public class DBUtils {
	
	//separator between rivals
	static String sep = "\n";
	
	public static String setInsertUserCommand(User user)
	{
		if (user == null)
			return null;
		String name = fixApost(user.getName());
		String password = fixApost(user.getPassword());
		String email = fixApost(user.getEmail());
		int victories = user.getNumOfVictories();
		int bestScore = user.getBestResult();
		
		String cmd = "INSERT INTO USERS(NAME,PASSWORD,EMAIL,VICTORIES,BEST_RESULT) VALUES('" 
			+ name + "','" + password + "','" + email + "','" + victories + "','" + bestScore + "')";
		
		return cmd;
	}

	public static String setInsertGameCommand(GameHistory game)
	{
		if (game == null)
			return null;
		String name = fixApost(game.getName());
		String rivals = "";
		if (game.getRivals()!=null)
		{
			Iterator<String> iter = game.getRivals().iterator();
			while (iter.hasNext())
			{
				rivals += iter.next() + sep; 
			}
		}
		rivals = fixApost(rivals);
		int score = game.getCurrentScrore();
		String cmd = "INSERT INTO GAMES(NAME,DATE1,RIVALS,SCORE) VALUES('" 
			+ name + "',SYSDATE,'" + rivals + "','" + score + "')";
		return cmd;
	}
	
	public static String setSelectUserCommand(String userName)
	{
		userName = fixApost(userName);
		return "SELECT * FROM USERS WHERE NAME='" + userName + "'";
	}
	
	public static String setSelectGameCommand(String userName)
	{
		userName = fixApost(userName);
		return "SELECT * FROM GAMES WHERE NAME='" + userName + "'";
	}
	
	public static ArrayList<String> parseRivals(String rival)
	{
		if (rival == null)
			return null;
		ArrayList<String> res = new ArrayList<String>();
		
		String[] arr = rival.split(sep);
		for (int i=0;i<arr.length;i++)
			res.add(arr[i]);

		return res;
	}	
	
	public static String setUpdateUserCommand(int score, int victories, String name)
	{
		if (score ==-1 && victories==-1)
			return null;
		name = fixApost(name);
		String cmd = "UPDATE USERS SET ";
		if (score != -1)
		{
			cmd += "BEST_RESULT='" + score + "'";
			if (victories != -1)
				cmd += ", " + "VICTORIES='" + victories + "'";
		}
		else 
		{
			if (victories != -1)
				cmd += "VICTORIES='" + victories + "'";
		}	
		cmd += " WHERE NAME='" + name + "'";
		
		return cmd;
	}
	
	/* helper function that "fixes" (duplicates) every apostraphy for statement inserts
	 * Input is any string, output is fixed string*/
	public static String fixApost (String name)
	{
		if (name == null)
			return null;
		int ind = name.indexOf("'");
		if (ind == -1)
			return name;
		String sub = "";
		String suf = name;
		String res = "";
		while (ind != -1)
		{
			sub = suf.substring(0, ind+1) + "'";
			suf = suf.substring(ind+1);
			res = res + sub;
			ind = suf.indexOf("'");
			sub=suf;
		}
		return res+suf;
	}
	

	
}
