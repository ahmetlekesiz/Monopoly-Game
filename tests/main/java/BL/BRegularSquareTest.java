package main.java.BL;

import main.java.BL.squares.BRegularSquare;
import main.java.BL.squares.PropertyType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BRegularSquareTest {

    @Test
    void getSQUARE_TYPE() {
        BRegularSquare bRegularSquare = new BRegularSquare(PropertyType.NOCOLOR);
        assertEquals("REGULAR_SQUARE", bRegularSquare.getSQUARE_TYPE());
    }
}