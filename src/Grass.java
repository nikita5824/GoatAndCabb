import javax.swing.*;
import java.awt.*;

public class Grass extends GameObject{

    private int x, y;
    private final ImageIcon imageGrass;
    private final Image grass;

    private Field field;

    ////////////////////////////////////////////////////////////////
    //

    public Grass(int x, int y, Field field){
        this.x = x;
        this.y = y;
        this.field = field;
        imageGrass = new ImageIcon("pictures/grass.png");
        grass = imageGrass.getImage();

        field.getCells(x, y).addObject(this);
    }

    public Grass(int x, int y, Field field, ImageIcon imageGrass){
        this.x = x;
        this.y = y;

        this.imageGrass = imageGrass;
        grass = imageGrass.getImage();

        field.getCells(x, y).addObject(this);
    }

    //
    /////////////////////////////////////////////////////////////////
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getGrass() {
        return grass;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
    public Grass(ImageIcon imageGrass){
        this.imageGrass = imageGrass;
        grass = imageGrass.getImage();
    }

    //
    /////////////////////////////////////////////////////////////////

    public Image getGrass(){
        return grass;
    }*/
}
