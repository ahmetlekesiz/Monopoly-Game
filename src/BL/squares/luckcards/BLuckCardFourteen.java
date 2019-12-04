package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardFourteen extends BLuckCards {
    private final String CARD_INFO = "Take a walk on the Boardwalk. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        // Boardwalk. square ye göre location ayarlanacak
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
