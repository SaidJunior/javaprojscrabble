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
public class OverWriteScreen extends javax.swing.JFrame {

    private static javax.swing.JFrame parent;
    /** Creates new form ExitScreen */
    public OverWriteScreen() {
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

        unSavedText = new javax.swing.JLabel();
        unSavedNo = new javax.swing.JButton();
        unSavedYes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        unSavedText.setText("Current game is not save. Would you like to save it?");

        unSavedNo.setText("No");
        unSavedNo.setToolTipText("Exit the game without saving it");
        unSavedNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unSavedNoActionPerformed(evt);
            }
        });

        unSavedYes.setText("Yes");
        unSavedYes.setToolTipText("Save the game");
        unSavedYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unSavedYesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unSavedText, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(unSavedNo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(unSavedYes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(unSavedText)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unSavedNo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unSavedYes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unSavedNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unSavedNoActionPerformed
       //code to force quit without saving
}//GEN-LAST:event_unSavedNoActionPerformed

    private void unSavedYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unSavedYesActionPerformed

        //code to save the game
}//GEN-LAST:event_unSavedYesActionPerformed

    /* This is the method that will call this class. 
     * */
        public static void startUnSavedScreen(javax.swing.JFrame parent, String fileName)
    {
        OverWriteScreen.parent = parent;
        OverWriteScreen overwriteScreen = new OverWriteScreen();
        overwriteScreen.unSavedText.setText("A game with the name " + fileName + " already exists.\n" +
        		"Would you like to overwrite it?");
        overwriteScreen.setLocation(100, 100);
        overwriteScreen.setVisible(true);
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OverWriteScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton unSavedNo;
    private javax.swing.JLabel unSavedText;
    private javax.swing.JButton unSavedYes;
    // End of variables declaration//GEN-END:variables

}
