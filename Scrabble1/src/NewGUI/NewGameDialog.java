/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewGameDialog2.java
 *
 * Created on Mar 26, 2009, 12:44:26 AM
 */

package NewGUI;

import scrabbleMain.GameGui;

/**
 *
 * @author Erez Reshef
 */
public class NewGameDialog extends javax.swing.JDialog {

	//game parameters, default values. 
	// 0 = basic game, 1 = advance game, 0 = BlueLettersColor
	private static int gameType = 0;
	private static int numOfPlayers = 1;
	private static int lettersColor = 0;
	
	//holds the screen that opened this dialog
	private static javax.swing.JFrame parent;
	
    public void setGameParameters(){
        //NumOfPlayersComboBox.setSelectedIndex(MainWindow1.getNumOfPlayers()-1);
        NumOfPlayersComboBox.setSelectedIndex(getNumOfPlayers() - 1);
        //if (MainWindow1.getGameType() == 0)
        if (getGameType() == 0)
        {
            AdvanceGameRadioButton.setSelected(false);
            SimpleGameRadioButton.setSelected(true);
        }
        else
        {
            AdvanceGameRadioButton.setSelected(true);
            SimpleGameRadioButton.setSelected(false);
        }
        
        if (getLetterColor() == 0)
        {
            RedLettersColorRadioButton.setSelected(false);
            SimpleGameRadioButton.setSelected(true);
        }
        else
        {
            AdvanceGameRadioButton.setSelected(true);
            SimpleGameRadioButton.setSelected(false);
        }
    }


    /** Creates new form NewGameDialog2 */
    public NewGameDialog(java.awt.Frame parent, boolean modal) {
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

        Next = new javax.swing.JButton();
        WelcomeLabel = new javax.swing.JLabel();
        SelectNumOfPlayersLabel = new javax.swing.JLabel();
        SelectGameTypeLabel = new javax.swing.JLabel();
        NumOfPlayersComboBox = new javax.swing.JComboBox();
        AdvanceGameRadioButton = new javax.swing.JRadioButton();
        SimpleGameRadioButton = new javax.swing.JRadioButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BlueLettersColorRadioButton = new javax.swing.JRadioButton();
        RedLettersColorRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Next.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Next.setText("Next >");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        WelcomeLabel.setText("Welcome to Scrabble!");

        SelectNumOfPlayersLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SelectNumOfPlayersLabel.setText("Select Number Of Players:");

        SelectGameTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SelectGameTypeLabel.setText("Select Game Type:");

        NumOfPlayersComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumOfPlayersComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1 player", "2 Players", "3 Players", "4 Players" }));
        NumOfPlayersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOfPlayersComboBoxActionPerformed(evt);
            }
        });

        AdvanceGameRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AdvanceGameRadioButton.setText("Advance Game");
        AdvanceGameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvanceGameRadioButtonActionPerformed(evt);
            }
        });

        SimpleGameRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SimpleGameRadioButton.setSelected(true);
        SimpleGameRadioButton.setText("Simple Game");
        SimpleGameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpleGameRadioButtonActionPerformed(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select Letters Color :");

        BlueLettersColorRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BlueLettersColorRadioButton.setSelected(true);
        BlueLettersColorRadioButton.setText("Blue Letters");
        BlueLettersColorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BlueRadioButtonActionPerformed(evt);
            }
        });

        RedLettersColorRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RedLettersColorRadioButton.setText("Red Letters");
        RedLettersColorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RedRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SelectNumOfPlayersLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(SelectGameTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlueLettersColorRadioButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumOfPlayersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdvanceGameRadioButton))
                        .addGap(7, 7, 7))
                    .addComponent(SimpleGameRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(RedLettersColorRadioButton))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(WelcomeLabel)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectNumOfPlayersLabel)
                    .addComponent(NumOfPlayersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(AdvanceGameRadioButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SelectGameTypeLabel)
                        .addComponent(SimpleGameRadioButton)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BlueLettersColorRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RedLettersColorRadioButton)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdvanceGameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvanceGameRadioButtonActionPerformed
        // TODO add your handling code here:
        if (AdvanceGameRadioButton.isSelected())
            SimpleGameRadioButton.setSelected(false);
        //MainWindow1.setGameType(1);
        setGameType(1);
}//GEN-LAST:event_AdvanceGameRadioButtonActionPerformed

    private void SimpleGameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        if (SimpleGameRadioButton.isSelected())
            AdvanceGameRadioButton.setSelected(false);
        //MainWindow1.setGameType(0);
        setGameType(0);
}                                                     
    
   private void BlueRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpleGameRadioButtonActionPerformed
        // TODO add your handling code here:
        if (BlueLettersColorRadioButton.isSelected())
        	RedLettersColorRadioButton.setSelected(false);
        setLetterColor(0);
}//GEN-LAST:event_SimpleGameRadioButtonActionPerformed
    private void RedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        if (RedLettersColorRadioButton.isSelected())
        	BlueLettersColorRadioButton.setSelected(false);
        setLetterColor(1);
}                                                     


    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        //MainWindow1.initGameParamsToDefault();
        //dispose new game window at the end
        this.dispose();
}//GEN-LAST:event_CancelActionPerformed

    private void NumOfPlayersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumOfPlayersComboBoxActionPerformed
        // TODO add your handling code here:
        //MainWindow1.setNumOfPlayers(NumOfPlayersComboBox.getSelectedIndex() + 1);
        setNumOfPlayers(NumOfPlayersComboBox.getSelectedIndex() + 1);
    }//GEN-LAST:event_NumOfPlayersComboBoxActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PlayersNamesDialog pNDialog = new PlayersNamesDialog(new javax.swing.JFrame(), true);
                //pNDialog.setGameParameters(MainWindow1.getNumOfPlayers());
                pNDialog.setGameParameters(getNumOfPlayers());
                pNDialog.initNames();
                pNDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                //LOGIC
                GameGui.initGameLogic();
                GameGui.setNumberOfPlayers(numOfPlayers);
                GameGui.setGameMode(gameType);
                
                //dispose new game window at the end
                dispose();
                pNDialog.setLocation(100, 100);
                pNDialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_NextActionPerformed


    public static void startNewGame(javax.swing.JFrame parent)
    {
    	NewGameDialog.parent = parent;
    	
        NewGameDialog nGDialog = new NewGameDialog(new javax.swing.JFrame(), true);
        nGDialog.setLocation(100, 100);
        nGDialog.setVisible(true);
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewGameDialog dialog = new NewGameDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });                   
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AdvanceGameRadioButton;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Next;
    private javax.swing.JComboBox NumOfPlayersComboBox;
    private javax.swing.JLabel SelectGameTypeLabel;
    private javax.swing.JLabel SelectNumOfPlayersLabel;
    private javax.swing.JRadioButton SimpleGameRadioButton;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton BlueLettersColorRadioButton;
    private javax.swing.JRadioButton RedLettersColorRadioButton;
    // End of variables declaration//GEN-END:variables

	public static int getGameType() {
		return gameType;
	}
	
	
	public static void setGameType(int gameType) {
		NewGameDialog.gameType = gameType;
	}
	
	public static int getLetterColor(){
		return lettersColor;
	}
	
	public static void setLetterColor(int lettersColor){
		NewGameDialog.lettersColor = lettersColor;
	}


	public static int getNumOfPlayers() {
		return numOfPlayers;
	}


	public static void setNumOfPlayers(int numOfPlayers) {
		NewGameDialog.numOfPlayers = numOfPlayers;
	}
	
	public static void initGameParamsToDefault()
	{
		NewGameDialog.setGameType(0);
		NewGameDialog.setNumOfPlayers(1);
		NewGameDialog.setLetterColor(0);
	}
	
	/* Helper method. disposes the parent screens
	 * */
	public static void initParentScreen()
	{
		parent.dispose();
	}

}
