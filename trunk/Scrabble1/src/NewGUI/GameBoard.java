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
public class GameBoard  extends JPanel implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    private PropertyChangeSupport propertySupport;

    public static final int NUMBER_OF_ROWS = 15;
    public static final int NUMBER_OF_FILES = 15;
    public static JLabel square;
    public static JPanel squarePanel = new JPanel();
    public static JPanel squaresPanel = new JPanel();

    private static void createSquares()
    {
        LayoutManager layout = new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_FILES);
        squaresPanel.setLayout(layout);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        d.height /= 1.3;
        d.width /= 2;
        squaresPanel.setPreferredSize(d);
        for(int i=NUMBER_OF_ROWS; i>0; i--) {
            for(int j=1; j<=NUMBER_OF_FILES; j++) {
                squarePanel = new JPanel();
                square = new JLabel ();
                squarePanel.add(square);
                squarePanel.setBorder(BorderFactory.createBevelBorder(1));
                squarePanel.setBackground(getColor(i, j));
                square.setForeground(new Color(0, 0, 250));
                squarePanel.setToolTipText("Row" + i + " and Column " + j);
                squaresPanel.add(squarePanel);
            }
        }
    }

    private static Color getColor(int x, int y)
    {
        if((x+y) % 2 == 0)
            return new Color(236,233,216);
        else
            return new Color(236, 233, 216);
    }

    public GameBoard() {
        propertySupport = new PropertyChangeSupport(this);
        initComponents();
    }

    private void initComponents() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int boardSize = 0;
        int width = dim.width;
        int height = dim.height;
        if(width >= height)
        {
            boardSize = 2* height / 3;
        }
        else
        {
            boardSize = 2* width / 3;
        }
        createSquares();
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Scrabble Board");
//        setIconImage(new ImageIcon("board.jpg").getImage());
//       getContentPane().add(squaresPanel, BorderLayout.CENTER);
        add(squaresPanel, BorderLayout.CENTER);
        setVisible(true);
        Dimension preferredSize = new Dimension();
        preferredSize.width = boardSize;
        preferredSize.height = boardSize;
        setPreferredSize(preferredSize);
//        setBounds(boardSize, boardSize, boardSize, boardSize);
        
//        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GameBoard();
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
