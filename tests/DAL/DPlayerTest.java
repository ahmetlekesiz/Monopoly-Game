package DAL;

import BL.BDice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DPlayerTest {

    private static DPlayer dPlayer;

    @BeforeAll
    static void beforeAllTestMethod() {
        dPlayer = new DPlayer(DPiece.PIECE_TYPE.values()[(int) (Math.random() * 8)], 1000);
    }

    @Test
    void getCurrentDiceVal() {
        dPlayer.setCurrentDiceVal(13);
        assertEquals(13, dPlayer.getCurrentDiceVal());
    }

    @Test
    void getLocation() {
        dPlayer.setTotalDiceValue(553);
        assertEquals(33, dPlayer.getLocation());
    }

    @Test
    void getBalance() {
        assertEquals(1000, dPlayer.getBalance());
    }

    @Test
    void getCycleCounter() {
        dPlayer.setCycleCounter(7);
        assertEquals(7, dPlayer.getCycleCounter());
    }

    @Test
    void getTotalDiceValue() {
        dPlayer.setTotalDiceValue(5214);
        assertEquals(5214, dPlayer.getTotalDiceValue());
    }

    @Test
    void getPlayerDice() {
        assertNotNull(dPlayer.getPlayerDice());
    }

    @Test
    void isBankrupted() {
        dPlayer.setBankruptFlag(true);
        assertTrue(dPlayer.isBankrupted());
    }

    @Test
    void getPiece_type() {
        dPlayer.setPiece_type(DPiece.PIECE_TYPE.RACING_CAR);
        assertEquals(DPiece.PIECE_TYPE.RACING_CAR, dPlayer.getPiece_type());
    }
}