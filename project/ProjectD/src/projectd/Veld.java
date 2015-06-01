package projectd;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Veld {
    private JLabel _sprite;
    private Item myItem;
    private int xCoord;
    private int yCoord;
    private static final int width = 32;
    private static final int height = 28;
    
    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
        if(myItem != null) myItem.setxCoordinate(xCoord);
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
        if(myItem != null)  myItem.setyCoordinate(yCoord);
    }

    public JLabel getSprite() {
        return _sprite;
    }

    public void setSprite(String path) {
        //this._sprite = _sprite;
    }

    public Item getMyItem() {
        return myItem;
    }

    public void setMyItem(Item myItem) {
        this.myItem = myItem;
    }
}
