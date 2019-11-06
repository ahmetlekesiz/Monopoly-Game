package BL;

import DAL.DPlayer;
import DAL.Instruction;

public class BTaxSquare extends BSquare {

    private final String SQUARE_TYPE = "TAX_SQUARE";
    private final Instruction instructionInstance = Instruction.getInstance();

    @Override
    public void performOnLand(DPlayer player) {
        player.setBalance(player.getBalance() - (int) instructionInstance.priceOfTaxSquares);
    }
}
