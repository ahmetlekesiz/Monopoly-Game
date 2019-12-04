package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardSeven extends BLuckCards {
    private final String CARD_INFO = "Bank pays you dividend of $50. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance( dPlayer.getBalance() + 50);
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
