package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import server.MultiServer;
import comunicationProtocol.UserInfo;

public class Client {
	private final static int OK = 0;
	private final static int USER_NAME_ALREADY_EXIST = 1;
	private final static int FAIL = 2;
	private final static int USERNAME_AND_PASSWOND_MISMATCH = 3; //also for username not exist
	private final static int WAIT = 4;
	private static boolean isGameFinished = false; //update this according to the received object
	
	private InetAddress serverAddress = getLocalHost();
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket clientSock;
	private UserInfo userInfo;
	
	public Client() {
        try {
            clientSock = new Socket(serverAddress, 4445);
            out = new ObjectOutputStream(clientSock.getOutputStream());
            in  = new ObjectInputStream (clientSock.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: local host");
        	//TODO: popup connection to server failed
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: local host");
            //TODO: popup connection to server failed
            System.exit(1);
        }
        
        userInfo = new UserInfo(getLocalHost());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
       Client client = new Client();
       
       /* if New user button is pressed */
//       client.loginAsNew();
       /* else if guest button is pressed */
     client.loginAsGuest();
       /* else if existing user button pressed */
//       client.loginAsUser();
       
      
       char answer = client.chooseGameMode();
       try {
    	   client.out.writeObject(answer);
       } catch (IOException e) {
		// TODO Auto-generated catch block
    	   System.out.println("client failed with choose game mode");
    	   e.printStackTrace();
       } //choose between a human or computer player
       
       client.userInformPopUp();
       
       //******* main loop ***************/
       while (isGameFinished  == false) {
    	   Object gameChunk = null;
    	   //wait until game start
	       try {
				gameChunk = (Object)client.in.readObject(); //wait for a player
			} catch (IOException e) {
				System.out.println("client fail with getting gameChunk");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("client fail with getting gameChunk");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//1)paint game window according to gameChunk
			//2)update gameChunk
			//3)when player pressed "done" call client.sendMoveToServer(gameChunk); 
			
			//debug
			client.showChunk((String)gameChunk);
			client.sendMoveToServer(gameChunk + "a");
       }
	       
       
       client.closeSocket();
    }
	
	
	//this is for debug
	private void showChunk(String gameChunk) {
		System.out.println(gameChunk);
	}
	
	private void sendMoveToServer(Object gameChunk) {
		try {
	    	   this.out.writeObject(gameChunk);
	       } catch (IOException e) {
			// TODO Auto-generated catch block
	    	   System.out.println("client failed to send gameChunk to server");
	    	   e.printStackTrace();
	       } 
	}
	
	private void userInformPopUp() {
		try {
			   int serverResponse = (Integer)in.readObject();
			   
			   switch (serverResponse) {
			   	case OK: startGame(); break;
			   	case WAIT: waitToPlay(); break;
			   	default: System.out.println("bug1");
			   }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   System.out.println("server replay fail");
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void waitToPlay() {
		System.out.println("wait");
		// TODO add pop up informing that there are no currently human players so wait or exit- don't forget to close socket
	}
	private void startGame() {
		// TODO this is yours main work
		System.out.println("start game");
	}
	//'a' for auto player 'h' for human
	private char chooseGameMode() {
		 try {
	    	   this.in.readObject();
		   } catch (IOException e1) {
			   System.out.println("client failed to get computer or human");
			   e1.printStackTrace();
		   } catch (ClassNotFoundException e1) {
			   System.out.println("client failed to get computer or human");
			   e1.printStackTrace();
		   }
		 //TODO: add popup for the user to choose between a human player or auto player
		return 'h';
	}
	////// login methods 
	private void loginAsUser() {
		/* Debug */ 
		userInfo.setUserName("ohad");
		userInfo.setUserPassword("bla");
	    /* End Debug */
		
		/* TODO: something like
           userInfo.setName(nameText.getText());
           userInfo.setPassword(passwordText.getText());
        */
		
		loginHandShake();
	}
	private void loginAsGuest() {
		/* Debug */ 
		userInfo.setUserName("ohad");
	    /* End Debug */
		
		/* TODO: something like
           userInfo.setName(nameText.getText());
        */
		loginHandShake();
	}
	
	private void loginAsNew() {
		/* Debug */ 
		userInfo.setUserName("ohad");
		userInfo.setUserPassword("bla");
	    /* End Debug */
		
		/* TODO: something like
           userInfo.setName(nameText.getText());
           userInfo.setPassword(passwordText.getText());
        */
        userInfo.setUserEMail(getUserEMail());
        loginHandShake();
	}
	
	private void loginHandShake() {
		// send login request to server 
		try {
			 out.writeObject(userInfo);
	     } catch (IOException e) {
	         // TODO Auto-generated catch block
	    	 System.out.println("client failed to send");
	    	 e.printStackTrace();
	     }
	    
	    //get replay from server
		try {
			   int serverResponse = (Integer)in.readObject();
			   
			   switch (serverResponse) {
			   	case OK: loginComplete(); break;
			   	case FAIL: fail(); break;
			   	case USER_NAME_ALREADY_EXIST: userNameAlreadyExist(); break;
			   	case USERNAME_AND_PASSWOND_MISMATCH: userPassWordMis(); break;
			   	default: System.out.println("bug1");
			   }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   System.out.println("server replay fail");
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void userPassWordMis() {
		// TODO Auto-generated method stub
		System.out.println("mis");
		
	}
	private void userNameAlreadyExist() {
		// TODO Auto-generated method stub
		System.out.println("already exists");
		
	}
	private void fail() {
		// TODO Auto-generated method stub
		//System.out.println("fail");
		
	}
	private void loginComplete() {
		// TODO Auto-generated method stub
		//System.out.println("ok");
	}
	
	//////////////////
	
	
	private String getUserEMail() {
		//TODO: update for gui,  get the user's email
		/* debug */
		return "ohad@yahoo.com";
	    /* end debug */
	}
	
	
	
	//////////////////////////
	
	
	
	private InetAddress getLocalHost() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	@SuppressWarnings("unused")
	private void setLocalHost(InetAddress add) {
		serverAddress = add;
	}
	
	public void closeSocket(){
		try {
			clientSock.close();
		} catch (IOException e) {
			System.out.println("Failed to close socket.");
			e.printStackTrace();
		}
	}
}


 
