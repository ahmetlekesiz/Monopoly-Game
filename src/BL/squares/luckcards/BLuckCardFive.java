package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardFive extends BLuckCards {
    private final String CARD_INFO = "Advance token to nearest Utility. If unowned, you may buy" +
                                     " it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown.";

    @Override
    public void performForCard(DPlayer dPlayer) {

    }

    @Override
    public String getCARD_INFO() {
        return null;
    }
}
