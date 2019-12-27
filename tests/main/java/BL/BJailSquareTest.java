package main.java.BL;

import main.java.DAL.DPiece;
import main.java.DAL.DPlayer;
import org.junit.jupiter.api.BeforeAll;

class BJailSquareTest {

    private static DPlayer dPlayer;

    @BeforeAll
    static void beforeAllTestMethod() {
        dPlayer = new DPlayer(DPiece.PieceType.BATTLESHIP, 1000);
    }

}