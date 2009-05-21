package server;

import gameUsers.UserDBQueries;

import java.io.IOException;
import java.net.ServerSocket;

import database.UserQueriesImpl;

public class MultiServer {
	public static UserDBQueries userDB = new UserQueriesImpl();	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4445);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4445");
            System.exit(-1);
        }

        while (listening)
			try {
				new LoginThread(serverSocket.accept()).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
}
