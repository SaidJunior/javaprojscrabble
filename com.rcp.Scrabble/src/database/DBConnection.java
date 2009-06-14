package database;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;


public class DBConnection implements Connection {
	

    private DBConnectionPool pool;
    private Connection conn;
    private boolean inuse;
    private long timestamp;


    public DBConnection(Connection conn, DBConnectionPool pool) 
	{
        this.conn = conn;
        this.pool = pool;
        this.inuse = false;
        this.timestamp = 0;
    }

    protected Connection getConnection() 
	{
	    return conn;
	}
    
    public synchronized boolean getBusy() 
	{
       if(inuse)  
	   {
           return false;
       } 
       else 
	   {
          inuse=true;
          timestamp=System.currentTimeMillis();
          return true;
       }
    }
	
    public boolean validate() 
	{
		try 
		{
			conn.getMetaData();
		}catch (Exception e) 
		{
			return false;
		}
		
		return true;
    }

    public synchronized boolean inUse() 
	{
        return inuse;
    }

    public long getLastUse() 
	{
        return timestamp;
    }

    public void close() throws SQLException 
	{
        pool.returnConnection(this);
    }

    protected void expireUse() 
	{
        inuse = false;
    }

	public PreparedStatement prepareStatement(String sql) throws SQLException {
	    return conn.prepareStatement(sql);
	}

	
	
	public CallableStatement prepareCall(String sql) throws SQLException {
	    return conn.prepareCall(sql);
	}

	public Statement createStatement() throws SQLException 
	{
	    return conn.createStatement();
	}

	public String nativeSQL(String sql) throws SQLException {
	    return conn.nativeSQL(sql);
	}

    public void setAutoCommit(boolean autoCommit) throws SQLException {
	    conn.setAutoCommit(autoCommit);
	}

	public boolean getAutoCommit() throws SQLException {
	    return conn.getAutoCommit();
	}

	public void commit() throws SQLException {
	    conn.commit();
	}

	public void rollback() throws SQLException {
	    conn.rollback();
	}

	public boolean isClosed() throws SQLException {
        return conn.isClosed();
    }
	
	public DatabaseMetaData getMetaData() throws SQLException {
	    return conn.getMetaData();
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
	    conn.setReadOnly(readOnly);
	}
	  
	public boolean isReadOnly() throws SQLException {
	    return conn.isReadOnly();
	}

	public void setCatalog(String catalog) throws SQLException {
        conn.setCatalog(catalog);
    }

    public String getCatalog() throws SQLException {
        return conn.getCatalog();
    }

    public void setTransactionIsolation(int level) throws SQLException {
        conn.setTransactionIsolation(level);
    }

    public int getTransactionIsolation() throws SQLException {
        return conn.getTransactionIsolation();
    }
	public SQLWarning getWarnings() throws SQLException {
        return conn.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        conn.clearWarnings();
    }

	public Statement createStatement(int arg0, int arg1) throws SQLException {
		return conn.createStatement(arg0, arg1);
	}

	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2)
			throws SQLException {
		
		return conn.prepareStatement(arg0, arg1, arg2);
	}

	public CallableStatement prepareCall(String arg0, int arg1, int arg2)
			throws SQLException {
		
		return conn.prepareCall(arg0,arg1,arg2);
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		
		return conn.getTypeMap();
	}

	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
		conn.setTypeMap(arg0);

	}

	public void setHoldability(int arg0) throws SQLException {
		conn.setHoldability(arg0);

	}

	public int getHoldability() throws SQLException {
		
		return conn.getHoldability();
	}

	public Savepoint setSavepoint() throws SQLException {
		
		return conn.setSavepoint();
	}

	public Savepoint setSavepoint(String arg0) throws SQLException {
		
		return conn.setSavepoint(arg0);
	}

	public void rollback(Savepoint arg0) throws SQLException {
		conn.rollback(arg0);

	}

	public void releaseSavepoint(Savepoint arg0) throws SQLException {
		conn.releaseSavepoint(arg0);

	}

	public Statement createStatement(int arg0, int arg1, int arg2)
			throws SQLException {
		
		return conn.createStatement(arg0, arg1, arg2);
	}

	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2,
			int arg3) throws SQLException {
		
		return conn.prepareStatement(arg0, arg1, arg2,arg3);
	}

	public CallableStatement prepareCall(String arg0, int arg1, int arg2,
			int arg3) throws SQLException {
		
		return conn.prepareCall(arg0, arg1, arg2,arg3);
	}

	public PreparedStatement prepareStatement(String arg0, int arg1)
			throws SQLException {
		
		return conn.prepareStatement(arg0,arg1);
	}

	public PreparedStatement prepareStatement(String arg0, int[] arg1)
			throws SQLException {
		
		return conn.prepareStatement(arg0,arg1);
	}

	public PreparedStatement prepareStatement(String arg0, String[] arg1)
			throws SQLException {
		
		return conn.prepareStatement(arg0, arg1);
	}

	public Clob createClob() throws SQLException {
		
		return conn.createClob();
	}

	public Blob createBlob() throws SQLException {
		
		return conn.createBlob();
	}

	public NClob createNClob() throws SQLException {
		
		return conn.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		
		return conn.createSQLXML();
	}

	public boolean isValid(int arg0) throws SQLException {
		
		return conn.isValid(arg0);
	}

	public void setClientInfo(String arg0, String arg1)
			throws SQLClientInfoException {
		conn.setClientInfo(arg0, arg1);

	}

	public void setClientInfo(Properties arg0) throws SQLClientInfoException {
		conn.setClientInfo(arg0);

	}

	public String getClientInfo(String arg0) throws SQLException {
		
		return conn.getClientInfo(arg0);
	}

	public Properties getClientInfo() throws SQLException {
		
		return conn.getClientInfo();
	}

	public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
		
		return conn.createArrayOf(arg0, arg1);
	}

	public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
		
		return conn.createStruct(arg0, arg1);
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		
		return conn.unwrap(arg0);
	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		
		return conn.isWrapperFor(arg0);
	}

}
