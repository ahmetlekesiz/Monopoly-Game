package BL;

import BL.squares.BJailSquare;
import BL.squares.PropertyType;
import Controller.Main;
import DAL.DInstruction;
import DAL.DJSONReader;
import DAL.DPiece;
import DAL.DPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BJailSquareTest {

    private static DPlayer dPlayer;

    @BeforeAll
    static void beforeAllTestMethod() {
        dPlayer = new DPlayer(DPiece.PieceType.BATTLESHIP, 1000);
    }

    @Test
    void performOnLand() {
        DJSONReader djsonReader = new DJSONReader(Main.INSTRUCTION_FILENAME);
        djsonReader.initInstructionObject();
        BJailSquare bJailSquare = new BJailSquare(PropertyType.BLUE);
        bJailSquare.performOnLand(dPlayer);
        assertTrue(dPlayer.isArrested());
        assertEquals(bJailSquare.getJailRecords().get(dPlayer), 0);
        for (int index =  0; index < 3; ++index) {
            bJailSquare.scanJailRecords();
            if (!bJailSquare.getJailRecords().isEmpty()) {
                assertTrue(dPlayer.isArrested());
                assertEquals(bJailSquare.getJailRecords().get(dPlayer), index + 1);
            } else {
                assertFalse(dPlayer.isArrested());
                return;
            }
        }
        bJailSquare.scanJailRecords();
        assertFalse(dPlayer.isArrested());
        assertEquals(dPlayer.getBalance(), 1000 - DInstruction.getInstance().priceOfJailSquare);
    }
}