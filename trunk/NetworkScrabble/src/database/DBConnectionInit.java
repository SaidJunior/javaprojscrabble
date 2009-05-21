package database;



import java.sql.*;



public class DBConnectionInit 
{

    private DBConnectionPool pool;
    private String driver = "oracle.jdbc.OracleDriver";
    //These parameters are for local-host using oracle connection 
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "scrabble";
	private String password = "scrabble";

    public DBConnectionInit() throws DBException 
    {
    	/*
    	PropertiesFile db_prop = new PropertiesFile();
    	String driver = db_prop.getProperty("driver");
    	String url = db_prop.getProperty("url");
    	String user = db_prop.getProperty("user");
    	String password = db_prop.getProperty("password");
    	*/
    	try
        {
   		 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
   		 Class.forName(driver).newInstance();
   		 pool = new DBConnectionPool(url, user, password);
        }
   	 	catch(Exception e)
        {
   		 System.out.println("Error message is: " + e.getMessage() );
   		 throw new DBException("Error to open a connection to the DB\nFull details: "+ e.toString());

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
