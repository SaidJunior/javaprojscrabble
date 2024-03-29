/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * test.java
 *
 * Created on 29/03/2009, 22:11:57
 */

package NewGUI;

import java.io.IOException;
import java.awt.Color;
/**
 *
 * @author Roy
 */
public class StartWindow extends javax.swing.JFrame {

    /** Creates new form test */
    public StartWindow() {
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

    	setBackground(Color.BLACK);
    	setLocation(100, 100);
    	setTitle("Start a new Scrabble game");
        try {
			setIconImage(generalImages.getLogo());
		} catch (IOException e) {}
		
        exitButton = new javax.swing.JButton();
        loadGameButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        scrabbleImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        //exitButton.setBackground(new java.awt.Color(255, 51, 51));
        exitButton.setFont(new java.awt.Font("Bauhaus 93", 1, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setToolTipText("Quit the game");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        //loadGameButton.setBackground(new java.awt.Color(255, 255, 153));
        loadGameButton.setFont(new java.awt.Font("Bauhaus 93", 1, 18)); // NOI18N
        loadGameButton.setText("Load Game");
        loadGameButton.setToolTipText("Load an old Scrabble game");
        loadGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameButtonActionPerformed(evt);
            }
        });

        //newGameButton.setBackground(new java.awt.Color(153, 255, 153));
        newGameButton.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        newGameButton.setText("New Game");
        newGameButton.setToolTipText("Start a new Scrabble game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Informal Roman", 1, 30));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome to SCRAMBBLE!");
        
        scrabbleImage.setIcon(generalImages.getStartImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(scrabbleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(loadGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scrabbleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(loadGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(exitButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        ExitScreen.startExitScreen(StartWindow.this);
       ;
}//GEN-LAST:event_exitButtonActionPerformed

    private void loadGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameButtonActionPerformed
        gameFileChooser.startLoadChooser(StartWindow.this);
}//GEN-LAST:event_loadGameButtonActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
    	NewGameDialog.startNewGame(StartWindow.this);    
}//GEN-LAST:event_newGameButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ExitScreen.startExitScreen(StartWindow.this);
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
     public static void guiMain() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel scrabbleImage;
    private javax.swing.JButton loadGameButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables

}
