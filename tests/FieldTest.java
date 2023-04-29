import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getFieldRows() {
        Field field = new Field();
        assertEquals(10, field.getRows());
    }

    @Test
    void getFieldCols() {
        Field field = new Field();
        assertEquals(10, field.getRows());
    }

    @Test
    void getFieldWidth() {
        Field field = new Field();
        assertEquals(500, field.getWidthOfField());
    }

    @Test
    void getFieldHeight() {
        Field field = new Field();
        assertEquals(500, field.getHeightOfField());
    }

    @Test
    void getFieldCells() {
        Field field = new Field();
        Cell cell = new Cell(3, 5);
        assertEquals(cell.getX(), field.getCells(3, 5).getX());
        assertEquals(cell.getY(), field.getCells(3, 5).getY());
    }

    @Test
    void getFieldRemoveObject() {
        Field field = new Field();
        Barrel barrel = new Barrel(3, 5, field);

        assertEquals(barrel, field.getCells(3, 5).getObject());

        field.removeObject(3, 5);

        assertEquals(null, field.getCells(3, 5).getObject());
    }



}