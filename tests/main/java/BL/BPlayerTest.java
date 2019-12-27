package main.java.BL;

import main.java.DAL.DPiece;
import main.java.DAL.DPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BPlayerTest {

    private static main.java.BL.BPlayer bPlayer;
    private static DPlayer dPlayer;

    @BeforeAll
    static void beforeAllTestMethod() {
        dPlayer = new DPlayer(DPiece.PieceType.values()[(int) (Math.random() * 8)], 1000);
        bPlayer = new main.java.BL.BPlayer(dPlayer);
    }

    @Test
    void rollDice() {
        int total = bPlayer.rollDice();
        assertEquals(total, bPlayer.getDPlayer().getCurrentDiceVal());
    }

    @Test
    void getDPlayer() {
        assertEquals(dPlayer, bPlayer.getDPlayer());
    }
}