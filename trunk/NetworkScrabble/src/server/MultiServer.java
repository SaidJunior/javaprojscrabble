package server;

import gameUsers.UserDBQueries;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import comunicationProtocol.UserInfo;

import database.UserQueriesImpl;

public class MultiServer {
	public static UserDBQueries userDB = new UserQueriesImpl();	
	
	private static Socket  waitSocket = null;  // Waiting user socket, shared between threads, private insures synchronized access 
	public  static synchronized void   setWaitSocket(Socket newSocket){
		/*DEBUG*/
		if(waitSocket == null)
			System.out.println("null socket changed!");
		else
			System.out.println("existing socket changed!");
		/*END DEBUG*/
		waitSocket = newSocket;
	}
	public  static synchronized Socket getWaitSocket()                {return waitSocket;}
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
        boolean listening  = true;
        Socket  playerSocket = null;

        try {
            serverSocket = new ServerSocket(4445);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4445");
            System.exit(-1);
        }

        while (listening){
			try {
				playerSocket = serverSocket.accept();
				new LoginPlayThread(playerSocket).start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
