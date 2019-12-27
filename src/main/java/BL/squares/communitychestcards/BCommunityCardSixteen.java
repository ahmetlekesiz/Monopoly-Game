package main.java.BL.squares.communitychestcards;

import main.java.DAL.DPlayer;

public class BCommunityCardSixteen extends BCommunityCards{

    public BCommunityCardSixteen(){
        setCARD_INFO("You inherit $100.");
        setCardID(16);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance() + 100);
    }
}
