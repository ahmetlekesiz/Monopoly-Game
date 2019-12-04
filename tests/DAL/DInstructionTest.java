package DAL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DInstructionTest {

    @Test
    void testToString() {
        DInstruction dInstruction = DInstruction.getInstance(2,
                1000, 4, 40, 50, 25);
        String string = "countOfPlayers: 2\nstartMoney: 1000\ncountOfTaxSquares: 4\npriceOfTaxSquares: 40\n" +
                "priceOfGoSquare: 50\npriceOfJailSquare: 25";
        assertEquals(string, dInstruction.toString());
    }
}