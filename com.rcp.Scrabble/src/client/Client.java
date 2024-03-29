package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import scrabbleMain.GameChunk;
import scrabbleMain.GameGui;
import Gui.MainWindow_ver2;
import Gui.NewMultiDialog.ClientInfo;

import comunicationProtocol.UserInfo;

public class Client {
	private final static int OK = 0;
	private final static int USER_NAME_ALREADY_EXIST = 1;
	private final static int FAIL = 2;
	private final static int USERNAME_AND_PASSWOND_MISMATCH = 3; //also for username not exist
//	private final static int WAIT = 4;
	private static boolean isGameFinished = false; //update this according to the received object
	//log to local server
	@SuppressWarnings("unused")
	private InetAddress serverAddress = getLocalHost();
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket clientSock;
	private UserInfo userInfo;
	private ClientInfo clientInfo;
	private MainWindow_ver2 window;
	
	public Client(final MainWindow_ver2 window) {
		try {
			//log to server in tau:
            clientSock = new Socket("kite.cs.tau.ac.il", 40775);
			//log to local server
//            clientSock = new Socket(serverAddress, 40775);
            out = new ObjectOutputStream(clientSock.getOutputStream());
            in  = new ObjectInputStream (clientSock.getInputStream());
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: local host");
            Display.getDefault().asyncExec(new Runnable() {
    			public void run() {
		            MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
		            connectionFailBox.setText("Connection Fail");
		            connectionFailBox.setMessage("Failed to connect to server, try again later");
		            connectionFailBox.open();
    			}
            });
//            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: local host");
            Display.getDefault().asyncExec(new Runnable() {
    			public void run() {
    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
		            connectionFailBox.setText("Connection Fail");
		            connectionFailBox.setMessage("Failed to connect to server, try again later");
		            connectionFailBox.open();
    			}
            });
//            System.exit(1);
        }
        
        userInfo = new UserInfo(getLocalHost());
        this.window = window;
	}
	
	public void startToPlay(){
		if (clientInfo.isUser()){ //if user
			if (clientInfo.isNewUser())
				loginAsNew();
			else
				loginAsUser();
		}
		else //if guest
			loginAsGuest();
		
		char answer = waitOrStart();
//		try {
//	    	   out.writeObject(answer);
//	       } catch (IOException e) {
//	    	   System.out.println("client failed with choose game mode");
//	    	   e.printStackTrace();
//	    	   Display.getDefault().asyncExec(new Runnable() {
//	    			public void run() {
//	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
//			            connectionFailBox.setText("Connection Fail");
//			            connectionFailBox.setMessage("Failed to connect to server, try again later");
//			            connectionFailBox.open();
//	    			}
//	            });;
//	       } 
//	    userInformPopUp();
	   if (answer == 'n') { //start playing
		   this.startGame();
	   }
	   else {
		 Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					waitMsgBox = new MessageBox(window.getShell(), SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
					waitMsgBox.setText("Scrabble Server Information");
					waitMsgBox.setMessage("Currently, there are no waiting player. Do you want to wait?");
					answerToWaitPopUp = waitMsgBox.open();
//					System.out.println(answerToWaitPopUp == SWT.YES ? "y" : "n");
					if (answerToWaitPopUp == SWT.YES) {
						answerToWaitPopUp = 'y';
						window.setPlayStatusText("Waiting...");
						try {
							out.writeObject(answerToWaitPopUp);
						} catch (IOException e) {
							System.out.println("sending answerToWaitPopUp failed");
							e.printStackTrace();
							MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
				            connectionFailBox.setText("Connection Fail");
				            connectionFailBox.setMessage("Failed to connect to server, try again later");
				            connectionFailBox.open();
						}
					} else {
						answerToWaitPopUp = 'n';
						try {
							out.writeObject(answerToWaitPopUp);
						} catch (IOException e) {
							System.out.println("sending answerToWaitPopUp failed");
							e.printStackTrace();
							MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
				            connectionFailBox.setText("Connection Fail");
				            connectionFailBox.setMessage("Failed to connect to server, try again later");
				            connectionFailBox.open();
						}
						closeSocket();
					}	
				}
			});	}
//	   try {
//		Thread.sleep(1000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	   while (answerToWaitPopUp == 0);
//	   System.out.println("bla   " + answerToWaitPopUp);
	   if (answerToWaitPopUp == 'y') {
//		   System.out.println("bla");
		   String a = null;
		try {
			a = (String)in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   if (a.equals("areYouStillThere?")) {
			   try {
				out.writeObject("yes");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   this.startGame();
	   }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
     //Client client = new Client();
       
       /* if New user button is pressed */
//       client.loginAsNew();
       /* else if guest button is pressed */
     //client.loginAsGuest();
       /* else if existing user button pressed */
//       client.loginAsUser();
       
      
      /* char answer = client.chooseGameMode();
       try {
    	   client.out.writeObject(answer);
       } catch (IOException e) {
    	   System.out.println("client failed with choose game mode");
    	   e.printStackTrace();
       } //choose between a human or computer player
       
       client.userInformPopUp();*/
       
       
       
       //******* main loop ***************/
      /* while (isGameFinished  == false) {
    	   GameChunk gameChunk = null;
    	   //wait until game start
	       try {
				gameChunk = (GameChunk)client.in.readObject(); //wait for a player
			} catch (IOException e) {
				System.out.println("client fail with getting gameChunk");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("client fail with getting gameChunk");
				e.printStackTrace();
			}
			
			//1)paint game window according to gameChunk
			//2)update gameChunk
			//3)when player pressed "done" call client.sendMoveToServer(gameChunk); 
			
			//debug
			/*client.showChunk((String)gameChunk);
			client.sendMoveToServer(gameChunk + "a");*/
      // }
	       
       
      // client.closeSocket();
    }
	
	
	//this is for debug
//	private void showChunk(String gameChunk) {
//		System.out.println(gameChunk);
//	}
	
	public void sendMoveToServer(Object gameChunk) {
		try {
	    	   this.out.writeObject(gameChunk);
	       } catch (IOException e) {
	    	   System.out.println("client failed to send gameChunk to server");
	    	   e.printStackTrace();
	    	   Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
	       } 
	}
	
//	private void userInformPopUp() {
//		try {
//			   int serverResponse = (Integer)in.readObject();
//			   
//			   switch (serverResponse) {
//			   	case OK: startGame(); break;
//			   	case WAIT: waitToPlay(); break;
//			   	default: System.out.println("bug1");
//			   }
//		   } catch (IOException e) {
//			   Display.getDefault().asyncExec(new Runnable() {
//	    			public void run() {
//	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
//			            connectionFailBox.setText("Connection Fail");
//			            connectionFailBox.setMessage("Failed to connect to server, try again later");
//			            connectionFailBox.open();
//	    			}
//	            });
//			   System.out.println("server replay fail");
//			   e.printStackTrace();
//		   } catch (ClassNotFoundException e) {
//			   Display.getDefault().asyncExec(new Runnable() {
//	    			public void run() {
//	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
//			            connectionFailBox.setText("Connection Fail");
//			            connectionFailBox.setMessage("Failed to connect to server, try again later");
//			            connectionFailBox.open();
//	    			}
//	            });
//			   System.out.println("server replay fail");
//			e.printStackTrace();
//		}	
//	}
//	private void waitToPlay() {
//		window.setPlayStatusText("Waiting for a player...");
//	}
	private void startGame() {
		System.out.println("start game");
		 while (isGameFinished  == false) {
	    	   GameChunk gameChunk = null;
	    	   //wait until game start
		       try {
		    	   gameChunk = (GameChunk)in.readObject(); 
		       } catch (IOException e) {
					System.out.println("client fail with getting gameChunk");
//					Display.getDefault().asyncExec(new Runnable() {
//		    			public void run() {
//		    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
//				            connectionFailBox.setText("Connection Fail");
//				            connectionFailBox.setMessage("Failed to connect to server, try again later");
//				            connectionFailBox.open();
//		    			}
//		            });
					e.printStackTrace();
					otherConnectionClosed();
				} catch (ClassNotFoundException e) {
					System.out.println("client fail with getting gameChunk");
					Display.getDefault().asyncExec(new Runnable() {
		    			public void run() {
		    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
				            connectionFailBox.setText("Connection Fail");
				            connectionFailBox.setMessage("Failed to connect to server, try again later");
				            connectionFailBox.open();
		    			}
		            });
					e.printStackTrace();
					otherConnectionClosed();
				}
				if (gameChunk.isSecondPlayerClosed() == true) { //second player closed his connection
					System.out.println("blaa");
					otherConnectionClosed();
					closeSocket();
				} else {
					Display.getDefault().asyncExec(new Runnable() {
			    		   public void run() {
			    			   if ((window.getPlayStatusText()).equals("Waiting...")) {
			    				   window.setPlayStatusText(""); //this is for the waiting... status
			    			   }
			    		   }
			    	   });
					window.onOffButtonsAndDrag(true);
					//1)paint game window according to gameChunk
					//2)update gameChunk
					//3)when player pressed "done" call client.sendMoveToServer(gameChunk); 
					GameGui.G.insertGameChunk(gameChunk);
			    	//window.updateNowPlayingText();
					window.updateWindow();
					//3)is done in window...We need to stall
					//System.out.println(GameGui.G.getCurrentPlayerName());
				}
				while (window.signalDone == false){}
				window.onOffButtonsAndDrag(false);
				window.signalDone = false;
	    }
	}

private void otherConnectionClosed() {
	Display.getDefault().asyncExec(new Runnable() {
		public void run() {
			String message = ((window.getPlayStatusText()).equals("Waiting...")) ?
					"A game was started but the other side closed the connection": 
				    "Your opponent closed his connection, You must be a hell of a player";
			MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
	        connectionFailBox.setText("Connection Fail");
	        connectionFailBox.setMessage(message); 
	        connectionFailBox.open();
		}
	});
}
	
	private char waitOrStart() {
		 try {
	    	   this.in.readObject();
		   } catch (IOException e1) {
			   System.out.println("client failed to get waitOrNo");
			   e1.printStackTrace();
			   Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
		   } catch (ClassNotFoundException e1) {
			   System.out.println("client failed to get waitOrNo");
			   e1.printStackTrace();
			   Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
		   }
		
		char answerIsTherePlayersWaiting = 0;  
		try { //ask server if there are any players waiting
			answerIsTherePlayersWaiting = (Character)in.readObject();
		} catch (IOException e1) {
			System.out.println("client fail to get answerIsTherePlayersWaiting");
			e1.printStackTrace();
			Display.getDefault().asyncExec(new Runnable() {
    			public void run() {
    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
		            connectionFailBox.setText("Connection Fail");
		            connectionFailBox.setMessage("Failed to connect to server, try again later");
		            connectionFailBox.open();
    			}
            });
		} catch (ClassNotFoundException e1) {
			System.out.println("client fail to get answerIsTherePlayersWaiting");
			e1.printStackTrace();
			Display.getDefault().asyncExec(new Runnable() {
    			public void run() {
    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
		            connectionFailBox.setText("Connection Fail");
		            connectionFailBox.setMessage("Failed to connect to server, try again later");
		            connectionFailBox.open();
    			}
            });
		}
		
		return answerIsTherePlayersWaiting;		
	}
	
	////// login methods 
	public void loginAsUser() {
		userInfo.setUserName(clientInfo.getPlayerName());
		userInfo.setUserPassword(clientInfo.getPassword());
		
		loginHandShake();
	}
	public void loginAsGuest() {
		userInfo.setUserName(clientInfo.getPlayerName());
	    
		loginHandShake();
	}
	
	public void loginAsNew() {
		userInfo.setUserName(clientInfo.getPlayerName());
		userInfo.setUserPassword(clientInfo.getPassword());
        userInfo.setUserEMail(clientInfo.getEmail());
        
        loginHandShake();
	}
	
	private void loginHandShake() {
		// send login request to server 
		try {
			 out.writeObject(userInfo);
	     } catch (IOException e) {
	    	 Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
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
			   Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
			   System.out.println("server replay fail");
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   Display.getDefault().asyncExec(new Runnable() {
	    			public void run() {
	    				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
			            connectionFailBox.setText("Connection Fail");
			            connectionFailBox.setMessage("Failed to connect to server, try again later");
			            connectionFailBox.open();
	    			}
	            });
			   e.printStackTrace();
		}
	}
	
	private MessageBox waitMsgBox;
	private int answerToWaitPopUp; 
	
	private void userPassWordMis() {
		 Display.getDefault().asyncExec(new Runnable() {
 			public void run() {
 				MessageBox loginErrorMsgBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
				loginErrorMsgBox.setText("Login Error");
				loginErrorMsgBox.setMessage("User Name or Password, was not entered prorerly. Try Agian");
				loginErrorMsgBox.open();
				window.toggleMenues(true);
 			}
		 });
//		System.out.println("mis");
		
	}
	private void userNameAlreadyExist() {
		 Display.getDefault().asyncExec(new Runnable() {
	 			public void run() {
	 				MessageBox loginErrorMsgBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
	 				loginErrorMsgBox.setText("Login Error");
					loginErrorMsgBox.setMessage("This User is already exist in our database. Please enter anothor one");
					loginErrorMsgBox.open();
					window.toggleMenues(true);

	 			}
		 });
//		System.out.println("already exists");
		
	}
	private void fail() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageBox connectionFailBox = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
	            connectionFailBox.setText("Connection Fail");
	            connectionFailBox.setMessage("Failed to connect to server, try again later");
	            connectionFailBox.open();
				window.toggleMenues(true);

			}
        });
		//System.out.println("fail");
		
	}
	private void loginComplete() {
		//System.out.println("ok");
	}
	
	//////////////////
	
	
//	private String getUserEMail() {
//		/* debug */
//		return "ohad@yahoo.com";
//	    /* end debug */
//	}
	
	
	
	//////////////////////////
	
	
	
	private InetAddress getLocalHost() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
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
			out.close();
			in.close();
			clientSock.close();
	
		} catch (IOException e) {
			System.out.println("Failed to close socket.");
			e.printStackTrace();
		}
	}
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
}


 
