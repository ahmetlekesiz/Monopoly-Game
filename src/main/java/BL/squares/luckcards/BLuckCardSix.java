package main.java.BL.squares.luckcards;

import main.java.DAL.DPlayer;

public class BLuckCardSix extends BLuckCards {

    public BLuckCardSix() {
        setCARD_INFO("Advance token to the nearest Railroad and pay owner twice the rental to which" +
                     " he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
        setCardID(6);
    }

    @Override //TODO Utility square ye ve sahibi var veya yoksa ya göre ayarlanacak
    public void performForCard(DPlayer dPlayer) {

    }
}
