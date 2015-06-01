/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectd;

/**
 *
 * @author TTT
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author TTT
 */
public class DrawField extends JComponent {

    public DrawField() {
        this.setSize(640, 480);
    }
    
    


    private ArrayList<Item> VisibleItems = new ArrayList<Item>();
    
   public void addItem(Item i)
   {
       VisibleItems.add(i);
   }

    @Override
    public void paintComponent(Graphics g) {
        
        for (Item i : VisibleItems) {
            g.setColor(Color.black);
            g.drawRect(i.getxCoordinate(), i.getyCoordinate(), i.getWidth(), i.getHeight());
            
        }

    }
}
