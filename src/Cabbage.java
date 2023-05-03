import javax.swing.*;
import java.awt.*;

public class Cabbage extends GameObject{

    private int x, y;

    private Field field;
    private final ImageIcon imageCabbage;
    private final Image cabbage;



    //////////////////////////////////////////////////////////////////////////
    //
    public Cabbage(Field field) {
        this.field = field;
        /*int randX, randY;
        do{
            randX = (int) (Math.random() * field.getCols());
            randY = (int) (Math.random() * field.getRows());
        } while (field.getCells(randX, randY).getObject() != null);

        this.x = randX;
        this.y = randY;*/

        imageCabbage = new ImageIcon("pictures/cabbage.png");
        cabbage = imageCabbage.getImage();

        field.getCells(x, y).addObject(this);
    }
    public Cabbage(int x, int y, Field field) {
        this.x = x;
        this.y = y;
        this.field = field;
        imageCabbage = new ImageIcon("pictures/cabbage.png");
        cabbage = imageCabbage.getImage();

        field.getCells(x, y).addObject(this);
    }
    public Cabbage(Field field, ImageIcon imageCabbage) {
        this.field = field;
        /*int randX, randY;
        do{
            randX = (int) (Math.random() * field.getCols());
            randY = (int) (Math.random() * field.getRows());
        } while (field.getCells(randX, randY).getObject() != null);

        this.x = randX;
        this.y = randY;*/
        this.imageCabbage = imageCabbage;
        cabbage = imageCabbage.getImage();

        field.getCells(x, y).addObject(this);
    }

    public Cabbage(int x, int y, Field field, ImageIcon imageCabbage) {
        this.x = x;
        this.y = y;
        this.field = field;
        this.imageCabbage = imageCabbage;
        cabbage = imageCabbage.getImage();

        field.getCells(x, y).addObject(this);
    }
    //
    /////////////////////////////////////////////////////////////////////////
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y){
        if ((x < 0 && x > field.getCols() - 1 && field.getCells(x, y).getObject() != null) &&
                (y < 0 && y > field.getRows() - 1 && field.getCells(x, y).getObject() != null)) {
            this.x = x;
            this.y = y;
        } else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }

    public Image getCabbage() {
        return cabbage;
    }



}
