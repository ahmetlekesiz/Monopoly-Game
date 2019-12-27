package main.java.BL.squares.luckcards;

import main.java.DAL.DPlayer;

public class BLuckCardSixteen extends BLuckCards {

    public BLuckCardSixteen() {
        setCARD_INFO("Your building and loan matures. Collect $150. ");
        setCardID(16);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() + 150);
    }
}
