package main.java.BL.squares.communitychestcards;

import main.java.DAL.DPlayer;

public class BCommunityCardThree extends BCommunityCards {

    public BCommunityCardThree(){
        setCARD_INFO("Doctor's fees. Pay $50.");
        setCardID(3);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() - 50);
    }
}
