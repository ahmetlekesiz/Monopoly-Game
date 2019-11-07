package BL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BDiceTest {

    @Test
    @DisplayName("Test ")
    void rollDice() {
        BDice bDice = new BDice();
        int[] diceValues = bDice.rollDice();
        assertNotEquals(diceValues[0], diceValues[1]);
    }
}