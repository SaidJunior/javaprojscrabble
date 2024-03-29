/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BeneralDialog.java
 *
 * Created on 31/03/2009, 09:43:27
 */

package NewGUI;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *
 * @author Roy
 */
public class GeneralMessage extends javax.swing.JDialog {

    /** Creates new form BeneralDialog */
    public GeneralMessage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public static void stratGeneralMessage(Component parent, String message, String title)
    {
      JOptionPane.showMessageDialog(parent, message, title, 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generalMessage1 = new javax.swing.JOptionPane();

        try {
			setIconImage(generalImages.getLogo());
		} catch (IOException e) {}
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        generalMessage1.setMessageType(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GeneralMessage dialog = new GeneralMessage(new javax.swing.JFrame(), true);
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
    private javax.swing.JOptionPane generalMessage1;
    // End of variables declaration//GEN-END:variables

}
