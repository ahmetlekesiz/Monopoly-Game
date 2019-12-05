package BL.squares.luckcards;

import DAL.DInstruction;
import DAL.DPlayer;

public class BLuckCardTen extends BLuckCards {

    public BLuckCardTen() {
        setCARD_INFO("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200. ");
        setCardID(10);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        // Illinois Jail square ye göre location ayarlanacak
        if(dPlayer.getLocation() > 13){
            dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() - (dPlayer.getLocation() - 13));
        }else {
            dPlayer.setTotalDiceValue(13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        }
    }
}
