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

    public void setCurrentX(int currentX) {

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
    }

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
        if (dx == 0 && dy == 0) { // если не задано направление, то ничего не делаем
            return;
        }
        if (currentX + dx >= 0 && currentX + dx < Field.COLS // проверяем, что коза не выйдет за границы карты
                && currentY + dy >= 0 && currentY + dy < Field.ROWS) {

            if(!(field.getCells(currentX + dx, currentY + dy).getObject() instanceof Barrel)) {   //Если не Barrel{
                if(!(field.getCells(currentX + dx, currentY + dy).getObject() instanceof Fence)){
                    if(field.getCells(currentX + dx, currentY + dy).getObject() instanceof Grass){
                        currentX = currentX + dx; // обновляем координаты козы
                        currentY = currentY + dy;
                        eatCabbageAndGrass(); // коза ест траву
                    } else if (field.getCells(currentX + dx, currentY + dy).getObject() instanceof Cabbage){
                        currentX = currentX + dx; // обновляем координаты козы
                        currentY = currentY + dy;
                        eatCabbageAndGrass(); // коза ест капусту
                    }
                }
            }
        }
    }

    public void eatCabbageAndGrass(){
        //По нажатии кнопки
        field.getCells(currentX, currentY).removeObject();
        cabbageEaten = true;
    }

    public void moveBarrel(int dx, int dy) {
        // получаем ссылку на бочку
        Barrel barrel = field.getCells(currentX + dx, currentY + dy).getObject() instanceof Barrel ?
                (Barrel) field.getCells(currentX + dx, currentY + dy).getObject() : null;
        if (barrel != null) {
            // проверяем, есть ли рядом коза
            Goat goat = (Goat)barrel.checkPosition(dx, dy);
            if (goat != null) {
                // передвигаем бочку в соответствующем направлении
                barrel.move(dx, dy);
            }
        }
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
