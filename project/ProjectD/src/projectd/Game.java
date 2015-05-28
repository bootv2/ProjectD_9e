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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import static javax.swing.JComponent.WHEN_FOCUSED;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author TTT
 */
public class Game {
    
    private static boolean paused = false;
    private JButton pauseButton;
    private JFrame frame;
    private Speler speler;
    private Muur muur;
    private Insets insets;
    private final int X = 656;
    private final int Y = 570;
    private veld[][] veld = new Veld[20][20]();
    public void run()
    {
        
        frame = new JFrame("Doolhof groep 9");
        insets = frame.getInsets();
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        try {
            speler = new Speler("C:\\Users\\TTT\\Downloads\\download.jpg", X, Y - 100, insets);
            muur = new Muur(insets, "C:\\Users\\TTT\\Downloads\\download2.jpg");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        for(int i = 0; i < 20; i++)
        {
            veld.add(new ArrayList<Veld>());
            for(int x = 0; x < 20; x++)
            {
                veld.get(i).add(new Veld());
                if(x == 0 || i == 0 || x == 19 || i == 19)
                {
                    
                    try {
                        muur = new Muur(insets, "C:\\Users\\TTT\\Downloads\\download2.jpg");
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                    speler.addOtherItem(muur);
                    veld.get(i).get(x).setMyItem(muur);
                    veld.get(i).get(x).setxCoord(i * 32);
                    veld.get(i).get(x).setyCoord((x * 24)-50);
                    
                }
            }
        }
        
        
        
        
        //speler.setOtherItems
        
        muur.setxCoordinate(100);
        muur.setyCoordinate(100);
        
        speler.addOtherItem(muur);
        
        /*pauseButton = new JButton("Pause");
        pauseButton.setLocation(0, 0);
        pauseButton.setBounds(0 + insets.left, 0+insets.top, 40, 10);
        pauseButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(isPaused())
                    paused = false;
                else paused = true;
                System.out.println("button pressed");
            }
        });
        
        
        
        frame.getContentPane().add(pauseButton);*/
        
        for(ArrayList<Veld> vlist : veld)
        {
            for(Veld v : vlist)
            {
                if(v.getMyItem() != null)
                    frame.getContentPane().add(v.getMyItem().getSprite());
            }
        }
        
        frame.getContentPane().add(speler.getSprite());
        frame.getContentPane().add(muur.getSprite());
        frame.addKeyListener(speler);

        frame.setSize(X + insets.left + insets.right,
                Y + insets.top + insets.bottom);
        
        frame.setVisible(true);
    }
    
    private void update()
    {
        
    }
    
    
    public static boolean isPaused() {
        return paused;
    }

    public static void setPaused(boolean paused) {
        Game.paused = paused;
    }
    
    
    
}
