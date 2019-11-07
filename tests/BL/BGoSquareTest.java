package BL;

import Controller.Main;
import DAL.DInstruction;
import DAL.DJSONReader;
import DAL.DPiece;
import DAL.DPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BGoSquareTest {

    private static DPlayer dPlayer;

    @BeforeAll
    static void beforeAllTestMethod() {
        dPlayer = new DPlayer(DPiece.PIECE_TYPE.values()[(int) (Math.random() * 8)], 1000);
    }

    @Test
    void performOnLand() {
        DJSONReader djsonReader = new DJSONReader(Main.INSTRUCTION_FILENAME);
        djsonReader.initInstructionObject();
        DInstruction instruction = DInstruction.getInstance();
        BGoSquare bGoSquare = new BGoSquare();
        bGoSquare.performOnLand(dPlayer);
        assertEquals(1000 + instruction.priceOfGoSquare, dPlayer.getBalance());
    }
}