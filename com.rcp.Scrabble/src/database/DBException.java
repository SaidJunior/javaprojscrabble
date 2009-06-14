package database;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = null;
	
	public DBException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}
