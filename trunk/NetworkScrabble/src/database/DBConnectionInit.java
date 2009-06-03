package database;



import java.sql.*;
import java.util.Properties;



public class DBConnectionInit 
{

    private DBConnectionPool pool;
/*    private String driver = "oracle.jdbc.OracleDriver";
    //These parameters are for local-host using oracle connection 
	private String url = "jdbc:oracle:thin:@localhost:1555:csodb";
	private String user = "andreeac";
	private String password = "Iubire12"; */
    
    //These are for connecting to the Derby db
    /* the default framework is embedded*/
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";

    public DBConnectionInit() throws DBException 
    {
    	/*
    	PropertiesFile db_prop = new PropertiesFile();
    	String driver = db_prop.getProperty("driver");
    	String url = db_prop.getProperty("url");
    	String user = db_prop.getProperty("user");
    	String password = db_prop.getProperty("password");
    	*/
    	
    	String dbName = "Scrabble";
    	Properties prop= new Properties();
    	//this will set a user with the name USER1 and the password USER1
    	 prop.put("user", "user1");
         prop.put("password", "user1");
    	try
        {
    	 loadDriver();
//		 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//  		 Class.forName(driver).newInstance();
   		 pool = new DBConnectionPool(protocol,prop,dbName);
 //  		Connection con = pool.getConnection();

   		
        }
   	 	catch(Exception e)
        {
   		 System.out.println("Error message is: " + e.getMessage() );
   		 throw new DBException("Error to open a connection to the DB\nFull details: "+ e.toString());

        }
    }
    
    
    
    public  boolean CreateUsersTable(Connection con){
    	
    	try {
			ResultSet result = con.getMetaData().getTables(null,null, "USERS", null);
			if(!result.next()){
				Statement s = con.createStatement();
				s.execute("CREATE TABLE USERS ("+"NAME VARCHAR(30) NOT NULL, " +"PASSWORD VARCHAR(20) NOT NULL, "+
						"EMAIL VARCHAR(50) ,"+ "VICTORIES INT, "+" BEST_RESULT INT NOT NULL, "+"PRIMARY KEY (NAME))");
				
		
			result= con.getMetaData().getTables(null,null, "USERS", null);
			boolean res = result.next();
			return res;
			}
			return true;
    	
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problems with the CreateUsersTable");
			e.printStackTrace();
			return false;
		}
    	
    }
    
 public boolean CreateGamesTable(Connection con){
    	
    	try {
			ResultSet result = con.getMetaData().getTables(null,null, "GAMES", null);
			if(!result.next()){
				Statement s = con.createStatement();
				s.execute("CREATE TABLE GAMES (NAME VARCHAR(30) NOT NULL, DATE1 DATE , RIVALS VARCHAR(100) ,SCORE INT NOT NULL)");
				
		
			result= con.getMetaData().getTables(null,null, "GAMES", null);
			boolean res = result.next();
			return res;
			}
			return true;
    	
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problems with the CreateGamesTable");
			e.printStackTrace();
			return false;
		}
    	
    }
    /**
     * Loads the appropriate JDBC driver for this environment/framework. For
     * example, if we are in an embedded environment, we load Derby's
     * embedded Driver, <code>org.apache.derby.jdbc.EmbeddedDriver</code>.
     * 
     */
    private void loadDriver() {
        /*
         *  The JDBC driver is loaded by loading its class.
         *  If you are using JDBC 4.0 (Java SE 6) or newer, JDBC drivers may
         *  be automatically loaded, making this code optional.
         *
         *  In an embedded environment, this will also start up the Derby
         *  engine (though not any databases), since it is not already
         *  running. In a client environment, the Derby engine is being run
         *  by the network server framework.
         *
         *  In an embedded environment, any static Derby system properties
         *  must be set before loading the driver to take effect.
         */
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                        "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                        "\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }

   
    public Connection connect()
    {
    	Connection c = pool.getConnection();
       
        return c;
    }
    
    /*return the connection to the pool*/
	public void retConn(Connection conn)
	{
		try
		{
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Error message is: " + e.getMessage() );
		}
	
	}

    public void disconnect()
    {
    	pool.closeConnections();
       
    }
}
