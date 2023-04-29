import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldGeneratorTest {

    @Test
    void generateField() {
        Field field = new Field();

        //Проверяем рандомную клетку в центре поля
        assertEquals(null, field.getCells(3, 5).getObject());

        if(field.getCells(0,0).getObject() instanceof Fence){
            assertEquals(3, 3);
        } else assertEquals(3,4);

        if(field.getCells(0,7).getObject() instanceof Fence){
            assertEquals(3, 3);
        } else assertEquals(3,4);

        if(field.getCells(9,9).getObject() instanceof Fence){
            assertEquals(3, 3);
        } else assertEquals(3,4);
    }
}