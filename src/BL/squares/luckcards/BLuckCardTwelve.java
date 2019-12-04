package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardTwelve extends BLuckCards {
    private final String CARD_INFO = "Pay poor tax of $15. ";

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() - 15);
    }

    @Override
    public String getCARD_INFO() {
        return null;
    }
}
