package main.java.BL.squares.luckcards;

import main.java.DAL.DPlayer;

public class BLuckCardOne extends BLuckCards{

    public BLuckCardOne() {
        setCARD_INFO("You have won a crossword competition. Collect $100");
        setCardID(1);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() + 100);
    }
}
