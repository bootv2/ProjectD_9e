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
        getSprite().setLocation(wx / 2, wy / 2);

        sHeight = wy;
        sWidth = wx;

        setxCoordinate(wx/2);
        setyCoordinate(wy / 2);
        setInsets(i);
        getSprite().setBounds(getxCoordinate() + getInsets().left, getyCoordinate() + getInsets().top, width, height);
        this.width = 32;
        this.height = 28;
    }

    private boolean _hasBazooka;
    private int _bazookaAmmo;
    
    public void setOtherItems(ArrayList<Item> otherItems) {
        this.otherItems = otherItems;
    }

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
            getSprite().setLocation(getxCoordinate(), getyCoordinate());
            getSprite().setBounds(getxCoordinate() + getInsets().left, getyCoordinate() + getInsets().top, 32, 28);
        }
        else System.out.println("paused");

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //unused
    }

    private void moveRight() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (getxCoordinate() + width + 10 < sWidth) {
                setxCoordinate(getxCoordinate() + 1);
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    setxCoordinate(getxCoordinate() - 1);
                    colliding = true;
                    break;
                }
            }

        }
        colliding = false;
    }

    private void moveUp() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (getyCoordinate() - 1 > 0) {
                setyCoordinate(getyCoordinate() - 1);
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    setyCoordinate(getyCoordinate() + 1);
                    colliding = true;
                    break;
                }
            }
        }
        colliding = false;
    }

    private void moveLeft() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (getxCoordinate() - 1 > 0) {
                setxCoordinate(getxCoordinate() - 1);
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    setxCoordinate(getxCoordinate() + 1);
                    colliding = true;
                    break;
                }
            }
            colliding = false;
        }
    }

    private void moveDown() {
        for (int x = 0; x < MOVEMENT_SPEED && !colliding; x++) {
            if (getyCoordinate() + height + 33 < sHeight) {
                setyCoordinate(getyCoordinate() + 1);
            }
            for (int i = 0; i < otherItems.size(); i++) {
                if (isColliding(otherItems.get(i))) {
                    setyCoordinate(getyCoordinate() - 1);
                    colliding = true;
                    break;
                }
            }
        }
        colliding = false;
    }
}
