package projectd;

import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item {


    private int xCoordinate;
    private int yCoordinate;
    protected int width;
    protected int height;
    private JLabel sprite = null;
    private BufferedImage myPicture = null;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int _xCoordinate) {//verplaatsen naar view
        this.xCoordinate = _xCoordinate;
        sprite.setLocation(xCoordinate, yCoordinate + 100);
        sprite.setBounds(xCoordinate, yCoordinate + 100, width, height);
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int _yCoordinate) {
        this.yCoordinate = _yCoordinate;
        sprite.setLocation(xCoordinate, yCoordinate + 100);
        sprite.setBounds(xCoordinate, yCoordinate + 100, width, height);
    }

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(String path) throws IOException {
        myPicture = ImageIO.read(new File(path));
        sprite = new JLabel(new ImageIcon(myPicture));
    }

    public boolean isColliding(Item i) {//Doordat we werken met velden en zonder soepele bewegingen
        //this collider
        int r1 = (int) (getxCoordinate() + width);
        int l1 = (int) (getxCoordinate());
        int t1 = (int) (getyCoordinate() + width);
        int b1 = (int) (getyCoordinate());

        //the other collider
        int r2 = (int) (i.getxCoordinate() + i.getWidth());
        int l2 = (int) (i.getxCoordinate());
        int t2 = (int) (i.getyCoordinate() + i.getHeight());
        int b2 = (int) (i.getyCoordinate());

        if (r1 < l2 || l1 > r2 || t1 < b2 || b1 > t2) {
            return false;
        } else {
            return true;
        }

    }

}
