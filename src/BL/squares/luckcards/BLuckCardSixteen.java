package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardSixteen extends BLuckCards {
    private final String CARD_INFO = "Your building and loan matures. Collect $150.";

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() + 150);
    }

    @Override
    public String getCARD_INFO() {
        return null;
    }
}
