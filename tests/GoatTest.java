import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoatTest {


    @Test
    void move() {
        Field field = new Field();
        Goat goat = new Goat(3, 4, field);


        goat.move(0, 1);

        assertEquals(5, goat.getCurrentY());
    }

    @Test
    void moveBarrel1() {
        Field field = new Field();
        Barrel barrel = new Barrel(3, 5, field);
        Goat goat = new Goat(3, 4, field);

        goat.moveBarrel(0, 1, barrel, Direction.south(), false);

        assertEquals(5, goat.getCurrentY());
        assertEquals(6, barrel.getY());
    }

    @Test
    void moveBarrel2() {
        Field field = new Field();
        Barrel barrel = new Barrel(3, 5, field);
        Goat goat = new Goat(3, 4, field);

        goat.moveBarrel(0, 1, barrel, Direction.south(), true);

        assertEquals(5, goat.getCurrentY());
        assertEquals(6, barrel.getY());
    }


    @Test
    void eatCabbageAndGrass() {

    }

    @Test
    void isCabbageEaten() {
    }
}