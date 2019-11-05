package BL;

import DAL.Instruction;

public class BGoSquare extends BSquare{
    private final String SQUARE_TYPE = "B_GO_SQUARE";
    private final Instruction instance = Instruction.getInstance();

    @Override
    public void performOnLand(BPlayer player) {
        player.balance += instance.priceOfGoSquare;
    }
}
