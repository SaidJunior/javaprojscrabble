/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoadGameChooser.java
 *
 * Created on 29/03/2009, 13:40:07
 */

package NewGUI;

import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roy
 */
public class gameFileChooser extends javax.swing.JFrame {

    private static int returnVal;
    private static   FileNameExtensionFilter filter = new FileNameExtensionFilter("Scrabble files","scrabble");
   //load = 0, save = 1
    private static int saveOrLoad = 0;
    
    private static javax.swing.JFrame parent;

    public static int getReturnVal() {
        return returnVal;
    }
    
    public static String getFileName(){
    	return  jFileChooser1.getSelectedFile().getName();
    }

    public static void setReturnVal(int returnVal) {
        gameFileChooser.returnVal = returnVal;
    }
    /** Creates new form LoadGameChooser */
    public gameFileChooser() {
        initComponents();
    }

    public static void startLoadChooser(javax.swing.JFrame parent)
    {
    	gameFileChooser.parent = parent;
    	saveOrLoad = 0;
        startGameChooser("Load an old Scrabble game", "Load a game", javax.swing.JFileChooser.OPEN_DIALOG);
    }

    public static void startSaveChooser()
    {
        saveOrLoad = 1;
         startGameChooser("Save a Scrabble game", "Save game", javax.swing.JFileChooser.SAVE_DIALOG);
    }

    
    private static void startGameChooser(String title, String buttonText, int dialog)
    {
        gameFileChooser saveGameChooser = new gameFileChooser();
        saveGameChooser.setLocation(100,100);
         saveGameChooser.jFileChooser1.setDialogTitle(title);
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Scrabble files","scrabble");
         saveGameChooser.jFileChooser1.addChoosableFileFilter(filter);
          saveGameChooser.jFileChooser1.setDialogType(dialog);

        setReturnVal(saveGameChooser.jFileChooser1.showDialog(saveGameChooser, buttonText));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("close_button_highlight"));

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\"));
            jFileChooser1.setDialogTitle("");
            jFileChooser1.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
            jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jFileChooser1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 582, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 397, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    /* Get File/String param for saving or loading a game.
     * if     saveOrLoad ==0 -> load,  saveOrLoad ==1 --> save
     */
    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed

    	File file = jFileChooser1.getSelectedFile();
    	if (file != null)
    	{
    		String fileName = jFileChooser1.getSelectedFile().getName();

    		if (saveOrLoad == 0)
    		{
    			boolean successLoad = scrabbleMain.GameGui.loadGame(fileName);
    			if (successLoad)
    			{
    				MainWindow1 MainWindow = new MainWindow1();
    				parent.dispose();
    				MainWindow.setVisible(true);
    				MainWindow.initGameWindow();
    			}
    			else
    			{
    				GeneralMessage.stratGeneralMessage(gameFileChooser.this,
    						"Failed to load " + fileName + ".", "Error while loading");
    			}
    		}
    		else if (saveOrLoad == 1)
    		{
    			//save methods
    		}
    	}

    }//GEN-LAST:event_jFileChooser1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameFileChooser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

}
