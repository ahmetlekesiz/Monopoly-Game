package BL.squares.luckcards;

import DAL.DInstruction;
import DAL.DPlayer;

public class BLuckCardThree extends BLuckCards{

    public BLuckCardThree() {
        setCARD_INFO("Advance to Illinois Avenue. If you pass Go, collect $200. ");
        setCardID(3);
    }

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
}
