package BL;

import DAL.Instruction;

public class BGoSquare extends BSquare{
    private final String SQUARE_TYPE = "B_GO_SQUARE";
    private final Instruction instructionInstance = Instruction.getInstance();

    @Override
    public void performOnLand(BPlayer player) {
        player.setBalance(player.getBalance() + (int) instructionInstance.priceOfGoSquare);
    }
}
