package main.java.BL.squares.communitychestcards;

import main.java.DAL.DPlayer;

public class BCommunityCardFourteen extends BCommunityCards{

    public BCommunityCardFourteen(){
        setCARD_INFO("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.");
        setCardID(14);
    }

    @Override //TODO Oyuncuların sahiplik durumuna göre değişiklik gösterecek
    public void performForCard(DPlayer dPlayer) {

    }
}
