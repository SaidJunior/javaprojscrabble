package server;

import gameUsers.UserDBQueries;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerShutDownTread extends Thread {
	private ServerSocket serverSocket = null;
	private UserDBQueries userDB = null;
	
	public ServerShutDownTread(ServerSocket serverSocket, UserDBQueries userDB) {
		this.serverSocket = serverSocket;
		this.userDB = userDB;
	}
	
	public void run() {
		userDB.CloseConnectionsDB();
		System.out.println("bla");
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("closing server socket failed");
		}
	}
	
}
