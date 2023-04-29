import javax.swing.*;
import java.awt.*;

public class Fence extends GameObject{

    private int x, y;
    private final ImageIcon imageFence;
    private final Image fence;

    private Field field;

    /////////////////////////////////////////////////////////////////////
    //Конструкторы

    public Fence(int x, int y, Field field){
        this.x = x;
        this.y = y;

        this.field = field;
        imageFence = new ImageIcon("pictures/fence.png");
        fence = imageFence.getImage();

        field.getCells(x, y).addObject(this);
    }

    public Fence(int x, int y, Field field, ImageIcon imageFence){
        this.x = x;
        this.y = y;
        this.field = field;

        this.imageFence = imageFence;
        fence = imageFence.getImage();

        field.getCells(x, y).addObject(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getFence() {
        return fence;
    }

    /*
    public Fence(ImageIcon imageFence){
        this.imageFence = imageFence;
        fence = imageFence.getImage();
    }

    //
    //////////////////////////////////////////////////////////////////////

    public Image getFence() {
        return fence;
    }*/
}
