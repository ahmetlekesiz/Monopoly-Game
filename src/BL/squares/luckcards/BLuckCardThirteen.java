package BL.squares.luckcards;

import DAL.DInstruction;
import DAL.DPlayer;

public class BLuckCardThirteen extends BLuckCards {

    public BLuckCardThirteen() {
        setCARD_INFO("Take a trip to Reading Railroad. If you pass Go, collect $200. ");
        setCardID(13);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        // Reading Railroad ya göre location ayarlanacak
        if(dPlayer.getLocation() > 13){
            dPlayer.setTotalDiceValue(40 + 13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
            dPlayer.setBalance(dPlayer.getBalance() + (int) DInstruction.getInstance().priceOfGoSquare);
        }else {
            dPlayer.setTotalDiceValue(13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        }
    }
}
