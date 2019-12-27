package main.java.BL.squares.communitychestcards;

import main.java.DAL.DInstruction;
import main.java.DAL.DPlayer;

public class BCommunityCardOne extends BCommunityCards {

    public BCommunityCardOne(){
        setCARD_INFO("Advance to Go Square.");
        setCardID(1);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setTotalDiceValue(40 - dPlayer.getLocation() + dPlayer.getTotalDiceValue());
        dPlayer.setBalance(dPlayer.getBalance() + (int) DInstruction.getInstance().priceOfGoSquare);
    }
}
