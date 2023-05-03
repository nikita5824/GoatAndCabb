import javax.swing.*;
import java.awt.*;

public class Goat extends GameObject{

    //Текущая позиция
    private int currentX, currentY;
    //Количество сделанных шагов
    public static int countStepsTaken = 0;

    //Проверяет, съедена ли капуста
    private boolean cabbageEaten = false;

    private boolean barrelsCatched = false;

    private final ImageIcon imageGoat;
    private final Image goat;

    private Field field;

    ////////////////////////////////////////////////////////////////////////////////
    //
    public Goat(int currentX, int currentY, Field field){
        this.field = field;
        if (currentX > 0 && currentX < field.getCols() - 1 && currentY > 0 && currentY < field.getRows()) {
            if(field.getCells(currentX, currentY).getObject() != null){
                throw new RuntimeException("Клетка уже занята");
            }
            this.currentX = currentX;
            this.currentY = currentY;
        } else {
            throw new RuntimeException("Указаны несуществующие координаты");
        }
        imageGoat = new ImageIcon("pictures/goat.png");
        goat = imageGoat.getImage();

        field.getCells(currentX, currentY).addObject(this);
    }

    public Goat(int currentX, int currentY, Field field, ImageIcon imageGoat){
        this.field = field;
        if (currentX > 0 && currentX < field.getCols() - 1 && currentY > 0 && currentY < field.getRows()) {
            if(field.getCells(currentX, currentY).getObject() != null){
                throw new RuntimeException("Клетка уже занята");
            }
            this.currentX = currentX;
            this.currentY = currentY;
        } else {
            throw new RuntimeException("Указаны несуществующие координаты");
        }
        this.imageGoat = imageGoat;
        goat = imageGoat.getImage();

        field.getCells(currentX, currentY).addObject(this);
    }

    //
    ///////////////////////////////////////////////////////////////////////////////
    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setPosition(int x, int y){
        if ((currentY > 0 && currentY < field.getRows() - 1 && field.getCells(currentX, currentY).getObject() != null)&&
        (currentY > 0 && currentY < field.getRows() - 1 && field.getCells(currentX, currentY).getObject() != null)){
            this.currentX = x;
            this.currentY = y;
        }else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }
    /*public void setCurrentX(int currentX) {

        if (currentY > 0 && currentY < field.getRows() - 1 && field.getCells(currentX, currentY).getObject() != null)
            this.currentX = currentX;
        else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }

    public void setCurrentY(int currentY) {
        if (currentY > 0 && currentY < field.getRows() - 1 && field.getCells(currentX, currentY).getObject() != null)
            this.currentY = currentY;
        else {
            throw new RuntimeException("Клетка занята или ее не существует");
        }
    }*/

    public boolean isCabbageEaten() {
        return cabbageEaten;
    }

    public Image getGoat() {
        return goat;
    }

    //public void setCabbageEaten() {
    //    this.cabbageEaten = true;
    //}

    public void move(int dx, int dy){
        // Не может двигаться в сторону бочки
        // Не может двигаться в сторону стены
        // Может двигаться в сторону травы
        // Может двигаться в сторону капусты
        // Если

       // int currentX = getX(); // получаем текущие координаты козы
       // int currentY = getY();
        Cell currentCell = field.getCells(currentX, currentY);

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
        currentX = newX;
        currentY = newY;
    }

    public void eatCabbageAndGrass(){
        //По нажатии кнопки
        field.getCells(currentX, currentY).removeObject();
        cabbageEaten = true;
    }

    public void moveBarrel(int dx, int dy, Barrel barrel) {
        // проверяем, можно ли перемещать бочку в заданном направлении
        Cell currentCell = field.getCells(getCurrentX(), getCurrentY());
        Cell nextCell = field.getCells(getCurrentX() + dx, getCurrentY() + dy);
        if (nextCell.getObject() != null) {
            System.out.println("Невозможно переместить бочку в данном направлении");
            return;
        }

        // перемещаем козу
        setPosition(getCurrentX() + dx, getCurrentY() + dy);

        // перемещаем бочку
        barrel.move(dx, dy);


        // устанавливаем бочку на новую клетку
        nextCell.addObject(barrel);
        // очищаем старую клетку
        currentCell.removeObject();
    }


    /*
    public Goat(Cell currentLocation, ImageIcon imageGoat){
        this.currentLocation = currentLocation;

        this.imageGoat = imageGoat;
        goat = imageGoat.getImage();
    }

    //
    /////////////////////////////////////////////////////////////////////////////////

    public void setCurrentLocation(Cell currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Cell getCurrentLocation() {
        return currentLocation;
    }

    public boolean isCabbageEaten() {
        return cabbageEaten;
    }

    public Image getGoat() {
        return goat;
    }*/
}
