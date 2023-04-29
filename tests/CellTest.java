import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void createCell() {
        Cell cell = new Cell(1, 4);
        assertEquals(1, cell.getX());
        assertEquals(4, cell.getY());
    }

    @Test
    void cellGetObject() {
        Cell cell = new Cell(1, 4);
        assertEquals(null, cell.getObject());
    }

    @Test
    void cellAddObject() {
        Field field = new Field();
        Fence fence = new Fence(1, 4, field);
        assertEquals(fence, field.getCells(1,4).getObject());
    }

    @Test
    void cellRemoveObjectNull() {
        Field field = new Field();
        Fence fence = new Fence(1, 4, field);
        assertThrows(RuntimeException.class, () -> field.getCells(1, 5).removeObject());
    }

    @Test
    void cellRemoveObject1() {
        Field field = new Field();
        Fence fence = new Fence(1, 5, field);
        assertEquals(fence, field.getCells(1, 5).getObject());
        field.getCells(1, 5).removeObject();
        assertEquals(null, field.getCells(1, 5).getObject());
    }

    @Test
    void cellRemoveObject2() {
        Field field = new Field();
        if(field.getCells(0, 7).getObject() instanceof Fence){
            field.getCells(0, 7).removeObject();
            assertEquals(null, field.getCells(0, 7).getObject());
        }else throw new RuntimeException("brr");
    }

    @Test
    void cellAddBarrelException() {
        Field field = new Field();

        assertThrows(RuntimeException.class, () -> new Barrel(0,0, field));
    }

    @Test
    void cellAddBarrelAndRemove1() {
        Field field = new Field();
        Barrel barrel = new Barrel(3, 5, field);

        if(field.getCells(3, 5).getObject() instanceof Barrel){
            field.getCells(3, 5).removeObject();
            assertEquals(null, field.getCells(3, 5).getObject());
        }else throw new RuntimeException("brr");
    }

    @Test
    void cellGetObjects() {
        Field field = new Field();
        Barrel barrel = new Barrel(5, 3, field);

        assertEquals(barrel, field.getCells(5, 3).getBarrel());
        assertEquals(null, field.getCells(5, 3).getFence());
        assertEquals(null, field.getCells(5, 3).getCabbage());
        assertEquals(null, field.getCells(5, 3).getGrass());
        assertEquals(null, field.getCells(5, 3).getGoat());
        if (field.getCells(1, 0).getFence() instanceof Fence){
            assertEquals(1, field.getCells(1, 0).getX());
        } else throw new RuntimeException("brr");
    }

    //addCabbage()
    @Test
    void cellAddBarrel() {
        Field field = new Field();
        Barrel barrel = new Barrel(field);

        //Добавить в field addBarrel, addGrass, чтобы можно было инициализировать x, y этих полей
        field.addObject(5, 4, barrel);
        assertEquals(barrel, field.getCells(5,4).getObject());
    }


    //addGrass()
    //addFence()
    //addBarrel()



}