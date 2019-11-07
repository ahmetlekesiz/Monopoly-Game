package BL;

import DAL.DPlayer;
import DAL.DInstruction;

public class BTaxSquare extends BSquare {

    private final String SQUARE_TYPE = "TAX_SQUARE";
    private final DInstruction DInstructionInstance = DInstruction.getInstance();

    @Override
    public void performOnLand(DPlayer player) {
        player.setBalance(player.getBalance() - (int) DInstructionInstance.priceOfTaxSquares);
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
