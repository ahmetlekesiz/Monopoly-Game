package BL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BRegularSquareTest {

    @Test
    void getSQUARE_TYPE() {
        BRegularSquare bRegularSquare = new BRegularSquare();
        assertEquals("REGULAR_SQUARE", bRegularSquare.getSQUARE_TYPE());
    }
}