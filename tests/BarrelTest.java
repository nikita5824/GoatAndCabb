import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BarrelTest {

    //Не выскакивает исключения
    @Test
    void setBarrelWithoutXY() {
        Barrel barrel = new Barrel(new Field());
        System.out.println(barrel.getX() +" "+ barrel.getY());
    }

    //Ставим неправильную позицию
    @Test
    void setBarrelFalse() {
        assertThrows(RuntimeException.class, ()->new Barrel(10, 25, new Field()));
    }

    //Переделываем на неправильную позицию
    @Test
    void setBarrelFalseX() {
        Barrel barrel = new Barrel(5, 5, new Field());
        assertThrows(RuntimeException.class, ()->barrel.setX(32));
    }

    //Переделываем на неправильную позицию
    @Test
    void setBarrelFalseY() {
        Barrel barrel = new Barrel(5, 5, new Field());
        assertThrows(RuntimeException.class, ()->barrel.setY(32));
    }

    //Получить координату X
    @Test
    void getX() {
        Barrel barrel = new Barrel(5, 5, new Field());
        assertEquals(5, barrel.getX());
    }

    //Получить координату Y
    @Test
    void getY() {
        Barrel barrel = new Barrel(5, 4, new Field());
        assertEquals(4, barrel.getY());
    }

    //Получить изображение barrel
    @Test
    void getBarrel() {
        ImageIcon imageBarrel = new ImageIcon("pictures/barrel.bin");
        Image barrel = imageBarrel.getImage();

        Barrel newBarrel = new Barrel(5, 5, new Field());

        assertEquals(barrel, newBarrel.getBarrel());
    }

    //Проверить позицию barrel по переданным координатам dx, dy
    @Test
    void checkPosition() {
        Field field = new Field();
       // Fence fence = new Fence(1, 3, field);

        Barrel barrel = new Barrel(1, 2, field);

        assertEquals(null, barrel.checkPosition(0, 1));
    }

    //barrel проверяет позицию, в которой забор
    @Test
    void checkPositionWithFence() {
        Field field = new Field();
        Fence fence = new Fence(1, 3, field);

        Barrel barrel = new Barrel(1, 2, field);

        assertEquals(fence,barrel.checkPosition(0, 1));
    }

    //Если забор указывает на позицию забора по краям
    @Test
    void checkPositionWithFence2() {
        Field field = new Field();
        Fence fence = (Fence)field.getCells(1, 0).getObject();

        Barrel barrel = new Barrel(1, 1, field);

        assertEquals(fence,barrel.checkPosition(0, -1));
    }

    //Если забор указывает на позицию капусты
    @Test
    void checkPositionWithCabbage() {
        Field field = new Field();
        Cabbage cabbage = new Cabbage(3, 3, field);

        Barrel barrel = new Barrel(2, 3, field);

        assertEquals(cabbage,barrel.checkPosition(1, 0));
    }

    //Движение на единицу вперед по Y
    @Test
    void move() {
        Field field = new Field();
        //Fence fence = new Fence(1, 3, field);

        Barrel barrel = new Barrel(1, 2, field);

        barrel.move(0, 1);

        assertEquals(barrel, field.getCells(1, 3).getObject());

    }

    //Движение на единицу назад по Y
    @Test
    void moveNegative() {
        Field field = new Field();
        //Fence fence = new Fence(1, 3, field);

        Barrel barrel = new Barrel(1, 2, field);

        barrel.move(0, -1);

        assertEquals(barrel, field.getCells(1, 1).getObject());

    }

    //Движение в забор
    @Test
    void moveInFence() {
        Field field = new Field();
        //Fence fence = new Fence(1, 3, field);

        Barrel barrel = new Barrel(1, 1, field);

        //assertEquals(barrel, field.getCells(1, 1).getObject());
        assertThrows(RuntimeException.class, ()->barrel.move(0, -1));

        //Если все объекты остались на своих местах, то все хорошо
        if(field.getCells(1, 0).getObject() instanceof Fence &&
        field.getCells(1,1).getObject() instanceof Barrel){
            assertEquals(1, 1);
        } else{
            assertEquals(1, 2);
        }
    }



}