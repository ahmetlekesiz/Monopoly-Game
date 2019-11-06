package BL;

import DAL.DPlayer;
import DAL.Instruction;

public class BGoSquare extends BSquare {
    private final String SQUARE_TYPE = "GO_SQUARE";
    private final Instruction instructionInstance = Instruction.getInstance();

    @Override
    public void performOnLand(DPlayer player) {
        player.setBalance(player.getBalance() + (int) instructionInstance.priceOfGoSquare);
    }
}
