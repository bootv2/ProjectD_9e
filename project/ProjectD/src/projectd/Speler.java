package projectd;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Speler extends Item implements BestuurbaarElement {

    private final int MOVEMENT_SPEED = 10;
    private ArrayList<Item> otherItems = new ArrayList<Item>();

    private int sHeight;

    private int sWidth;

    private boolean colliding = false;

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
        sprite.setBounds(xCoordinate + insets.left, yCoordinate + insets.top, width, height);
        this.width = 32;
        this.height = 28;
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
        if (!Game.isPaused()) {
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
            sprite.setLocation(xCoordinate, yCoordinate + 100);
            sprite.setBounds(xCoordinate + insets.left, yCoordinate + 100 + insets.top, 32, 28);
        }
        else System.out.println("paused");

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //unused
    }

    private void moveRight() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (xCoordinate + width + 10 < sWidth) {
                xCoordinate += 1;
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    xCoordinate -= 1;
                    colliding = true;
                    break;
                }
            }

        }
        colliding = false;
    }

    private void moveUp() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (yCoordinate - 1 > 0) {
                yCoordinate -= 1;
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    yCoordinate += 1;
                    colliding = true;
                    break;
                }
            }
        }
        colliding = false;
    }

    private void moveLeft() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (xCoordinate - 1 > 0) {
                xCoordinate -= 1;
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    xCoordinate += 1;
                    colliding = true;
                    break;
                }
            }
            colliding = false;
        }
    }

    private void moveDown() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (yCoordinate + height + 33 < sHeight) {
                yCoordinate += 1;
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    yCoordinate -= 1;
                    colliding = true;
                    break;
                }
            }
        }
        colliding = false;
    }
}
