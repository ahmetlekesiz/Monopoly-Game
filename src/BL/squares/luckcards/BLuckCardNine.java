package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardNine extends BLuckCards {
    private final String CARD_INFO = "Go Back Three Spaces. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() - 3);
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
