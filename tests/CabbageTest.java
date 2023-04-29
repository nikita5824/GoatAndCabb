import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabbageTest {


    @Test
    void createCabbage() {
        Field field = new Field();
        Cabbage cabbage = new Cabbage(1, 2, field);

        if(field.getCells(1, 2).getObject() instanceof Cabbage){
            assertEquals(1,1);
        } else{
            assertEquals(1, 2);
        }
    }

    @Test
    void createCabbageInFence() {
        Field field = new Field();

        assertThrows(RuntimeException.class, () -> new Cabbage(1, 0, field));
    }

}