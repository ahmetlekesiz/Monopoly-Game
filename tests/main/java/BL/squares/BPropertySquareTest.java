package main.java.BL.squares;

import main.java.DAL.DPiece;
import main.java.DAL.DPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BPropertySquareTest {

    private static DPlayer owner;
    private static DPlayer renter;

    @BeforeAll
    static void beforeAllTestMethod() {
        owner = new DPlayer(DPiece.PieceType.values()[(int) (Math.random() * 8)], 1000);
        renter = new DPlayer(DPiece.PieceType.values()[(int) (Math.random() * 8)], 1000);
    }

    @Test
    void getRentTest() {

    }
}