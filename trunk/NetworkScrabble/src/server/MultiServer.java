package server;

import gameUsers.UserDBQueries;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import database.UserQueriesImpl;

public class MultiServer {
	public static UserDBQueries userDB = new UserQueriesImpl();	
	
	private static SocketAndStreams  waitSocket = new SocketAndStreams();  // Waiting user socket, shared between threads, private insures synchronized access 
	
	
	public  static synchronized void   setWaitSocket(Socket socket, ObjectInputStream in, ObjectOutputStream out){
		/*DEBUG*/
		if(waitSocket.socket == null)
			System.out.println("null socket changed!");
		else
			System.out.println("existing socket changed!");
		/*END DEBUG*/
		waitSocket.socket = socket;
		waitSocket.in = in;
		waitSocket.out = out;
	}
	
	public  static synchronized SocketAndStreams getWaitSocket()                {return waitSocket;}
	
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
				new LoginPlayThread_updated(playerSocket).start();
				
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
	
	public static class SocketAndStreams {
		private Socket socket = null;
		private ObjectOutputStream out = null;
        private ObjectInputStream  in  = null;
        
		public Socket getSocket() {
			return socket;
		}
		public void setSocket(Socket socket) {
			this.socket = socket;
		}
		public ObjectOutputStream getOut() {
			return out;
		}
		public void setOut(ObjectOutputStream out) {
			this.out = out;
		}
		public ObjectInputStream getIn() {
			return in;
		}
		public void setIn(ObjectInputStream in) {
			this.in = in;
		}
	}
		
}
