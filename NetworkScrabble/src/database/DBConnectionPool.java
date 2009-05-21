package database;

import java.sql.*;
import java.util.*;


/***********************************************************************************************************
The connection pool class provides an inspector to handle deadlocks and hangs. 
The ConnectionInspector class decides a connection is dead if the following conditions are met:
1. The connection is flagged as being in use. 
2. The connection is older than a preset connection time out. 
3. The connection fails a validation check (the validation check runs a simple SQL query over the connection). 
/**********************************************************************************************************/
class ConnectionInspector  extends Thread 
{
    private DBConnectionPool pool;
    private final long delay = 30000;

    ConnectionInspector(DBConnectionPool pool) 
	{
        this.pool = pool;
    }

    public void run() 
	{
        while(true) 
		{
           try {
              sleep(delay);
           } catch( InterruptedException e) { System.out.println("Error message is: " + e.getMessage() );}
		   
           pool.inspectConnections();
        }
    }
}

public class DBConnectionPool 
{

   private 				Vector<DBConnection> connections;
   private 				String url, user, password;
   final private long 	timeout = 60000;
   final private int retries = 5;
   private 				ConnectionInspector inspector;
   final private int 	poolsize = 10;

   public DBConnectionPool(String url, String user, String password) 
   {
		this.url = url;
		this.user = user;
		this.password = password;
		  
		connections = new Vector<DBConnection>(poolsize);
		inspector = new ConnectionInspector(this);
		inspector.start();
   }

   public synchronized Connection getConnection()
   {

       DBConnection c=null;
       for(int i = 0; i < connections.size(); i++) 
	   {
           c = (DBConnection)connections.elementAt(i);
           if (!c.inUse()) 
		   {
        	  c.getBusy();
              return c;
           }
       }

       
       try
       {
    	   Connection conn = null;
    	   int i=0;
    	   while(i<retries && conn==null)
		   {
		   		conn = DriverManager.getConnection(url, user, password);
		   		i++;
		   }
           c = new DBConnection(conn, this);
           c.getBusy();
           connections.addElement(c);
       }
  	 	catch(SQLException e)
       {
  	 		System.out.println("Error message is: " + e.getMessage() );
       }
      
       return c;
   } 
   
   public synchronized void inspectConnections() 
   {

		long stale = System.currentTimeMillis() - timeout;
		Enumeration<DBConnection> connlist = connections.elements();
    
		while((connlist != null) && (connlist.hasMoreElements())) 
		{
		  	DBConnection conn = (DBConnection)connlist.nextElement();

			if((conn.inUse()) && (stale > conn.getLastUse()) && (!conn.validate())) 
			{
				removeConnection(conn);
			}
		}
	  
   }

   public synchronized void closeConnections() 
   {
        
      Enumeration<DBConnection> connlist = connections.elements();

      while((connlist != null) && (connlist.hasMoreElements())) 
	  {
          DBConnection conn = (DBConnection)connlist.nextElement();
          removeConnection(conn);
      }
     
   }

   private synchronized void removeConnection(DBConnection conn) 
   {
       connections.removeElement(conn);
   }

  public synchronized void returnConnection(DBConnection conn)
  {
      conn.expireUse();
  }
   
}
