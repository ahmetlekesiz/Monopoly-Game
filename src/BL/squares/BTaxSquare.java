package BL;

import DAL.DPlayer;
import DAL.DInstruction;

/**
 * <h>BTaxSquare</h>
 *
 * <p>We extend the class from BSquare to decide square type.</p>
 *
 * @author Salih ÖZYURT
 * @version 1.0
 *
 */
public class BTaxSquare extends BSquare {

    private final String SQUARE_TYPE = "TAX_SQUARE";
    private final DInstruction DInstructionInstance = DInstruction.getInstance();

    /**
     * <p>We use the method to set current player balance. Because, player balance decreases in tax square.</p>
     *
     * @param player We use the parameter to reach current Player.
     * @return void
     */
    @Override
    public void performOnLand(DPlayer player) {
        player.setBalance(player.getBalance() - (int) DInstructionInstance.priceOfTaxSquares);
    }

    /**
     * <p>The method is getter method to square type.</p>
     *
     * @return void
     */
    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
