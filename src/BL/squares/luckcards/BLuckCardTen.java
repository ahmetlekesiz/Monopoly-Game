package BL.squares.luckcards;

import DAL.DInstruction;
import DAL.DPlayer;

public class BLuckCardTen extends BLuckCards {
    private final String CARD_INFO = "Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        // Illinois Jail square ye göre location ayarlanacak
        if(dPlayer.getLocation() > 13){
            dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() - (dPlayer.getLocation() - 13));
        }else {
            dPlayer.setTotalDiceValue(13 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        }
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
