package BL;

import DAL.DPlayer;
import DAL.DInstruction;

public class BTaxSquare extends BSquare {

    private final String SQUARE_TYPE = "TAX_SQUARE";
    private final DInstruction DInstructionInstance = DInstruction.getInstance();

    public BTaxSquare(int id){
        this.setId(id);
    }
    @Override
    public void performOnLand(DPlayer player) {
        player.setLocation(player.getTotalDiceValue()%40);
        player.setBalance(player.getBalance() - (int) DInstructionInstance.priceOfTaxSquares);
    }
}
