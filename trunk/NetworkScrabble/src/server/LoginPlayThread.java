package server;

import gameUsers.User;
import gameUsers.UserDBQueries;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import scrabbleMain.GameChunk;
import scrabbleMain.GameGui;
import scrabbleMain.GameLogic;
import Gui.PlayerInfo;

import comunicationProtocol.UserInfo;

import database.DBException;

public class LoginPlayThread extends Thread{
        private final static int OK = 0;
        private final static int USER_NAME_ALREADY_EXIST = 1;
        private final static int FAIL = 2;
        private final static int USERNAME_AND_PASSWOND_MISMATCH = 3; //also for username not exist
//        private final static int WAIT = 4;
        
        private Socket  mySocket   = null;//this socket belongs to the player currently being logged in. we need a better name...
        private ObjectOutputStream out;
        private ObjectInputStream in;
        
        //private GameLogic G = new GameLogic();
        private GameChunk gameChunk; // this is the information package that would be sent  
		//private List<PlayerInfo> players;
        //static PlayerInfo[] playerInfo = new PlayerInfo[2];

    public LoginPlayThread(Socket mySocket) {
        super("ServerLoginPlayThread");
        this.mySocket   = mySocket;
        GameGui.initGameLogic();
        GameLogic G = GameGui.getG();
        G.setMode('b');
        G.setMulti();
        //GameGui.setNumberOfPlayers(2);
        
    }

    public void run() {
        String userName="";
        String userPassword;
        UserInfo userInfo = null;
		try {
                    out = new ObjectOutputStream(mySocket.getOutputStream());
                    in  = new ObjectInputStream (mySocket.getInputStream());
                    UserDBQueries userDB = MultiServer.userDB;
                    
                    while (true) {
                            try {
                                        userInfo = (UserInfo) in.readObject();
                                } catch (ClassNotFoundException e) {
                                        // TODO Auto-generated catch block
                                        System.out.println("server fail to get user info from client");
                                        e.printStackTrace();
                                }
                                
                                userName     = userInfo.getUserName();
                                userPassword = userInfo.getUserPassword();
                               
//                                                          
                                //Guest request
                                if (userPassword == null || userPassword.equals("")) {
                                		
                                        returnOK();
                                        break;
                                }
                                //Existing request
                                else if (userInfo.getUserEMail() == null || userInfo.equals("")) {
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
//                                      returnFail();
//                                      break;
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
                                                        break;
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
//                          break;
                            /* end debug */
                }
                    //out.close();
                    //in.close();
                   //socket.close(); //should not be closed later  
        } catch (IOException e) {
                System.out.println("server failed to connect");
                e.printStackTrace();
        }
        
        //inform client that login completed
        try {
			out.writeObject("loginCompleted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("server failed with computer or player");
			e.printStackTrace();
		}
	
        System.out.println("Reached coputer querry.");//DEBUG
        
        Socket secondPlayerSock = null;
        //TODO: optimize with Tor
        if((secondPlayerSock = MultiServer.getWaitSocket().getSocket()) != null) { // we do have somebody to play with
        	try {
				out.writeObject('n');
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        	GameGui.setNumberOfPlayers(2);
        	

        	//waiting player closed connection
        		if (secondPlayerSock.isClosed() || !secondPlayerSock.isConnected()) {
        			System.out.println("try");
//                	 MultiServer.setWaitSocket(mySocket, in, out, userInfo);
//                	 returnWait();
        			waitingProcedure(userInfo);
                }
        		else {
        			ObjectOutputStream secondPlayerOut = MultiServer.getWaitSocket().getOut();
        			ObjectInputStream  secondPlayerIn = MultiServer.getWaitSocket().getIn();
        			UserInfo u = MultiServer.getWaitSocket().getUserInfo();
        			PlayerInfo p[] = new PlayerInfo[2];
        			
        			p[0] = new PlayerInfo(userInfo.getUserName(), false);
        			p[1] = new PlayerInfo(u.getUserName(), false);
        			GameGui.createPlayerList(p);
        			MultiServer.setWaitSocket(null, null, null, null);
                			

//        			returnOK();
        			
        			ObjectOutputStream currentOut = out;
        			ObjectInputStream currentIn = in;
        			boolean player1Turn = true;
        			
        			
        			gameChunk = GameGui.G.extractGameChunk();
        			
        			while (GameGui.G.getFinishGame() == false) {
		                 
	                	//send to client game object chunk
		                try {
							currentOut.writeObject(gameChunk);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("sending chunk to client failed");
							e1.printStackTrace();
						}
						
						GameChunk tmpInChank = null;
						//get response from client1
						try {
							tmpInChank = (GameChunk)currentIn.readObject();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//************TODO: change game logic according to the in chunk********************
						//don't forget to update gameChunk;
						
					
						gameChunk = tmpInChank;
						GameGui.G.insertGameChunk(gameChunk);
						if (player1Turn == false) {
							currentIn = in;
							currentOut = out;
							player1Turn = true;
						}
						else {
							currentIn  = secondPlayerIn;
							currentOut = secondPlayerOut;
							player1Turn = false;
						}
	                }
	                
	                try {
	                	out.close();
	                	in.close();
						mySocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        }
//        else if (answer == 'a') {
//        	returnOK();
//        	GameGui.setNumberOfPlayers(2);
//        	
//        	PlayerInfo p[] = new PlayerInfo[2];
//        	
//			p[0] = new PlayerInfo(userInfo.getUserName(), false);
//			p[1] = new PlayerInfo("comp1",true);
//			GameGui.createPlayerList(p);
//        			
//    		
//			gameChunk = GameGui.G.extractGameChunk();
//			
//    		while (GameGui.G.getFinishGame() == false) {
//                
//            	//send to client game object chunk
//                try {
//					out.writeObject(gameChunk);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					System.out.println("sending chunk to client failed");
//					e1.printStackTrace();
//				}
//				
//				GameChunk tmpInChank = null;
//				//get response from client1
//				try {
//					tmpInChank = (GameChunk)in.readObject();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				//************TODO: change game logic according to the in-chunk and make an auto player move***************
//				//don't forget to update gameChunk;
//				gameChunk = tmpInChank;
//				GameGui.G.insertGameChunk(gameChunk);
//				GameGui.placeAutoWord();
//				GameGui.moveToNextPlayer();
//				gameChunk = GameGui.G.extractGameChunk();
//            }
//        	
//        	try {
//        		out.close();
//            	in.close();
//				mySocket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	
//        }
        else{// ask if you want to become a waiting player
        	waitingProcedure(userInfo);
//            		
        } 
    }

	private void waitingProcedure(UserInfo userInfo) {
		try {
			out.writeObject('y');
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int answer = 'y';
		try {
			answer = (Integer)in.readObject();
			System.out.println(answer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("server failed to get yes or no");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("server failed to get yes or no");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println((char)answer);
		if (answer == 'y') {    
			MultiServer.setWaitSocket(mySocket, in, out, userInfo);
//                returnWait();
		}
        else {     
		  try {
			  out.close();
		  	  in.close();
		  	  mySocket.close();
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
        }
	}

//        private void returnWait() {
//        	sendResponseToClient(WAIT);
//		
//        }

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
//                      System.out.println("send" + message);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.out.println("server fail to send: " + message);
                        e.printStackTrace();
                }
        }
}

