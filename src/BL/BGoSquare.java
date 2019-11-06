package BL;

import DAL.DPlayer;
import DAL.DInstruction;

public class BGoSquare extends BSquare {
    private final String SQUARE_TYPE = "GO_SQUARE";
    private final DInstruction DInstructionInstance = DInstruction.getInstance();

    @Override
    public void performOnLand(DPlayer player) {
        player.setBalance(player.getBalance() + (int) DInstructionInstance.priceOfGoSquare);
    }
}
