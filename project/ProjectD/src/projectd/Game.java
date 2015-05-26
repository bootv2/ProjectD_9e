/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import static javax.swing.JComponent.WHEN_FOCUSED;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author TTT
 */
public class Game {
    
    private static JFrame frame;
    private static Speler speler;
    private static Muur muur;
    private static Insets insets;
    private final static int X = 640;
    private final static int Y = 480;
    public static void main(String[] args)
    {
        
        frame = new JFrame("Doolhof groep 9");
        insets = frame.getInsets();
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        muur = new Muur(insets);
        
        try {
            speler = new Speler("C:\\Users\\TTT\\Downloads\\download.jpg", X, Y, insets);
            muur.setSprite("C:\\Users\\TTT\\Downloads\\download2.jpg");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        muur.setxCoordinate(100);
        muur.setyCoordinate(100);
        
        speler.addOtherItem(muur);
        
        frame.getContentPane().add(speler.getSprite());
        frame.getContentPane().add(muur.getSprite());
        frame.addKeyListener(speler);

        frame.setSize(X + insets.left + insets.right,
                Y + insets.top + insets.bottom);
        frame.setVisible(true);
    }
    
    private static void update()
    {
        
    }
    
    
}
