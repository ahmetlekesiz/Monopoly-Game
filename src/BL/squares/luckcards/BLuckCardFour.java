package BL.squares.luckcards;

import DAL.DInstruction;
import DAL.DPlayer;

public class BLuckCardFour extends BLuckCards {
    private final String CARD_INFO = "Advance to St. Charles Place. If you pass Go, collect $200. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        // Illinois Avenue ya göre location ayarlanacak
        if(dPlayer.getLocation() > 13){
            dPlayer.setTotalDiceValue(40 + 13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
            dPlayer.setBalance(dPlayer.getBalance() + (int) DInstruction.getInstance().priceOfGoSquare);
        }else {
            dPlayer.setTotalDiceValue(13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        }
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
