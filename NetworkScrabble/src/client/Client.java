package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//            clientSock = new Socket("kite.cs.tau.ac.il", 40775);
			//log to local server
            clientSock = new Socket(serverAddress, 40775);
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
		
	   String answer = waitOrStart();
	   if (answer.equals("noPlayers")) {
		 System.out.println("if: noPlayers");
		 askPlayerIfHeWantsToWait();
	   }
	   else if (answer.equals("PlayerWaiting")) { 
		   System.out.println("if: PlayerWaiting");
		   this.startGame();
	   }
	   else {
		   System.out.println("unknown state");
	   }
	}

	private void askPlayerIfHeWantsToWait() {
		Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					waitMsgBox = new MessageBox(window.getShell(), SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
					waitMsgBox.setText("Scrabble Server Information");
					waitMsgBox.setMessage("Currently, there are no waiting player. Do you want to wait?");
					answerToWaitPopUp = waitMsgBox.open();
					System.out.println("answer from wait box: " + (answerToWaitPopUp == SWT.YES ? "y" : "n"));
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
					}	
				}
			});	
//	   try {
//		Thread.sleep(1000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		   while (answerToWaitPopUp == 0);
	//	   System.out.println("bla   " + answerToWaitPopUp);
		   if (answerToWaitPopUp == 'y') {
			   System.out.println("waiting");
			   String verifyAttendecnce = null;
			   try {
				verifyAttendecnce = (String)in.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   if(verifyAttendecnce.equals("areYouStillThere?")) {
				   System.out.println("if: are you still there");
				   try {
						out.writeObject("yes");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					this.startGame();
			   }
		   }
		   else {
			   closeSocket();
		   }
	}
	
	
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
	
	private synchronized void startGame() {
		System.out.println("start game");
		System.out.println("1");
		 while (isGameFinished  == false) {
	    	   GameChunk gameChunk = null;
	    	   //wait until game start
		       try {
		    	   System.out.println("2");
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
					window.onOffButtonsAndDrag(false);
					window.signalDone = false;
					return;
				} else {
					System.out.println("3");
					Display.getDefault().asyncExec(new Runnable() {
			    		   public void run() {
			    			   if ((window.getPlayStatusText()).equals("Waiting...")) {
			    				   window.setPlayStatusText(""); //this is for the waiting... status
			    			   }
			    		   }
			    	   });
					System.out.println("4");
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
				System.out.println("5");
				while (window.signalDone == false){
//					window.lock.lock();
//					try {
//						window.signalDoneCond.await();
//						wait();
//					} catch (InterruptedException e) {
//						System.out.println("6");
//						e.printStackTrace();
//					} finally {
//						window.lock.unlock();
//					}
				}
				System.out.println("7");
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
	        window.setPlayStatusText("");
		}
	});
}
	
	private String waitOrStart() {
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
		
		
		String answerIsTherePlayersWaiting = null;  
		try { //ask server if there are any players waiting
			answerIsTherePlayersWaiting = (String)in.readObject();  // get "noPlayers" or ...
			System.out.println("answerIsThere: " + answerIsTherePlayersWaiting);
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


 
