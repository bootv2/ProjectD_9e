/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
public class Game extends JPanel {

    private static boolean paused = false;
    private JButton pauseButton;
    private JFrame frame;
    private Speler speler;
    private Muur muur;
    private DrawField drawfield;
    private final int SCREEN_WIDTH = 656;
    private final int SCREEN_HEIGHT = 570;
    private Veld[][] aveld = new Veld[20][20];
    ArrayList<ArrayList<Veld>> veld = new ArrayList<ArrayList<Veld>>();

    public void run() {
        //Graphics g;
        frame = new JFrame("Doolhof groep 9");
        //frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        for (int i = 0; i < 20; i++) {
            veld.add(new ArrayList<Veld>());
            for (int x = 0; x < 20; x++) {
                veld.get(i).add(new Veld());
                if (x == 0 || i == 0 || x == 19 || i == 19) {
                    
                    try {
                        muur = new Muur("C:\\Users\\TTT\\Downloads\\download2.jpg");
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                    //speler.addOtherItem(muur);
                    veld.get(i).get(x).setMyItem(muur);
                    veld.get(i).get(x).setxCoord(i * 32);
                    veld.get(i).get(x).setyCoord((x * 24) + 25);

                }
                if (x % 2 == 0 && x % 4 != 0) {
                        if (i != 1) {
                            try {
                                muur = new Muur("C:\\Users\\TTT\\Downloads\\download2.jpg");
                            } catch (IOException ex) {
                                System.out.println(ex.toString());
                            }
                            //speler.addOtherItem(muur);
                            veld.get(i).get(x).setMyItem(muur);
                            veld.get(i).get(x).setxCoord(i * 32);
                            veld.get(i).get(x).setyCoord((x * 24) + 25);
                        }
                    }
                    else if (x%4 == 0)
                    {
                        if (i != 18) {
                            try {
                                muur = new Muur("C:\\Users\\TTT\\Downloads\\download2.jpg");
                            } catch (IOException ex) {
                                System.out.println(ex.toString());
                            }
                            //speler.addOtherItem(muur);
                            veld.get(i).get(x).setMyItem(muur);
                            veld.get(i).get(x).setxCoord(i * 32);
                            veld.get(i).get(x).setyCoord((x * 24) + 25);
                        }
                    }
            }
        }

        try {
            //speler.setOtherItems
            
            pauseButton = new JButton("Pause");
            pauseButton.setLocation(0, 0);
            pauseButton.setBounds(0, 0, 40, 10);
            /*pauseButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
            if(isPaused())
            {
                System.out.println("game unpaused");
                paused = false;
            }
            else paused = true;
            System.out.println("button pressed");
            }
            });
            
            
            
            frame.getContentPane().add(pauseButton, BorderLayout.NORTH);*/
            /*for(ArrayList<Veld> vlist : veld)
            {
            for(Veld v : vlist)
            {
            if(v.getMyItem() != null)
            frame.getContentPane().add(v.getMyItem().getSprite());
            }
            }*/
            speler = new Speler("C:\\Users\\TTT\\Downloads\\download.jpg", SCREEN_WIDTH, SCREEN_HEIGHT - 100, veld.get(5).get(5));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawfield = new DrawField();

        for (int i = 0; i < 20; i++) {
            for (int x = 0; x < 20; x++) {
                if (veld.get(i).get(x).getMyItem() != null) {
                    drawfield.addItem(veld.get(i).get(x).getMyItem());
                    speler.addOtherItem(veld.get(i).get(x).getMyItem());
                }
            }
        }

        frame.getContentPane().add(drawfield, BorderLayout.CENTER);
        System.out.println(drawfield.getSize());

        frame.getContentPane().add(speler.getSprite());
        //frame.getContentPane().add(muur.getSprite());
        frame.addKeyListener(speler);

        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        frame.setVisible(true);
        while (true) {
            frame.repaint();
        }
    }

    private void update() {

    }

    public static boolean isPaused() {
        return paused;
    }

    public static void setPaused(boolean paused) {
        Game.paused = paused;
    }

}
