import javax.swing.*;
import java.awt.*;


public class Barrel extends GameObject{

    //
    private Field field;
    private Goat goat;
    private int x, y;

    private final ImageIcon imageBarrel;

    private final Image barrel;

    /////////////////////////////////////////////////////////////////////////////
    //Конструктор

    public Barrel(Field field){
        this.field = field;

        /*int randX, randY;
        do{
            randX = (int) (Math.random() * field.getCols());
            randY = (int) (Math.random() * field.getRows());
        } while (field.getCells(randX, randY).getObject() != null);

        this.x = randX;
        this.y = randY;*/
        imageBarrel = new ImageIcon("pictures/barrel.bin");
        barrel = imageBarrel.getImage();

    }

    public Barrel(Field field, ImageIcon imageBarrel){
        this.field = field;

        /*int randX, randY;
        do{
            randX = (int) (Math.random() * field.getCols());
            randY = (int) (Math.random() * field.getRows());
        } while (field.getCells(randX, randY).getObject() != null);

        this.x = randX;
        this.y = randY;*/

        this.imageBarrel = imageBarrel;
        barrel = imageBarrel.getImage();
    }

    public Barrel(int x, int y, Field field){
        this.field = field;

        if (x > 0 && x < field.getCols() - 1 && y > 0 && y < field.getRows()) {
            if(field.getCells(x, y).getObject() != null){
                throw new RuntimeException("Клетка уже занята");
            }
            this.x = x;
            this.y = y;
        } else {
            throw new RuntimeException("Указаны несуществующие координаты");
        }

        //Обязательно тут указывать координаты cells

        imageBarrel = new ImageIcon("pictures/barrel.bin");
        barrel = imageBarrel.getImage();

        field.getCells(x, y).addObject(this);
    }

    public Barrel(int x, int y, Field field, ImageIcon imageBarrel){
        this.field = field;

        if (x < 0 && x > field.getCols() - 1 && y < 0 && y > field.getRows()) {
            this.x = x;
            this.y = y;
        } else {
            throw new RuntimeException("Указаны несуществующие координаты");
        }

        //Обязательно тут указывать координаты cells

        this.imageBarrel = imageBarrel;
        barrel = imageBarrel.getImage();

        field.getCells(x, y).addObject(this);
    }

    /*public void setX(int x) {
        if (x > 0 && x < field.getCols() - 1 && field.getCells(x, y).getObject() != null)
            this.x = x;
        else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }

    public void setY(int y) {
        if (y > 0 && y < field.getRows() - 1 && field.getCells(x, y).getObject() != null)
            this.y = y;
        else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }*/

    public void setPosition(int x, int y){
        if ((x > 0 && x < field.getCols() - 1 && field.getCells(x, y).getObject() != null) &&
                (y > 0 && y < field.getRows() - 1 && field.getCells(x, y).getObject() != null)) {
            this.x = x;
            this.y = y;
        } else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }


    public Image getImgBarrel() {
        return barrel;
    }

    //Получаем на вход координаты dx, dy и поле field
    //Определяем новые координаты
    //Если в той клетке содержится объект, то возвращаем объект
    //Если нет, то возвращаем null, клетка свободна
    public GameObject checkPosition(int dx, int dy){

        int newX = this.x + dx;
        int newY = this.y + dy;

        Cell newCell = field.getCells(newX, newY);

        if (newCell.hasObject()) {
            return newCell.getObject();
        }

        return null;
    }

    public void move(int dx, int dy){
        Cell currentCell = field.getCells(x, y);

        int newX = currentCell.getX() + dx;
        int newY = currentCell.getY() + dy;

        if (newX < 0 || newX >= field.getRows() || newY < 0 || newY >= field.getCols()) {
            throw new RuntimeException("Передвижение невозможно - выход за пределы поля");
        }

        // получаем объект, который находится в новой клетке
        GameObject objectInNewCell = field.getCells(newX, newY).getObject();

        // проверяем, что новая клетка свободна
        if (objectInNewCell != null) {
            throw new RuntimeException("Передвижение невозможно - на пути находится объект " + objectInNewCell.getClass().getSimpleName());
        }

        // перемещаем объект на новую клетку
        currentCell.removeObject();
        field.getCells(newX, newY).addObject(this);
        x = newX;
        y = newY;
    }

}
