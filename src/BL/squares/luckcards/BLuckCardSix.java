package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardSix extends BLuckCards {
    private final String CARD_INFO = "Advance token to the nearest Railroad and pay owner twice the rental to which" +
                                     " he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.";

    @Override
    public void performForCard(DPlayer dPlayer) {
        //Utility square ye ve sahibi var veya yoksa ya göre ayarlanacak
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
