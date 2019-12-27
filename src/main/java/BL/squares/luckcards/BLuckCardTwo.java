package main.java.BL.squares.luckcards;

import main.java.DAL.DInstruction;
import main.java.DAL.DPlayer;

public class BLuckCardTwo extends BLuckCards {

    public BLuckCardTwo() {
        setCARD_INFO("Advance to Go Square.");
        setCardID(2);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setTotalDiceValue(40 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        dPlayer.setBalance(dPlayer.getBalance() + (int) DInstruction.getInstance().priceOfGoSquare);
    }
}
