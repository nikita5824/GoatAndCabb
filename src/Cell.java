import javax.swing.*;
import java.awt.*;

public class Cell {

    //Координаты
    private final int x, y;


    private GameObject object = null;

    private Goat goat;

    private Cabbage cabbage;

    private Barrel barrel;

    private Fence fence;

    private Grass grass;

    //Иконка
    private final ImageIcon imageGrave;
    private final Image grave;

    ////////////////////////////////////////////////////////////////////
    //Конструкторы

    //Надо передавать либо объект, либо null
    public Cell(int x, int y){
        this.x = x;
        this.y = y;

        //Иконка
        imageGrave = new ImageIcon("pictures/grave.png");
        grave = imageGrave.getImage();
    }

    public Cell(int x, int y, ImageIcon imageGrave){
        this.x = x;
        this.y = y;

        //Иконка
        this.imageGrave = imageGrave;
        grave = imageGrave.getImage();
    }

    public boolean isEmpty(){
        return true;
    }
    //
    ///////////////////////////////////////////////////////////////////////

    /*public void addObject(int x, int y, GameObject object) {
        if (this.object == null) {
            this.object = object;
            object.setPosition(x, y);
        } else {
            throw new RuntimeException("В клетке уже имеется объект");
        }
    }

    public void interactWithObject(GameObject object) {
        if (this.object == null) {
            throw new RuntimeException("В клетке нет объекта");
        } else if (this.object instanceof Grass || this.object instanceof Cabbage) {
            goat.eatCabbageAndGrass();
        }
    }*/
    public void addObject(int x, int y, GameObject object){
        if(this.object == null) {
            this.object = object;

            if(object instanceof Barrel) {
                barrel = (Barrel) object;
                barrel.setPosition(x, y);
            }

            if(object instanceof Goat) {
                goat = (Goat) object;
                goat.setPosition(x, y);
            }

            if(object instanceof Cabbage){
                cabbage = (Cabbage) object;
                cabbage.setPosition(x, y);
            }

            if(object instanceof Grass){
                grass = (Grass) object;
                grass.setPosition(x, y);
            }

            if(object instanceof Fence){
                fence = (Fence) object;
                fence.setPosition(x, y);
            }
        } else if (this.getObject() instanceof Grass || this.getObject() instanceof Cabbage){
            goat.eatCabbageAndGrass();
        } else
            throw new RuntimeException("В клетке уже имеется объект");

    }
    public void addObject(GameObject object){
        if(this.object == null) {
            this.object = object;

            if(object instanceof Barrel)
                barrel = (Barrel) object;

            if(object instanceof Goat)
                goat = (Goat) object;

            if(object instanceof Cabbage)
                cabbage = (Cabbage) object;

            if(object instanceof Grass)
                grass = (Grass) object;

            if(object instanceof Fence)
                fence = (Fence) object;
        }


        else if (this.getObject() instanceof Grass || this.getObject() instanceof Cabbage){
            goat.eatCabbageAndGrass();
        } else
            throw new RuntimeException("В клетке уже имеется объект");
    }

    public Goat getGoat() {
        return goat;
    }

    public Cabbage getCabbage() {
        return cabbage;
    }

    public Barrel getBarrel() {
        return barrel;
    }

    public Fence getFence() {
        return fence;
    }

    public Grass getGrass() {
        return grass;
    }

    public void removeObject(){
        if(this.object != null)
            this.object = null;
        else
            throw new RuntimeException("В клетке нет объекта");
    }

    //С этим классом использовать приведение типа
    //Если нет объекта, возвращается null
    public GameObject getObject(){
        return object;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImgGrave() {
        return grave;
    }

    public boolean hasObject() {
        return (object != null);
    }
    /*
    //То же самое, но в конструктор передается картинка
    public Cell(int x, int y, ImageIcon imageGrave){
        this.x = x;
        this.y = y;

        this.imageGrave = imageGrave;
        grave = imageGrave.getImage();
    }

    //
    //////////////////////////////////////////////////////////////////////

    //Проверить, есть ли коза в клетке
    public boolean isHasGoat() {

        if (hasGoat != null){
            return true;
        }

        return false;
    }

    //Проверить, есть ли в клетке капуста
    public boolean isHasCabbage() {
        if (hasGoat != null){
            return true;
        }

        return false;
    }

    //Проверить, есть ли в клетке бочка
    public boolean isHasBarrel() {
        if (hasBarrel != null){
            return true;
        }

        return false;
    }

    //Проверить, есть ли в клетке забор
    public boolean isHasFence() {
        if (hasFence != null){
            return true;
        }

        return false;
    }

    //Узнать, что за объект находится в клетке
    public Object checkObject(){

        if(isHasCabbage()){
            return hasCabbage;
        }


        if(isHasBarrel()){
            return hasBarrel;
        }

        if(isHasFence()){
            return hasFence;
        }

        return null;
    }



    //////////////////////////////////////////////////////////////////////////

    //Установить капусту в конкретную клетку
    public void setHasCabbage(Cabbage hasCabbage) {
        this.hasCabbage = hasCabbage;
    }

    //Установить бочку в конкретную клетку
    public void setHasBarrel(Barrel hasBarrel) {
        this.hasBarrel = hasBarrel;
    }

    //Установить забор в конкретную клетку
    public void setHasFence(Fence hasFence) {
        this.hasFence = hasFence;
    }

    /////////////////////////////////////////////////////////////////
    //Установить координаты клетки (использоваться будет при инициализации)

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Брать значения X и Y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Добавляет объект
    public void setGoat(Goat goat){
        this.hasGoat = goat;
    }

    public Image getGrave() {
        return grave;
    }*/
}
