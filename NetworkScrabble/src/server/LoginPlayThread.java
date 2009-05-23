package server;

import gameUsers.User;
import gameUsers.UserDBQueries;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import comunicationProtocol.UserInfo;

import database.DBException;

public class LoginPlayThread extends Thread{
	private final static int OK = 0;
	private final static int USER_NAME_ALREADY_EXIST = 1;
	private final static int FAIL = 2;
	private final static int USERNAME_AND_PASSWOND_MISMATCH = 3; //also for username not exist
	
	private Socket  mySocket   = null;//this socket belongs to the player currently being logged in. we need a better name...
	private ObjectOutputStream out;
	private ObjectInputStream in;
	

    public LoginPlayThread(Socket mySocket) {
    	super("ServerLoginPlayThread");
    	this.mySocket   = mySocket;
    }

    public void run() {
     	try {
			out = new ObjectOutputStream(mySocket.getOutputStream());
		    in  = new ObjectInputStream (mySocket.getInputStream());
		    UserDBQueries userDB = MultiServer.userDB;
		    UserInfo userInfo = null;
		    
		    while (true) {
			    try {
					userInfo = (UserInfo) in.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("server fail to get user info from client");
					e.printStackTrace();
				}
				
				String userName     = userInfo.getUserName();
				String userPassword = userInfo.getUserPassword();
//				System.out.println(userName);
//				System.out.println(userPassword);
//				System.out.println(userInfo.getUserEMail());
				
				//Guest request
				if (userPassword == null) {
					returnOK();
					break;
				}
				//Existing request
				else if (userInfo.getUserEMail() == null) {
					try {
						if (userDB.getUserDetails(userName, userPassword, true) == null) {
							System.out.println("name not exist");
							returnMismatch();
						}
						else {
							returnOK();
							break;
						}
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("data base fail");
						returnFail();
					}
					/*DEBUG code*/
					catch (NullPointerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("data base fail null pointers");
						returnFail();
						break;
					}
					/*DEBUG end*/
					
					//DEBUG
//					returnFail();
//					break;
				}
				//New request
				else {
					User user = new User();
					user.setName(userName);
					user.setPassword(userPassword);
					user.setEmail(userInfo.getUserEMail());
					boolean addResault;
					try {
						addResault = userDB.addNewUser(user);
						if (addResault == true) {
							returnOK();
						}
						else {
							returnAlreadyExist();
						}
					} catch (DBException e) {
						// TODO Auto-generated catch block
						System.out.println("data base fail");
						e.printStackTrace();
						returnFail();
					}
				}
				/* debug */
//			    break;
			    /* end debug */
     		}
		    out.close();
		    in.close();
		   //socket.close(); //should not be closed later  
     	} catch (IOException e) {
     		System.out.println("server failed to connect");
     		e.printStackTrace();
     	}
     	
     	//ask if computer or player
     	System.out.println("Reached coputer querry.");//DEBUG
     	
     	Socket secondPlayerSock = null;
     	if((secondPlayerSock = MultiServer.getWaitSocket()) != null /*&& not computer play*/){ // we do have somebody to play with
     		MultiServer.setWaitSocket(null);
     		//start playing!!!
     		
     	}
     	/*else if (computer) {....}*/
     	else{// become a waiting player
     		MultiServer.setWaitSocket(mySocket);
     	} 
    }

	private void returnMismatch() {
		sendResponseToClient(USERNAME_AND_PASSWOND_MISMATCH);
	}

	private void returnAlreadyExist() {
		sendResponseToClient(USER_NAME_ALREADY_EXIST);
	}

	private void returnOK() {
		sendResponseToClient(OK);
	}
	
	private void returnFail() {
		sendResponseToClient(FAIL);
	}

	private void sendResponseToClient(int message) {
		try {
			out.writeObject(message);
//			System.out.println("send" + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("server fail to send: " + message);
			e.printStackTrace();
		}
	}
}
