/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewGUI;

import java.beans.*;
import java.io.Serializable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Erez Reshef
 */
public class GameBoardCell extends JPanel implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    public static JPanel squarePanel = new JPanel();
    public static JLabel square;

    private PropertyChangeSupport propertySupport;

    public GameBoardCell() {
        propertySupport = new PropertyChangeSupport(this);
        initComponents();
    }

    private static void createSquare()
    {
        squarePanel = new JPanel();
        square = new JLabel ();
        squarePanel.add(square);
        squarePanel.setBorder(BorderFactory.createBevelBorder(1));
//        squarePanel.setBackground(getColor(i, j));
        square.setForeground(new Color(0, 0, 250));
//        squarePanel.setToolTipText("Row" + i + " and Column " + j);
    }

    private void initComponents() {
//        Dimension dim = new Dimension();
        int boardSize = 40;
//        boardSize = 40;
        squarePanel = new JPanel();
        square = new JLabel ();
        squarePanel.add(square);
        squarePanel.setBorder(BorderFactory.createBevelBorder(1));
//        squarePanel.setBackground(getColor(i, j));
        square.setForeground(new Color(0, 0, 250));
//        squarePanel.setToolTipText("Row" + i + " and Column " + j);//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Scrabble Board");
//        setIconImage(new ImageIcon("board.jpg").getImage());
//       getContentPane().add(squaresPanel, BorderLayout.CENTER);
        add(squarePanel, BorderLayout.CENTER);
        setVisible(true);
        Dimension preferredSize = new Dimension();
        preferredSize.width = boardSize;
        preferredSize.height = boardSize;
        setPreferredSize(preferredSize);
//        setBounds(boardSize, boardSize, boardSize, boardSize);

//        pack();
    }

//    public void setToolTipText(String text)
//    {
//        this.setToolTipText(text);
//    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GameBoardCell();
        }
        });
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
