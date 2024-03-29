/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExitScreen.java
 *
 * Created on 29/03/2009, 22:02:20
 */

package NewGUI;

import java.awt.Component;

/**
 *
 * @author Roy
 */
public class SaveBeforeExitScreen extends javax.swing.JFrame {

    private static javax.swing.JFrame parent;
    private static String nextOp = "";
    /** Creates new form ExitScreen */
    public SaveBeforeExitScreen() {
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

        overwriteText = new javax.swing.JLabel();
        overwriteNoButton = new javax.swing.JButton();
        overwriteYesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        overwriteText.setText("Current game isn't saved. Would you like to save it?");

        overwriteNoButton.setText("No");
        overwriteNoButton.setToolTipText("No, ");
        overwriteNoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overwriteNoButtonActionPerformed(evt);
            }
        });

        overwriteYesButton.setText("Yes");
        overwriteYesButton.setToolTipText("Save current game");
        overwriteYesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overwriteYesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overwriteText, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(overwriteNoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(overwriteYesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(overwriteText)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(overwriteNoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overwriteYesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void overwriteNoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overwriteNoButtonActionPerformed
    	dispose();
    	if (SaveBeforeExitScreen.nextOp.equals("exit"))
    		ExitScreen.startExitScreen(parent);
    	if (SaveBeforeExitScreen.nextOp.equals("new"))
    		NewGameDialog.startNewGame(parent);
    	if (SaveBeforeExitScreen.nextOp.equals("load"))
    		gameFileChooser.startLoadChooser(parent);
}//GEN-LAST:event_overwriteNoButtonActionPerformed

    private void overwriteYesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overwriteYesButtonActionPerformed
    	dispose();
    	gameFileChooser.startSaveChooser(parent);
}

        public static void startSaveBeforeExitScreen(javax.swing.JFrame parent, String opreation)
    {
        SaveBeforeExitScreen.parent = parent;
        SaveBeforeExitScreen.nextOp = opreation;
        SaveBeforeExitScreen exitScreen = new SaveBeforeExitScreen();
        exitScreen.setLocation(100, 100);
        exitScreen.setVisible(true);
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaveBeforeExitScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton overwriteNoButton;
    private javax.swing.JLabel overwriteText;
    private javax.swing.JButton overwriteYesButton;
    // End of variables declaration//GEN-END:variables

}
