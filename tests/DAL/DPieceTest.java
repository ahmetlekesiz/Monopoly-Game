package DAL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DPieceTest {

    @Test
    @DisplayName("PIECE_TYPE Test")
    void getValue() {
        assertEquals(2, DPiece.PIECE_TYPE.BOOT.getValue());
    }

}