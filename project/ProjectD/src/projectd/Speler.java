package projectd;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Speler extends Item implements BestuurbaarElement {

    ArrayList<Item> otherItems = new ArrayList<Item>();

    int sHeight;
    int sWidth;

    public Speler(String spritePath, int wx, int wy, Insets i) throws IOException {
        super(i);
        this._hasBazooka = false;
        this._bazookaAmmo = 0;
        setSprite(spritePath);
        sprite.setLocation(wx / 2, wy / 2);

        sHeight = wy;
        sWidth = wx;

        xCoordinate = wx / 2;
        yCoordinate = wy / 2;
        insets = i;
        sprite.setBounds(xCoordinate + insets.left, yCoordinate + insets.top, 54, 38);
        this.width = 54;
        this.height = 38;
    }

    private boolean _hasBazooka;
    private int _bazookaAmmo;

    public void schietBazooka() {
        throw new UnsupportedOperationException();
    }

    public void update() {

    }

    public void addOtherItem(Item i) {
        otherItems.add(i);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //unused
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }
        sprite.setLocation(xCoordinate, yCoordinate);
        sprite.setBounds(xCoordinate + insets.left, yCoordinate + insets.top, 54, 38);

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //unused
    }

    private void moveRight() {
        if (xCoordinate + width + 20 < sWidth) {
            xCoordinate += 10;
        }
        for (int i = 0; i < otherItems.size(); i++) {
            if (isColliding(otherItems.get(i))) {
                xCoordinate -= 10;
                break;
            }
        }
    }

    

    private void moveUp() {
        if (yCoordinate - 10 > 0) {
            yCoordinate -= 10;
        }
         for (int i = 0; i < otherItems.size(); i++) {
            if (isColliding(otherItems.get(i))) {
                yCoordinate += 10;
                break;
            }
        }
    }

    private void moveLeft() {
        if (xCoordinate - 10 > 0) {
            xCoordinate -= 10;
        }
         for (int i = 0; i < otherItems.size(); i++) {
            if (isColliding(otherItems.get(i))) {
                xCoordinate += 10;
                break;
            }
        }
    }

    private void moveDown() {
        if (yCoordinate + height + 43 < sHeight) {
            yCoordinate += 10;
        }
         for (int i = 0; i < otherItems.size(); i++) {
            if (isColliding(otherItems.get(i))) {
                yCoordinate -= 10;
                break;
            }
        }
    }
}
