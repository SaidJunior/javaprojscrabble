/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mainWindow.java
 *
 * Created on 23/03/2009, 22:41:51
 */

package Gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


/**
 *
 * @author Roy
 */
public class MainWindow1 extends javax.swing.JFrame {

    /** Creates new form mainWindow */
    public MainWindow1() {
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

        saveGameChooser = new javax.swing.JFileChooser();
        loadGameChooser = new javax.swing.JFileChooser();
        bestResultsPage = new javax.swing.JFrame();
        bestResultsData = new javax.swing.JLabel();
        newGameDialog = new javax.swing.JDialog();
        gameTypeCombo = new javax.swing.JComboBox();
        gameTypeText = new javax.swing.JLabel();
        numPlayersText = new javax.swing.JLabel();
        numPlayersCombo = new javax.swing.JComboBox();
        newGameNextbutton = new javax.swing.JButton();
        helpPage = new javax.swing.JFrame();
        helpData = new javax.swing.JLabel();
        addWordToBoard = new javax.swing.JButton();
        currentPlayer = new javax.swing.JLabel();
        letterSack = new javax.swing.JLabel();
        scoreBoard = new javax.swing.JLabel();
        changeLetter = new javax.swing.JButton();
        extraButton1 = new javax.swing.JButton();
        gameBoard = new DrawPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        loadMenuItem = new javax.swing.JMenuItem();
        gameMenuSeparator = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        bestResults = new javax.swing.JMenu();
        bestBasic = new javax.swing.JMenuItem();
        bestAdvanced = new javax.swing.JMenuItem();
        helpMenu1 = new javax.swing.JMenu();
        helpMenuItem1 = new javax.swing.JMenuItem();
        helpMenuSeparator1 = new javax.swing.JSeparator();
        aboutUsMenuItem1 = new javax.swing.JMenuItem();

        saveGameChooser.setDialogTitle("Save Game");
        saveGameChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveGameChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameChooserActionPerformed(evt);
            }
        });

        loadGameChooser.setDialogTitle("Load a Game ");

        bestResultsPage.setTitle("Best Results");
        bestResultsPage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bestResultsPage.setMinimumSize(new java.awt.Dimension(600, 600));

        bestResultsData.setText("jLabel1");

        javax.swing.GroupLayout bestResultsPageLayout = new javax.swing.GroupLayout(bestResultsPage.getContentPane());
        bestResultsPage.getContentPane().setLayout(bestResultsPageLayout);
        bestResultsPageLayout.setHorizontalGroup(
            bestResultsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bestResultsPageLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bestResultsData, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        bestResultsPageLayout.setVerticalGroup(
            bestResultsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bestResultsPageLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(bestResultsData, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        newGameDialog.setTitle("New Game");
        newGameDialog.setMinimumSize(new java.awt.Dimension(400, 200));

        gameTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basic", "Advanced" }));
        gameTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameTypeComboActionPerformed(evt);
            }
        });

        gameTypeText.setText("Choose basic or advanced game:");

        numPlayersText.setText("Choose number of players:");

        numPlayersCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        numPlayersCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayersComboActionPerformed(evt);
            }
        });

        newGameNextbutton.setText("Next");

        javax.swing.GroupLayout newGameDialogLayout = new javax.swing.GroupLayout(newGameDialog.getContentPane());
        newGameDialog.getContentPane().setLayout(newGameDialogLayout);
        newGameDialogLayout.setHorizontalGroup(
            newGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGameDialogLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(newGameNextbutton)
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newGameDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newGameDialogLayout.createSequentialGroup()
                        .addComponent(gameTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newGameDialogLayout.createSequentialGroup()
                        .addComponent(numPlayersText, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numPlayersCombo, 0, 73, Short.MAX_VALUE)))
                .addGap(84, 84, 84))
        );
        newGameDialogLayout.setVerticalGroup(
            newGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGameDialogLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(newGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameTypeText)
                    .addComponent(gameTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(newGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPlayersText)
                    .addComponent(numPlayersCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(newGameNextbutton)
                .addGap(27, 27, 27))
        );

        helpPage.setTitle("Help me...");
        helpPage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        helpPage.setMinimumSize(new java.awt.Dimension(600, 600));

        helpData.setText("load help data from file");

        javax.swing.GroupLayout helpPageLayout = new javax.swing.GroupLayout(helpPage.getContentPane());
        helpPage.getContentPane().setLayout(helpPageLayout);
        helpPageLayout.setHorizontalGroup(
            helpPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPageLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(helpData, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        helpPageLayout.setVerticalGroup(
            helpPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPageLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(helpData, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        addWordToBoard.setText("Add Word");
        addWordToBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordToBoardActionPerformed(evt);
            }
        });

        currentPlayer.setFont(new java.awt.Font("Tahoma", 1, 12));
        currentPlayer.setText("Now Playing: _______");
        
        letterSack.setIcon(new javax.swing.ImageIcon(getClass().getResource("GuiResources/letterSackThumb.jpg"))); // NOI18N
        letterSack.setText("Total Letters Left...");
        letterSack.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Letter Sack", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        scoreBoard.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Score Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        changeLetter.setText("Change Letter");
        changeLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLetterActionPerformed(evt);
            }
        });

        extraButton1.setText("Extra Button1");
        extraButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraButton1ActionPerformed(evt);
            }
        });


        jMenuBar1.setBackground(new java.awt.Color(153, 153, 255));

        gameMenu.setBackground(new java.awt.Color(153, 153, 255));
        gameMenu.setText("Game");
        gameMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameMenuKeyPressed(evt);
            }
        });

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setText("New Game");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        newGameMenuItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newGameMenuItemKeyPressed(evt);
            }
        });
        gameMenu.add(newGameMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMenuItemMouseClicked(evt);
            }
        });
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        saveMenuItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveMenuItemKeyPressed(evt);
            }
        });
        gameMenu.add(saveMenuItem);

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadMenuItem.setText("Load");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        loadMenuItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loadMenuItemKeyPressed(evt);
            }
        });
        gameMenu.add(loadMenuItem);
        gameMenu.add(gameMenuSeparator);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        exitMenuItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exitMenuItemKeyPressed(evt);
            }
        });
        gameMenu.add(exitMenuItem);

        jMenuBar1.add(gameMenu);

        viewMenu.setBackground(new java.awt.Color(153, 153, 255));
        viewMenu.setText("View");
        jMenuBar1.add(viewMenu);
        viewMenu.getAccessibleContext().setAccessibleParent(viewMenu);

        bestResults.setBackground(new java.awt.Color(153, 153, 255));
        bestResults.setText("Hall Of Fame");

        bestBasic.setText("Best Results - Basic Game");
        bestBasic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestBasicActionPerformed(evt);
            }
        });
        bestResults.add(bestBasic);

        bestAdvanced.setText("Best Results - Advanced Game");
        bestAdvanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestAdvancedActionPerformed(evt);
            }
        });
        bestResults.add(bestAdvanced);

        jMenuBar1.add(bestResults);

        helpMenu1.setBackground(new java.awt.Color(153, 153, 255));
        helpMenu1.setText("Help");

        helpMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        helpMenuItem1.setText("Help");
        helpMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItem1ActionPerformed(evt);
            }
        });
        helpMenuItem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                helpMenuItem1KeyPressed(evt);
            }
        });
        helpMenu1.add(helpMenuItem1);
        helpMenu1.add(helpMenuSeparator1);

        aboutUsMenuItem1.setText("About Us");
        helpMenu1.add(aboutUsMenuItem1);

        jMenuBar1.add(helpMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scoreBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(letterSack, javax.swing.GroupLayout.PREFERRED_SIZE, 147, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(addWordToBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(extraButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(scoreBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeLetter, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(currentPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(letterSack, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(extraButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addWordToBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMenuItemMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_saveMenuItemMouseClicked

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
       loadGameChooser.showOpenDialog(MainWindow1.this);
}//GEN-LAST:event_loadMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        saveGameChooser.showSaveDialog(MainWindow1.this);
}//GEN-LAST:event_saveMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
       scoreBoard.setText("Exit game from menu");
}//GEN-LAST:event_exitMenuItemActionPerformed

    private void extraButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraButton1ActionPerformed
        scoreBoard.setText("extra button");
    }//GEN-LAST:event_extraButton1ActionPerformed

    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed
        newGameDialog.show();
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    private void gameMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameMenuKeyPressed

    private void newGameMenuItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newGameMenuItemKeyPressed
        newGameDialog.show();
    }//GEN-LAST:event_newGameMenuItemKeyPressed

    private void saveMenuItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveMenuItemKeyPressed
       saveGameChooser.showSaveDialog(MainWindow1.this);
    }//GEN-LAST:event_saveMenuItemKeyPressed

    private void loadMenuItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loadMenuItemKeyPressed
     loadGameChooser.showOpenDialog(MainWindow1.this);
    }//GEN-LAST:event_loadMenuItemKeyPressed

    private void exitMenuItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitMenuItemKeyPressed
         scoreBoard.setText("Exit game from key");
    }//GEN-LAST:event_exitMenuItemKeyPressed

    private void changeLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLetterActionPerformed
        //change letter button
        scoreBoard.setText("Change letter");
    }//GEN-LAST:event_changeLetterActionPerformed

    private void addWordToBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWordToBoardActionPerformed
       //Add Word button
        scoreBoard.setText("Add Word");
    }//GEN-LAST:event_addWordToBoardActionPerformed

    private void helpMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItem1ActionPerformed
     helpPage.show();
    }//GEN-LAST:event_helpMenuItem1ActionPerformed

    private void helpMenuItem1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_helpMenuItem1KeyPressed
        helpPage.show();
    }//GEN-LAST:event_helpMenuItem1KeyPressed

    private void saveGameChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameChooserActionPerformed
        //save a game
          scoreBoard.setText("Save Game");
    }//GEN-LAST:event_saveGameChooserActionPerformed

    private void bestBasicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestBasicActionPerformed
        bestResultsPage.setTitle("BestReults- Basic Game");
        bestResultsPage.show();
         bestResultsData.setText("set results here\nBest Results-basic");
    }//GEN-LAST:event_bestBasicActionPerformed

    private void bestAdvancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestAdvancedActionPerformed
       bestResultsPage.setTitle("BestReults- Advanced Game");
        bestResultsPage.show();
       bestResultsData.setText("set results here\nBest Results-advanced");
    }//GEN-LAST:event_bestAdvancedActionPerformed

    private void gameTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameTypeComboActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_gameTypeComboActionPerformed

    private void numPlayersComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayersComboActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_numPlayersComboActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutUsMenuItem1;
    private javax.swing.JButton addWordToBoard;
    private javax.swing.JMenuItem bestAdvanced;
    private javax.swing.JMenuItem bestBasic;
    private javax.swing.JMenu bestResults;
    private javax.swing.JLabel bestResultsData;
    private javax.swing.JFrame bestResultsPage;
    private javax.swing.JButton changeLetter;
    private javax.swing.JLabel currentPlayer;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton extraButton1;
    private JPanel gameBoard;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JSeparator gameMenuSeparator;
    private javax.swing.JComboBox gameTypeCombo;
    private javax.swing.JLabel gameTypeText;
    private javax.swing.JLabel helpData;
    private javax.swing.JMenu helpMenu1;
    private javax.swing.JMenuItem helpMenuItem1;
    private javax.swing.JSeparator helpMenuSeparator1;
    private javax.swing.JFrame helpPage;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel letterSack;
    private javax.swing.JFileChooser loadGameChooser;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JDialog newGameDialog;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JButton newGameNextbutton;
    private javax.swing.JComboBox numPlayersCombo;
    private javax.swing.JLabel numPlayersText;
    private javax.swing.JFileChooser saveGameChooser;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel scoreBoard;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
 public class DrawPanel extends JPanel{
    	
    	public BufferedImage letters[];
    	public BufferedImage exchangeLetters;
    	int letterCoordsX[] = new int[7];
    	int letterId[] =new int[7];
    	public  int letterMovedcoord = 80;
    	public int [][] usedLettersId = new int[7][3];
        public int []usedLetters = new int[7];
    	
    	public DrawPanel(){
    		loadLetters();
    	}
    	
    	public void drawTable(Graphics g){
    		for(int i=0; i<15; i++){
    			for(int j=0; j<15; j++){
    				g.drawRect(j*28, i*28, 28, 28);
    			}
    		}
    	}
    	public void drawExchangePlace(Graphics g){
    		String path = "resources/Letters/Exchange.jpg";
			Image img = Toolkit.getDefaultToolkit().getImage(path);
			exchangeLetters = resize(toBufferedImage(img),90,90);
			drawImage(exchangeLetters, g,380 , 425);
    		
    	}
    	
    	public void drawLetterSet(Graphics g){
    		for (int i = 0; i < 7; i++){
    			g.drawRect(i*40+80, 440, 28, 28);
    			letterCoordsX[i] = i*40+80;
    		}
    	}
    	  public int letterListener(java.awt.event.MouseEvent evt) {
    	    	Point point = evt.getPoint();
    	    	int x = point.x;
    	    	int y = point.y;
    	    	if(y>420 && x<360){
    	    		return x;
    	    	}
    	    	else {
    	    		if(y>0 && y<420 && x>0 && x<420){
    	    			return 500;
    	    		}
    	    		return 1000;
    	    	}
    	    }
    	    
    	    private void addLetterToBoard(int x, int y){
    	    	int i= (letterMovedcoord-80)/40;
    	    	BufferedImage letterImage = letters[letterId[i]];
    	    	usedLettersId[i][0] = letterId[i];
    	    	usedLettersId[i][1] = x/28;
    	    	usedLettersId[i][2] = y/28;
    	    	if(usedLetters[i]==0){
    	    	usedLetters[i]=1;
    	    	drawImage(letterImage,this.getGraphics(), ((x/28)*28), ((y/28)*28));
    	    	drawImage(letters[26],this.getGraphics(), letterCoordsX[i],440);
    	    	}
    	     	
    	    }
    	 /*
    	  * This function returns the players actions on his turn 
    	  * The function returns a 2D int [7][3] 
    	  * if the player changed letters then on the place [6][0] will be written 500
    	  * and the letters id that have been changed will be written on [0][0],[1][0],[2][0]
    	  * if the player put letters on the table the result is going to be that on the places [i][0] will be the id letter
    	  * on [i][1] the x coordinate and on [i][2] the y coordinate
    	  */   
    	    public int [][] ResultPerTurn(){
    	    	return usedLettersId;	
    	    }
    	
    	public void paintComponent(Graphics g1) {
    		super.paintComponent(g1); // JPanel draws background
    		drawTable(g1);
    		drawLetterSet(g1);
    		placeRandomLetters(g1);
    		drawExchangePlace(g1);
    		this.addMouseListener(new java.awt.event.MouseAdapter(){
        	  public void mouseClicked(java.awt.event.MouseEvent evt) {
                  int i =letterListener(evt);
                  if(i<500){
                	  letterMovedcoord = i;
                  }
                  else {
                	 if(i==500){
                		 addLetterToBoard(evt.getPoint().x,evt.getPoint().y);
                	 }
                  }
              }
        });
    	

    	}
    	
    	public void drawImage(BufferedImage b, Graphics g, int x, int y){
    		Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(b, null, x, y);

    	}
  
    	
    	public void placeRandomLetters(Graphics g){
    		Random generator = new Random();
    		for (int i = 0; i < 7; i++){
    			int r = generator.nextInt(26);
    			letterId[i] = r;
    			drawImage(letters[r], g, letterCoordsX[i], 440);
    		}
    	}
    	
    	public void loadLetters(){
    		letters = new BufferedImage[27];
    		
    		for (int i = 1; i <= 27; i++){
    			String path = "resources/Letters/"+i+".jpg";
    			Image img = Toolkit.getDefaultToolkit().getImage(path);
    			letters[i-1] = resize(toBufferedImage(img),28,28);
    		}
    	}
    	
    	private BufferedImage resize(BufferedImage image, int width, int height) {
    		BufferedImage resizedImage = new BufferedImage(width, height,
    		BufferedImage.TYPE_INT_ARGB);
    		Graphics2D g = resizedImage.createGraphics();
    		g.drawImage(image, 0, 0, width, height, null);
    		g.dispose();
    		return resizedImage;
    		} 
    	
    	// This method returns true if the specified image has transparent
		// pixels
        public boolean hasAlpha(Image image) {
            // If buffered image, the color model is readily available
            if (image instanceof BufferedImage) {
                BufferedImage bimage = (BufferedImage)image;
                return bimage.getColorModel().hasAlpha();
            }
        
            // Use a pixel grabber to retrieve the image's color model;
            // grabbing a single pixel is usually sufficient
             PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
            try {
                pg.grabPixels();
            } catch (InterruptedException e) {
            }
        
            // Get the image's color model
            ColorModel cm = pg.getColorModel();
            return cm.hasAlpha();
        }

    	
    	 public BufferedImage toBufferedImage(Image image) {
    	        if (image instanceof BufferedImage) {
    	            return (BufferedImage)image;
    	        }
    	    
    	        // This code ensures that all the pixels in the image are loaded
    	        image = new ImageIcon(image).getImage();
    	    
    	        // Determine if the image has transparent pixels; for this
				// method's
    	        // implementation, see e661 Determining If an Image Has
				// Transparent Pixels
    	        boolean hasAlpha = hasAlpha(image);
    	    
    	        // Create a buffered image with a format that's compatible with
				// the screen
    	        BufferedImage bimage = null;
    	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	        try {
    	            // Determine the type of transparency of the new buffered
					// image
    	            int transparency = Transparency.OPAQUE;
    	            if (hasAlpha) {
    	                transparency = Transparency.BITMASK;
    	            }
    	    
    	            // Create the buffered image
    	            GraphicsDevice gs = ge.getDefaultScreenDevice();
    	            GraphicsConfiguration gc = gs.getDefaultConfiguration();
    	            bimage = gc.createCompatibleImage(
    	                image.getWidth(null), image.getHeight(null), transparency);
    	        } catch (HeadlessException e) {
    	            // The system does not have a screen
    	        }
    	    
    	        if (bimage == null) {
    	            // Create a buffered image using the default color model
    	            int type = BufferedImage.TYPE_INT_RGB;
    	            if (hasAlpha) {
    	                type = BufferedImage.TYPE_INT_ARGB;
    	            }
    	            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    	        }
    	    
    	        // Copy image to buffered image
    	        Graphics g = bimage.createGraphics();
    	    
    	        // Paint the image onto the buffered image
    	        g.drawImage(image, 0, 0, null);
    	        g.dispose();
    	    
    	        return bimage;
    	    }

    }

}
