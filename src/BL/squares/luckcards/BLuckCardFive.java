package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardFive extends BLuckCards {

    public BLuckCardFive() {
        setCARD_INFO("Advance token to nearest Utility. If unowned, you may buy" +
                     " it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown.");
        setCardID(5);
    }

    @Override //TODO Utility square ye ve sahibi var veya yoksa ya göre ayarlanacak
    public void performForCard(DPlayer dPlayer) {

    }
}
