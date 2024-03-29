/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlayersNamesDialog.java
 *
 * Created on Mar 26, 2009, 1:07:14 AM
 */

package NewGUI;

import scrabbleMain.Game;
import scrabbleMain.GameGui;

/**
 *
 * @author Erez Reshef
 */
public class PlayersNamesDialog extends javax.swing.JDialog {

	private static String name1 = "";
	private static String name2 = "";
	private static String name3 = "";
	private static String name4 = "";
//	private static boolean isAuto1 = false;
	private static boolean isAuto2 = false;
	private static boolean isAuto3 = false;
	private static boolean isAuto4 = false;
	
    public void initNames()
    {
        this.Player1TextField.setText(getName1());
        this.Player2TextField.setText(getName2());
        this.Player3TextField.setText(getName3());
        this.Player4TextField.setText(getName4());
    }

    public void setGameParameters(int numPlayers){
        if (numPlayers == 2)
        {
            this.Player2Label.setEnabled(true);
            this.Player2TextField.setEnabled(true);
            PlayersNamesDialog.setName3("");
            PlayersNamesDialog.setName4("");
            if(NewGameDialog.getGameType() == 0)
            	this.computerPlayer2CheckBox.setEnabled(true);
        }
        else
        {
            if(numPlayers == 3)
            {
                this.Player2Label.setEnabled(true);
                this.Player2TextField.setEnabled(true);
                this.Player3Label.setEnabled(true);
                this.Player3TextField.setEnabled(true);
                PlayersNamesDialog.setName4("");
                if(NewGameDialog.getGameType() == 0)
                {
                	this.computerPlayer2CheckBox.setEnabled(true);
                	this.computerPlayer3CheckBox.setEnabled(true);
                }
            }
            else
            {
                if(numPlayers == 4)
                {
                    this.Player2Label.setEnabled(true);
                    this.Player2TextField.setEnabled(true);
                    this.Player3Label.setEnabled(true);
                    this.Player3TextField.setEnabled(true);
                    this.Player4Label.setEnabled(true);
                    this.Player4TextField.setEnabled(true);
                    if(NewGameDialog.getGameType() == 0)
                    {
                        this.computerPlayer2CheckBox.setEnabled(true);
                        this.computerPlayer3CheckBox.setEnabled(true);
                        this.computerPlayer4CheckBox.setEnabled(true);
                    }
                }
                else
                {
                    PlayersNamesDialog.setName2("");
                    PlayersNamesDialog.setName3("");
                    PlayersNamesDialog.setName4("");
                }

            }
        }

    }

    /** Creates new form PlayersNamesDialog */
    public PlayersNamesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeLabel = new javax.swing.JLabel();
        Player1Label = new javax.swing.JLabel();
        Player2Label = new javax.swing.JLabel();
        Player3Label = new javax.swing.JLabel();
        Player4Label = new javax.swing.JLabel();
        Player1TextField = new javax.swing.JTextField();
        Player2TextField = new javax.swing.JTextField();
        Player3TextField = new javax.swing.JTextField();
        Player4TextField = new javax.swing.JTextField();
        StartGameButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        computerPlayer2CheckBox = new javax.swing.JCheckBox();
        computerPlayer3CheckBox = new javax.swing.JCheckBox();
        computerPlayer4CheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 14));// NOI18N      
        WelcomeLabel.setText("Type Players's Names:"); 
        WelcomeLabel.setToolTipText("All names must have 1-20 letters"); 

        Player1Label.setText("Player 1:");

        Player2Label.setText("Player 2:");
        Player2Label.setEnabled(false);

        Player3Label.setText("Player 3:");
        Player3Label.setEnabled(false);

        Player4Label.setText("Player 4:");
        Player4Label.setEnabled(false);

        Player1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1TextFieldActionPerformed(evt);
            }
        });

        Player2TextField.setEnabled(false);

        Player3TextField.setEnabled(false);

        Player4TextField.setEnabled(false);

        StartGameButton.setFont(new java.awt.Font("Tahoma", 1, 14));// NOI18N
        StartGameButton.setText("Start Game!");
        StartGameButton.setToolTipText("Let's Scrabble!!!");
        StartGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGameButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Tahoma", 1, 12));// NOI18N
        BackButton.setText("< Back");
        BackButton.setToolTipText("Back to previous screen");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Tahoma", 1, 14));// NOI18N
        Cancel.setText("Cancel");
        Cancel.setToolTipText("leave new game screen");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Computer");

        computerPlayer2CheckBox.setEnabled(false);
        computerPlayer2CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerPlayer2CheckBoxActionPerformed(evt);
            }
        });

        computerPlayer3CheckBox.setEnabled(false);
        computerPlayer3CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerPlayer3CheckBoxActionPerformed(evt);
            }
        });

        computerPlayer4CheckBox.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StartGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Player4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4TextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Player3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player3TextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Player2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player2TextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Player1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(computerPlayer4CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(computerPlayer3CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(computerPlayer2CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Player1Label)
                            .addComponent(Player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Player2Label)
                            .addComponent(Player2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Player3Label)
                            .addComponent(Player3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Player4Label)
                            .addComponent(Player4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(computerPlayer2CheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(computerPlayer3CheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(computerPlayer4CheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Player1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1TextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_Player1TextFieldActionPerformed

    /*
     * This methos will be used to start a new game. get all game params from this method.
     * */
    private void StartGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartGameButtonActionPerformed
    	//get all names:
    	setNamesActionPerformed();
    	//check if names are valid 
    	String message = checkIfValidNames();
    	if (!"".equals(message))
    	{
    		GeneralMessage.stratGeneralMessage(this, message, "Names feed problem");
    		return;
    	}
    	
    	//check that not all players are automatic
//    	if ((message = checkThatNotAllAuto()) != null) {
//    		GeneralMessage.stratGeneralMessage(this, message, "Players feed problem");
//    		return;
//    	}
    	//LOGIC
    	
    	
//    	String[] playerNames = new String[4];
//    	playerNames[0] = name1;
//    	playerNames[1] = name2;
//    	playerNames[2] = name3;
//    	playerNames[3] = name4;
    	
    	PlayerInfo[] playerInfo = new PlayerInfo[4];
    	playerInfo[0] = new PlayerInfo(name1, false);
    	playerInfo[1] = new PlayerInfo(name2, isAuto2);
    	playerInfo[2] = new PlayerInfo(name3, isAuto3);
    	playerInfo[3] = new PlayerInfo(name4, isAuto4);
    	
//    	GameGui.createPlayerList(playerNames);
    	GameGui.createPlayerList(playerInfo);
    	//END_LOGIC
    	
        //check if all names are valid
        //dispose new game window at the end
        NewGameDialog.initGameParamsToDefault();
        initNamesToDefault();
        dispose();

        //close the parent screen
        NewGameDialog.initParentScreen();

        MainWindow = new MainWindow1();
        MainWindow.setVisible(true);
 
    }//GEN-LAST:event_StartGameButtonActionPerformed

//    private static String checkThatNotAllAuto() {
//		if ((GameGui.getG().getNumberOfPlayers() == 1) && isAuto1) {
//			return "A game with one player must be with a human player";
//		}
//		if ((GameGui.getG().getNumberOfPlayers() == 2) && isAuto1 && isAuto2) {
//			return "One of the players must be human";
//		}
//		if ((GameGui.getG().getNumberOfPlayers() == 3) && isAuto1 && isAuto2 && isAuto3) {
//			return "One of the players must be human";
//		}
//		if ((GameGui.getG().getNumberOfPlayers() == 4) && isAuto1 && isAuto2 && isAuto3 && isAuto4) {
//			return "One of the players must be human";
//		}
//		return null;
//	}

	private static String checkIfValidNames()
    {
    	String message = "";
    	String temp = checkIfValidName(name1);
    	if (temp != null)
    		message += "Player1 name is not vaild: \n" + temp;
    	
    	if (NewGameDialog.getNumOfPlayers() > 1)
    	{
    		temp = checkIfValidName(name2);
    		if (temp!= null)
    			message += "\nPlayer2 name is not vaild: \n" + temp;
    	}
    	if (NewGameDialog.getNumOfPlayers() > 2)
    	{
    		temp = checkIfValidName(name3);
    		if (temp!= null)
    			message += "\nPlayer3 name is not vaild: \n" + temp;
    	}
    	if (NewGameDialog.getNumOfPlayers() > 3)
    	{
    		temp = checkIfValidName(name4);
    		if (temp!= null)
    			message += "\nPlayer4 name is not vaild: \n" + temp;
    	}

    	return message;
    }
    
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
    	setNamesActionPerformed();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final NewGameDialog nGDialog = new NewGameDialog(new javax.swing.JFrame(), true);
                nGDialog.setGameParameters();
                nGDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    	nGDialog.dispose();
                    }
                });
                 //dispose new game window at the end
                dispose();
                nGDialog.setLocation(100, 100);
                nGDialog.setVisible(true);
            }
        });
}//GEN-LAST:event_BackButtonActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        initNamesToDefault();
        NewGameDialog.initGameParamsToDefault();
        this.dispose();
}//GEN-LAST:event_CancelActionPerformed

    private void computerPlayer2CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerPlayer2CheckBoxActionPerformed
        if(computerPlayer2CheckBox.isSelected()) {
            Player2TextField.setEnabled(false);
            isAuto2 = true;
        }
        else
            Player2TextField.setEnabled(true);
    }//GEN-LAST:event_computerPlayer2CheckBoxActionPerformed

    private void computerPlayer3CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        if(computerPlayer3CheckBox.isSelected()) {
            Player3TextField.setEnabled(false);
            isAuto3 = true;
        }
        else
            Player3TextField.setEnabled(true);
    }                                                       

    private void computerPlayer4CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerPlayer3CheckBoxActionPerformed
        if(computerPlayer4CheckBox.isSelected()) {
            Player4TextField.setEnabled(false);
            isAuto4 = true;
        }
        else
            Player4TextField.setEnabled(true);
    }//GEN-LAST:event_computerPlayer3CheckBoxActionPerformed
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final PlayersNamesDialog dialog = new PlayersNamesDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    	dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel Player1Label;
    private javax.swing.JTextField Player1TextField;
    private javax.swing.JLabel Player2Label;
    private javax.swing.JTextField Player2TextField;
    private javax.swing.JLabel Player3Label;
    private javax.swing.JTextField Player3TextField;
    private javax.swing.JLabel Player4Label;
    private javax.swing.JTextField Player4TextField;
    private javax.swing.JButton StartGameButton;
    private javax.swing.JLabel WelcomeLabel;
    public 	MainWindow1 MainWindow;
    private javax.swing.JCheckBox computerPlayer2CheckBox;
    private javax.swing.JCheckBox computerPlayer3CheckBox;
    private javax.swing.JCheckBox computerPlayer4CheckBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables


	public static String getName1() {
		return name1;
	}

	public static void setName1(String name1) {
		PlayersNamesDialog.name1 = name1;
	}

	public static String getName2() {
		return name2;
	}

	public static void setName2(String name2) {
		PlayersNamesDialog.name2 = name2;
	}

	public static String getName3() {
		return name3;
	}

	public static void setName3(String name3) {
		PlayersNamesDialog.name3 = name3;
	}

	public static String getName4() {
		return name4;
	}

	public static void setName4(String name4) {
		PlayersNamesDialog.name4 = name4;
	}
	
	public static void initNamesToDefault()
	{
		PlayersNamesDialog.setName1("");
		PlayersNamesDialog.setName2("");
		PlayersNamesDialog.setName3("");
		PlayersNamesDialog.setName4("");
	}
	
	public void setNamesActionPerformed()
	{
    	setName1(Player1TextField.getText());
    	setName2(Player2TextField.getText());
    	setName3(Player3TextField.getText());
    	setName4(Player4TextField.getText());
	}

	private static String checkIfValidName(String name) {
		
		if (name == null || "".equals(name))
		{
			return "Name cannot be empty"; 
		}
		if (name.length() > 19)		
			return "Name length must be smaller than 20 letters.";
		return null;
	}
	
	//add by eviatar for automatic players creation
	public class PlayerInfo {
		private String playerName;
		private boolean isAuto;
		
		private PlayerInfo(String playerName, boolean isAuto) {
			this.playerName = playerName;
			this.isAuto     = isAuto;
		}
		
		public boolean isAuto() {
			return isAuto;
		}

		public void setAuto(boolean isAuto) {
			this.isAuto = isAuto;
		}

		public String getPlayerName() {
			return playerName;
		}
		
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
	}
}
